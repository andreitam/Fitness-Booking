package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessBooking;
import com.andreitam.web.entity.FitnessClass;

import java.util.List;
import java.util.UUID;

public interface StoreFitnessBooking {
    FitnessBooking getFitnessBooking(UUID bookingId);
    void addFitnessBooking(FitnessBooking fitnessBooking);
    void updateFitnessBooking(UUID bookingId, FitnessBooking fitnessBooking);
    void deleteFitnessBooking(UUID bookingId);
    List<FitnessBooking> getBookings();
}
