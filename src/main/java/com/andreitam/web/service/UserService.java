package com.andreitam.web.service;

import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.entity.FitnessGoogleClient;
import com.andreitam.web.model.DBFitnessClient;
import com.andreitam.web.model.DBFitnessGoogleClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private DBFitnessClient dataBase;
    private DBFitnessGoogleClient dataBaseGoogle;
    private FitnessClient fitnessClient;
    private List<FitnessClient> users;
    private static UserService instance;
    static final Logger logger = LogManager.getLogger(UserService.class.getName());

    private UserService() {
        this.dataBase = new DBFitnessClient();
        this.dataBaseGoogle = new DBFitnessGoogleClient();

    }

    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public FitnessClient registerUser(String name, String email, String password, String phone, String birthday, String gender, Boolean active) {
        fitnessClient = new FitnessClient(name, email, password, phone,
                LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE), gender, active);
        dataBase.addFitnessClient(fitnessClient);
        System.out.println("registered fitness user: "+fitnessClient.toString());
        logger.warn("registered fitness user: "+fitnessClient.toString());
        return fitnessClient;
    }

    public FitnessClient authenticateUser(String email, String password){
        users = new ArrayList<>();
        users.addAll(dataBase.getFitnessClients());

        for(FitnessClient user: users){
            if(user.getEmailAddress().equals(email) && user.getPassword().equals(password)){
                System.out.println("authenticated fitness user: "+fitnessClient.toString());
                logger.warn("authenticated fitness user: "+user.toString());
                return user;
            }
        }
        return null;
    }

    public FitnessClient getClientFromUser(Object user, Object auth) {
        if (auth.equals("yes")) {
            FitnessGoogleClient fitnessGoogleClientFromSession = (FitnessGoogleClient) user;
            fitnessClient = dataBaseGoogle.getFitnessGoogleClient(fitnessGoogleClientFromSession.getGoogleId()).getFitnessClinet();
            System.out.println("authenticated user with google sign in is: "+fitnessClient.toString());
            logger.warn("authenticated user with google sign in is: "+fitnessClient.toString());
        }
        if (auth.equals("no")) {
            FitnessClient fitnessClientFromSession = (FitnessClient) user;
            fitnessClient = dataBase.getFitnessClient(fitnessClientFromSession.getId());
            System.out.println("authenticated user WITHOUT google sign in is: "+fitnessClient.toString());
            logger.warn("authenticated user WITHOUT google sign in is: "+fitnessClient.toString());
        }
        return fitnessClient;
    }

}
