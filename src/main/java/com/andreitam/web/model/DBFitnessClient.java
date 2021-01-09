package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessClass;
import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.listener.LocalEntityManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBFitnessClient implements StoreFitnessClient {

    private final EntityManager entityManager;
    static final Logger logger = LogManager.getLogger();

    public DBFitnessClient(){
        entityManager = LocalEntityManagerFactory.createEntityManager();
    }

    @Override
    public FitnessClient getFitnessClient(UUID clientId) {
        return entityManager.find(FitnessClient.class, clientId);
    }

    @Override
    public void addFitnessClient(FitnessClient fitnessClient) {
        entityManager.getTransaction().begin();
        entityManager.persist(fitnessClient);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateFitnessClient(UUID clientId, FitnessClient fitnessClient) {
        FitnessClient updatedFitnessClient = entityManager.find(FitnessClient.class, clientId);
        System.out.println("client to be updated: "+updatedFitnessClient.toString());
        logger.warn("client to be updated: "+updatedFitnessClient.toString());
        updatedFitnessClient.setName(fitnessClient.getName());
        updatedFitnessClient.setEmailAddress(fitnessClient.getEmailAddress());
        updatedFitnessClient.setPassword(fitnessClient.getPassword());
        updatedFitnessClient.setBirthDate(fitnessClient.getBirthDate());
        updatedFitnessClient.setGender(fitnessClient.getGender());
        updatedFitnessClient.setIs_active(fitnessClient.getIs_active());
        entityManager.getTransaction().begin();
        entityManager.merge(updatedFitnessClient);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteFitnessClient(UUID clientId) {

    }

    @Override
    public List<FitnessClient> getFitnessClients() {
        return entityManager
                .createQuery("select fc from FitnessClient fc")
                .getResultList();
    }

    public List<FitnessClient> getFitnessClientsPagination(int page, int recordsPerPage) {
        List<FitnessClient> clientsList = entityManager.createQuery("SELECT fc FROM FitnessClient fc order by fc.id")
                .setMaxResults(recordsPerPage)
                .setFirstResult(page*recordsPerPage-recordsPerPage)
                .getResultList();
        System.out.println("page: "+page+" recordsPerPage: "+recordsPerPage);
        logger.warn("page: "+page+" recordsPerPage: "+recordsPerPage);
        for (FitnessClient fc: clientsList) {
            System.out.println(fc.toString());
            logger.info("pagination: "+fc.toString());
        }
        return clientsList;
    }

    public Long getNoOfRecords() {
        Query countQuery = entityManager.createQuery("SELECT count (fc.id) FROM FitnessClient fc");
        Long countResults = (Long) ((org.hibernate.query.Query) countQuery).uniqueResult();
        return countResults;
    }

}
