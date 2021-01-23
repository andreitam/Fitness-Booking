package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessBooking;
import com.andreitam.web.entity.FitnessClass;
import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.listener.LocalEntityManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;
/**
 * DAO class DBFitnessBooking using persistence.api
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public class DBFitnessBooking implements StoreFitnessBooking {

    private final EntityManager entityManager;
    static final Logger logger = LogManager.getLogger();

    public DBFitnessBooking(){
        entityManager = LocalEntityManagerFactory.createEntityManager();
    }
    /**
     * Method returns FitnessBooking object from database
     *
     * @param bookingId
     * @return FitnessBooking
     */
    @Override
    public FitnessBooking getFitnessBooking(UUID bookingId) {
        return entityManager.find(FitnessBooking.class, bookingId);
    }
    /**
     * Method persists FitnessBooking object into database
     *
     * @param fitnessBooking
     */
    @Override
    public void addFitnessBooking(FitnessBooking fitnessBooking) {
            entityManager.getTransaction().begin();
            entityManager.persist(fitnessBooking);
            entityManager.flush();
            entityManager.getTransaction().commit();
            System.out.println("added booking: "+fitnessBooking.toString());
            logger.warn("added booking: "+fitnessBooking.toString());

    }
    /**
     * Method updates persisted FitnessBooking object from database
     *
     * @param bookingId, fitnessBooking
     */
    @Override
    public void updateFitnessBooking(UUID bookingId, FitnessBooking fitnessBooking) {

    }
    /**
     * Method deletes persisted FitnessBooking object from database
     *
     * @param bookingId
     */
    @Override
    public void deleteFitnessBooking(UUID bookingId) {
        FitnessBooking deletedFitnessCBooking = entityManager.find(FitnessBooking.class, bookingId);
        System.out.println("booking to be deleted: "+deletedFitnessCBooking.toString());
        logger.warn("booking to be deleted: "+deletedFitnessCBooking.toString());
        entityManager.getTransaction().begin();
        entityManager.remove(deletedFitnessCBooking);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
    }
    /**
     * Method returns list with FitnessBookings objects from database
     *
     * @return List<FitnessBooking>
     */
    @Override
    public List<FitnessBooking> getBookings() {
        return entityManager
                .createQuery("SELECT fb FROM FitnessBooking fb")
                .getResultList();
    }
    /**
     * Method returns list with FitnessBookings objects of client from database.
     * The returned list is prepared for pagination from the Hibernate query.
     *
     * @param page, recordsPerPage, clientId
     * @return List<FitnessBooking>
     */
    public List<FitnessBooking> getBookingsByClientPagination(int page, int recordsPerPage, UUID clientId) {
        List<FitnessBooking> bookingsList = entityManager.createQuery("SELECT fb FROM FitnessBooking fb " +
                "WHERE fb.fitnessClient.id=:clientId ORDER BY fb.dateTimeBooking")
                .setParameter("clientId", clientId)
                .setMaxResults(recordsPerPage)
                .setFirstResult(page*recordsPerPage-recordsPerPage)
                .getResultList();
        System.out.println("page: "+page+" recordsPerPage: "+recordsPerPage);
        logger.warn("page: "+page+" recordsPerPage: "+recordsPerPage);
        for (FitnessBooking fb: bookingsList) {
            System.out.println(fb.toString());
            logger.warn("pagination: "+fb.toString());
        }
        return bookingsList;
    }
    /**
     * Method returns list with FitnessBookings objects belonging to a FintessClass from database.
     *
     * @param fitnessClass
     * @return List<FitnessBooking>
     */
    public List<FitnessBooking> getBookingsByClass(FitnessClass fitnessClass) {
        List<FitnessBooking> bookingsList = entityManager.createQuery("SELECT fb FROM FitnessBooking fb " +
                "WHERE fb.fitnessClass.id=:classId")
                .setParameter("classId", fitnessClass.getId())
                .getResultList();
        for (FitnessBooking fb: bookingsList) {
            System.out.println("bookings found by class: "+fb.toString());
            logger.warn("bookings found by class: "+fb.toString());
        }
        return bookingsList;
    }

    /**
     * Method returns the number of records in the database of a client.
     *
     * @param clientId
     * @return countResults
     */
    public Long getNoOfRecordsByClient(UUID clientId) {
        Query countQuery = entityManager.createQuery("SELECT count (fb.id) FROM FitnessBooking fb WHERE fb.fitnessClient.id=:clientId")
                .setParameter("clientId", clientId);
        Long countResults = (Long) ((org.hibernate.query.Query) countQuery).uniqueResult();
        return countResults;
    }
    /**
     * Method deletes FitnessBokings containing a specified FitnessClass.
     *
     * @param fitnessClass
     */
    public void deleteFitnessBookingsByClass(FitnessClass fitnessClass) {
        List<FitnessBooking> findBookings = entityManager.createQuery("SELECT fb FROM FitnessBooking fb " +
                "WHERE fb.fitnessClass.id=:classId ")
                .setParameter("classId", fitnessClass.getId())
                .getResultList();
        for (FitnessBooking fitnessBooking:findBookings) {
            FitnessBooking deletedFitnessCBooking = entityManager.find(FitnessBooking.class, fitnessBooking.getId());
            System.out.println("booking to be deleted: "+deletedFitnessCBooking.toString());
            logger.warn("booking to be deleted: "+deletedFitnessCBooking.toString());
            entityManager.getTransaction().begin();
            entityManager.remove(deletedFitnessCBooking);
            entityManager.flush();
            entityManager.clear();
            entityManager.getTransaction().commit();
        }
    }
    /**
     * Method checks if a FitnessClient already booked A FitnessClass
     *
     * @param fitnessBooking
     */
    public boolean checkAllreadyBooked(FitnessBooking fitnessBooking) {
        List<FitnessBooking> allreadyBooked = entityManager.createQuery("SELECT fb FROM FitnessBooking fb " +
                "WHERE fb.fitnessClient.id=:clientId AND fb.fitnessClass.id=:classId ")
                .setParameter("clientId", fitnessBooking.getFitnessClient().getId())
                .setParameter("classId", fitnessBooking.getFitnessClass().getId())
                .getResultList();
        if (allreadyBooked.size()==0) {
            return true;
        }
        else {
            System.out.println("allready booked: "+allreadyBooked.get(0).toString());
            logger.warn("allready booked: "+allreadyBooked.get(0).toString());
            return false;
        }
    }
}
