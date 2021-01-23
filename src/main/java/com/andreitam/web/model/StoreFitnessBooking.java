package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessBooking;
import com.andreitam.web.entity.FitnessClass;

import java.util.List;
import java.util.UUID;
/**
 * Interface StoreFitnessBooking for DAO class
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public interface StoreFitnessBooking {
    FitnessBooking getFitnessBooking(UUID bookingId);
    void addFitnessBooking(FitnessBooking fitnessBooking);
    void updateFitnessBooking(UUID bookingId, FitnessBooking fitnessBooking);
    void deleteFitnessBooking(UUID bookingId);
    List<FitnessBooking> getBookings();
}
