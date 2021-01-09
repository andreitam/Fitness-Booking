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

public class DBFitnessGoogleClient implements StoreFitnessGoogleClient{

    private final EntityManager entityManager;
    public DBFitnessGoogleClient(){
        entityManager = LocalEntityManagerFactory.createEntityManager();
    }


    @Override
    public FitnessGoogleClient getFitnessGoogleClient(UUID googleId) {
        return entityManager.find(FitnessGoogleClient.class, googleId);
    }

    @Override
    public void addFitnessGoogleClient(FitnessGoogleClient fitnessGoogleClient) {
        entityManager.getTransaction().begin();
        entityManager.persist(fitnessGoogleClient);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateFitnessGoogleClient(UUID googleId, FitnessGoogleClient fitnessGoogleClient) {

    }

    @Override
    public void deleteFitnessGoogleClient(UUID googleId) {

    }

    @Override
    public List<FitnessGoogleClient> getFitnessGoogleClients() {
        return entityManager
                .createQuery("select fgc from FitnessGoogleClient fgc")
                .getResultList();
    }
}
