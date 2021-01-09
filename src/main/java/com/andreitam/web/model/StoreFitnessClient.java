package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessClient;

import java.util.List;
import java.util.UUID;

public interface StoreFitnessClient {
    FitnessClient getFitnessClient(UUID clientId);
    void addFitnessClient(FitnessClient fitnessClient);
    void updateFitnessClient(UUID clientId, FitnessClient fitnessClient);
    void deleteFitnessClient(UUID clientId);
    List<FitnessClient> getFitnessClients();
}
