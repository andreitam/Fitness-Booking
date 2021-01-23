package com.andreitam.web.model;

import com.andreitam.web.entity.FitnessClass;

import java.util.List;
import java.util.UUID;
/**
 * Interface StoreFitnessClass for DAO class
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public interface StoreFitnessClass {
    FitnessClass getFitnessClass(UUID classId);
    void addFitnessClass(FitnessClass fitnessClass);
    void updateFitnessClass(UUID classId, FitnessClass fitnessClass);
    void deleteFitnessClass(UUID classId);
    List<FitnessClass> getFitnessClasses();
}
