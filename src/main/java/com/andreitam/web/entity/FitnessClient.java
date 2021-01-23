package com.andreitam.web.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
/**
 * Class FitnessClient Entity is
 * the user who is booking the classes
 *
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
@Entity
@Table(name = "fitness_clients")
public class FitnessClient {
    @Id
    private UUID id;
    private String name;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;
    private String gender;
    private Boolean is_active;

    public FitnessClient() {}

    public FitnessClient(String name, String emailAddress, String password,
                         String phoneNumber, LocalDate birthDate, String gender, Boolean is_active) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.is_active = is_active;
    }

    public FitnessClient(UUID id,String name, String emailAddress, String password,
                         String phoneNumber, LocalDate birthDate, String gender, boolean is_active) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.is_active = is_active;
    }

    public FitnessClient(String name, String emailAddress,
                         String phoneNumber, LocalDate birthDate, String gender, boolean is_active) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.is_active = is_active;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
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

    public Boolean getIs_active() {
        return is_active;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "FitnessClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", is_active=" + is_active +
                '}';
    }

    @OneToOne(mappedBy = "fitnessClient")
    private FitnessGoogleClient fitnessGoogleClient;

    public FitnessGoogleClient getFitnessGoogleClient() {
        return fitnessGoogleClient;
    }

    public void setFitnessGoogleClient(FitnessGoogleClient fitnessGoogleClient) {
        this.fitnessGoogleClient = fitnessGoogleClient;
    }

    @OneToMany(mappedBy="fitnessClient")
    private Set<FitnessBooking> fitnessBookings;

    public Set<FitnessBooking> getFitnessBookings() {
        return fitnessBookings;
    }

}
