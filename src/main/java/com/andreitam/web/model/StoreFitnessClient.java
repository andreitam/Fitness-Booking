package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessClient;

import java.util.List;
import java.util.UUID;
/**
 * Interface StoreFitnessClient for DAO class
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public interface StoreFitnessClient {
    FitnessClient getFitnessClient(UUID clientId);
    void addFitnessClient(FitnessClient fitnessClient);
    void updateFitnessClient(UUID clientId, FitnessClient fitnessClient);
    void deleteFitnessClient(UUID clientId);
    List<FitnessClient> getFitnessClients();
}
