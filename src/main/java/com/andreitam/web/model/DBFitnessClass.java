package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessClass;
import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.listener.LocalEntityManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DBFitnessClass implements StoreFitnessClass {

    private final EntityManager entityManager;
    static final Logger logger = LogManager.getLogger();

    public DBFitnessClass(){
        entityManager = LocalEntityManagerFactory.createEntityManager();
    }

    @Override
    public FitnessClass getFitnessClass(UUID classId) {
        return entityManager.find(FitnessClass.class, classId);
    }

    @Override
    public void addFitnessClass(FitnessClass fitnessClass) {
        entityManager.getTransaction().begin();
        entityManager.persist(fitnessClass);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateFitnessClass(UUID classId, FitnessClass fitnessClass) {
        FitnessClass updatedFitnessClass = entityManager.find(FitnessClass.class, classId);
        System.out.println("class to be updated: "+updatedFitnessClass.toString());
        logger.warn("class to be updated: "+updatedFitnessClass.toString());
        updatedFitnessClass.setClassName(fitnessClass.getClassName());
        updatedFitnessClass.setSetParticipants(fitnessClass.getSetParticipants());
        updatedFitnessClass.setRegisteredParticipants(fitnessClass.getRegisteredParticipants());
        updatedFitnessClass.setStartDateTime(fitnessClass.getStartDateTime());
        updatedFitnessClass.setEndDateTime(fitnessClass.getEndDateTime());
        updatedFitnessClass.setIsActive(fitnessClass.isIsActive());
        entityManager.getTransaction().begin();
        entityManager.merge(updatedFitnessClass);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteFitnessClass(UUID classId) {
        FitnessClass deletedFitnessClass = entityManager.find(FitnessClass.class, classId);
        System.out.println("class to be deleted: "+deletedFitnessClass.toString());
        logger.warn("class to be deleted: "+deletedFitnessClass.toString());
        entityManager.getTransaction().begin();
        entityManager.remove(deletedFitnessClass);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<FitnessClass> getFitnessClasses() {
        return entityManager
                .createQuery("select fcl from FitnessClass fcl")
                .getResultList();
    }

    public List<FitnessClass> getFitnessClassesPagination(int page, int recordsPerPage) {
        List<FitnessClass> classesList = entityManager.createQuery("SELECT f FROM FitnessClass f order by f.endDateTime")
                .setMaxResults(recordsPerPage)
                .setFirstResult(page*recordsPerPage-recordsPerPage)
                .getResultList();
        System.out.println("page: "+page+" recordsPerPage: "+recordsPerPage);
        logger.warn("page: "+page+" recordsPerPage: "+recordsPerPage);
        for (FitnessClass fc: classesList) {
            System.out.println(fc.toString());
            logger.warn("pagination: "+fc.toString());
        }
        return classesList;
    }

    public Long getNoOfRecords() {
        Query countQuery = entityManager.createQuery("SELECT count (f.id) FROM FitnessClass f");
        Long countResults = (Long) ((org.hibernate.query.Query) countQuery).uniqueResult();
        return countResults;
    }

}
