package com.andreitam.web.service;

import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.entity.FitnessGoogleClient;
import com.andreitam.web.model.DBFitnessGoogleClient;
import com.google.api.services.people.v1.model.*;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GoogleUserService {
    private DBFitnessGoogleClient dataBaseGoogle;
    private FitnessGoogleClient fitnessGoogleClient;
    private FitnessClient fitnessClient;
    private List<FitnessGoogleClient> users;
    private static GoogleUserService instance;
    static final Logger logger = LogManager.getLogger();

    private GoogleUserService() {
        this.dataBaseGoogle = new DBFitnessGoogleClient();
    }
    //get instance singleton
    public static GoogleUserService getInstance(){
        if(instance == null){
            instance = new GoogleUserService();
        }
        return instance;
    }
    //get email from Profile
    public String getEmailAddres(Person profile) {
        List<EmailAddress> emails = profile.getEmailAddresses();
        if (emails != null) {
            return emails.get(0).getValue();
        }
        return null;
    }
    //add user to db
    public void registerUser(Person profile) {
        String name="", email="";
        String phone, gender;
        LocalDate birthday;
        Boolean isPower;

        List<Name> names = profile.getNames();
        if (names != null) { name = names.get(0).getDisplayName(); }

        List<EmailAddress> emails = profile.getEmailAddresses();
        if (emails != null) { email = emails.get(0).getValue(); }

        List<PhoneNumber> phones = profile.getPhoneNumbers();
        if (phones != null) { phone = phones.get(0).getValue(); }
        else { phone = "0"; }

        List<Birthday> birthdays = profile.getBirthdays();
        if (birthdays != null) {
            String birthdayDateJson = birthdays.get(0).getDate().toString();
            //System.out.println(birthdayDateJson);
            SomeDate someDate = new Gson().fromJson(birthdayDateJson, SomeDate.class);
            birthday = LocalDate.of(someDate.year, someDate.month, someDate.day);
        }
        else { birthday = LocalDate.of(0,1,1);}

        List<Gender> genders = profile.getGenders();
        if (genders != null) { gender = genders.get(0).getValue(); }
        else { gender = "rather not say" ;}

        //power user
        isPower = this.isPowerUser(email);

        //create fitness client entity
        fitnessClient = new FitnessClient(name, email, phone, birthday, gender,true);
        System.out.println(fitnessClient.toString());
        //create fitness google client entity with fitness client foreign key
        fitnessGoogleClient = new FitnessGoogleClient(name, email, phone, birthday, gender, isPower, fitnessClient );
        //add to fitness google clinets table , and to fitness clients table for foreign key
        logger.warn("register user logged with google sign in: "+fitnessGoogleClient.toString());
        System.out.println("register user logged with google sign in: "+fitnessGoogleClient.toString());
        dataBaseGoogle.addFitnessGoogleClient(fitnessGoogleClient);
    }

    public FitnessGoogleClient authenticateGoogleUser(String emailAddress){
        //fill list with users from db
        users = new ArrayList<>();
        users.addAll(dataBaseGoogle.getFitnessGoogleClients());

        for(FitnessGoogleClient user: users){
            if(user.getEmailAddress().equals(emailAddress)){
                logger.warn("authenticated google user: "+user.toString());
                System.out.println("authenticated google user: "+user.toString());
                return user;
            }
        }
        return null;
    }

    public Boolean isPowerUser(String emailAddress) {
        if (emailAddress.equals(System.getenv("powerUser"))) {
            logger.warn("power user registered");
            System.out.println("power user registered");
            return true;
        }
        else return false;
    }

}

//helper class to convert json to local date
class SomeDate {
    public int day;
    public int month;
    public int year;
}
