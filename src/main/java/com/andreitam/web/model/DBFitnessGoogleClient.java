package com.andreitam.web.model;


import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.entity.FitnessGoogleClient;
import com.andreitam.web.listener.LocalEntityManagerFactory;


import javax.persistence.EntityManager;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * DAO class DBFitnessGoogleClient using persistence.api
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public class DBFitnessGoogleClient implements StoreFitnessGoogleClient{

    private final EntityManager entityManager;
    public DBFitnessGoogleClient(){
        entityManager = LocalEntityManagerFactory.createEntityManager();
    }
    /**
     * Method returns FitnessGoogleClient object from database
     *
     * @param googleId
     * @return FitnessGoogleClient
     */
    @Override
    public FitnessGoogleClient getFitnessGoogleClient(UUID googleId) {
        return entityManager.find(FitnessGoogleClient.class, googleId);
    }
    /**
     * Method persists FitnessGoogleClient object into database
     *
     * @param fitnessGoogleClient
     */
    @Override
    public void addFitnessGoogleClient(FitnessGoogleClient fitnessGoogleClient) {
        entityManager.getTransaction().begin();
        entityManager.persist(fitnessGoogleClient);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
    /**
     * Method updates persisted FitnessGoogleClient object from database
     *
     * @param googleId, fitnessGoogleClient
     */
    @Override
    public void updateFitnessGoogleClient(UUID googleId, FitnessGoogleClient fitnessGoogleClient) {

    }
    /**
     * Method deletes persisted FitnessGoogleClient object from database
     *
     * @param googleId
     */
    @Override
    public void deleteFitnessGoogleClient(UUID googleId) {

    }
    /**
     * Method returns list with FitnessGoogleClient objects from database
     *
     * @return List<FitnessGoogleClient>
     */
    @Override
    public List<FitnessGoogleClient> getFitnessGoogleClients() {
        return entityManager
                .createQuery("select fgc from FitnessGoogleClient fgc")
                .getResultList();
    }
}
