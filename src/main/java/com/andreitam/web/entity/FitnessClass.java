package com.andreitam.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "fitness_classes")
public class FitnessClass {
    @Id
    private UUID id;
    private String className;
    private Integer setParticipants;
    private Integer registeredParticipants;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private boolean isActive;

    public FitnessClass() {}

    public FitnessClass(UUID id, String className, Integer setParticipants,
                        Integer registeredParticipants, LocalDateTime startDateTime, LocalDateTime endDateTime,
                        boolean isActive) {
        this.id = id;
        this.className = className;
        this.setParticipants = setParticipants;
        this.registeredParticipants = registeredParticipants;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.isActive = isActive;
    }

    public FitnessClass(String className, Integer setParticipants,
                        Integer registeredParticipants, LocalDateTime startDateTime, LocalDateTime endDateTime,
                        boolean isActive) {
        this.id = UUID.randomUUID();
        this.className = className;
        this.setParticipants = setParticipants;
        this.registeredParticipants = registeredParticipants;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public Integer getSetParticipants() {
        return setParticipants;
    }

    public Integer getRegisteredParticipants() {
        return registeredParticipants;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSetParticipants(Integer setParticipants) {
        this.setParticipants = setParticipants;
    }

    public void setRegisteredParticipants(Integer registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "FitnessClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", setParticipants=" + setParticipants +
                ", registeredParticipants=" + registeredParticipants +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitnessClass that = (FitnessClass) o;
        return isActive == that.isActive &&
                Objects.equals(id, that.id) &&
                Objects.equals(className, that.className) &&
                Objects.equals(setParticipants, that.setParticipants) &&
                Objects.equals(registeredParticipants, that.registeredParticipants) &&
                Objects.equals(startDateTime, that.startDateTime) &&
                Objects.equals(endDateTime, that.endDateTime) &&
                Objects.equals(fitnessBookings, that.fitnessBookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className, setParticipants, registeredParticipants, startDateTime, endDateTime, isActive, fitnessBookings);
    }

    @OneToMany(mappedBy="fitnessClass")
    private Set<FitnessBooking> fitnessBookings;

    public Set<FitnessBooking> getFitnessBookings() {
        return fitnessBookings;
    }
}

