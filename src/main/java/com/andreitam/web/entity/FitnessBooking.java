package com.andreitam.web.entity;

import com.google.api.services.people.v1.model.Event;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
/**
 * Class FitnessBooking Entity is
 * the booking of a FitnessClass made by the FitnessClient
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
@Entity
@Table(name = "fitness_bookings")
public class FitnessBooking {
    @Id
    private UUID id;
    private LocalDateTime dateTimeBooking;
    private String eventId;

    public FitnessBooking() {}

    //constructor for adding booking with reference to classes table and user table
    public FitnessBooking(LocalDateTime dateTimeBooking, FitnessClient fitnessClient, FitnessClass fitnessClass, String eventId) {
        this.id = UUID.randomUUID();
        this.dateTimeBooking = dateTimeBooking;
        this.fitnessClient = fitnessClient;
        this.fitnessClass = fitnessClass;
        this.eventId = eventId;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDateTimeBooking() {
        return dateTimeBooking;
    }

    public String getEventId() {
        return eventId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDateTimeBooking(LocalDateTime dateTimeBooking) {
        this.dateTimeBooking = dateTimeBooking;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "FitnessBooking{" +
                "id=" + id +
                ", dateTimeBooking=" + dateTimeBooking +
                ", fitnessClient=" + fitnessClient +
                ", fitnessClass=" + fitnessClass +
                '}';
    }

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private FitnessClient fitnessClient;

    public FitnessClient getFitnessClient()
    {
        return fitnessClient;
    }

    public void setFitnessClient(FitnessClient fitnessClient) {
        this.fitnessClient = fitnessClient;
    }

    @ManyToOne
    @JoinColumn(name="class_id", nullable=false)
    private FitnessClass fitnessClass;

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }

    public void setFitnessClass(FitnessClass fitnessClass) {
        this.fitnessClass = fitnessClass;
    }
}
