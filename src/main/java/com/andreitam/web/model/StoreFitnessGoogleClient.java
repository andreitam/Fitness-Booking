package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.entity.FitnessGoogleClient;

import java.util.List;
import java.util.UUID;

public interface StoreFitnessGoogleClient {
    FitnessGoogleClient getFitnessGoogleClient(UUID googleId);
    void addFitnessGoogleClient(FitnessGoogleClient fitnessGoogleClient);
    void updateFitnessGoogleClient(UUID googleId, FitnessGoogleClient fitnessGoogleClient);
    void deleteFitnessGoogleClient(UUID googleId);
    List<FitnessGoogleClient> getFitnessGoogleClients();
}
