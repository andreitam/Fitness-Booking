package com.andreitam.web.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
/**
 * Class FitnessGoogleClient Entity is
 * a FitnessClient logged with GoogleSignIn.
 *
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
@Entity
@Table(name = "fitness_google_clients")
public class FitnessGoogleClient {
    @Id
    private UUID googleId;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate birthDate;
    private String gender;
    private Boolean is_power;

    public FitnessGoogleClient() {}

    public FitnessGoogleClient(String name, String emailAddress,
                               String phoneNumber, LocalDate birthDate, String gender, Boolean is_power, FitnessClient fitnessClient) {
        this.googleId = UUID.randomUUID();
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.is_power = is_power;
        this.fitnessClient = fitnessClient;
    }

    public UUID getGoogleId() {
        return googleId;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public Boolean getIs_power() {
        return is_power;
    }

    public void setGoogleId(UUID googleId) {
        this.googleId = googleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIs_power(Boolean is_power) {
        this.is_power = is_power;
    }

    @Override
    public String toString() {
        return "FitnessGoogleClient{" +
                "googleId=" + googleId +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", is_power=" + is_power +
                ", fitnessClient=" + fitnessClient +
                '}';
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private FitnessClient fitnessClient;

    public FitnessClient getFitnessClient() {
        return fitnessClient;
    }

    public void setFitnessClient(FitnessClient fitnessClinet) {
        this.fitnessClient = fitnessClinet;
    }
}
