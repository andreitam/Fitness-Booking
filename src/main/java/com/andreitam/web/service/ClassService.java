package com.andreitam.web.service;

import com.andreitam.web.entity.FitnessClass;
import com.andreitam.web.model.DBFitnessClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClassService {
    private DBFitnessClass dataBase;
    private FitnessClass fitnessClass;
    private List<FitnessClass> classes;
    private static ClassService instance;
    static final Logger logger = LogManager.getLogger();

    private ClassService() {
        this.dataBase = new DBFitnessClass();

    }

    public static ClassService getInstance(){
        if(instance == null){
            instance = new ClassService();
        }
        return instance;
    }

    public void addingParticipantsFitnessClass(FitnessClass fitnessClass) {
        this.fitnessClass = fitnessClass;
        this.fitnessClass.setRegisteredParticipants(this.fitnessClass.getRegisteredParticipants()+1);
        if (this.fitnessClass.getRegisteredParticipants() >= this.fitnessClass.getSetParticipants()) {
            this.fitnessClass.setIsActive(false);
        }
        else {
            this.fitnessClass.setIsActive(true);
        }
        dataBase.updateFitnessClass(this.fitnessClass.getId(),this.fitnessClass);
    }

    public void deletingParticipantsFitnessClass(FitnessClass fitnessClass) {
        this.fitnessClass = fitnessClass;
        this.fitnessClass.setRegisteredParticipants(this.fitnessClass.getRegisteredParticipants()-1);
        if (this.fitnessClass.getRegisteredParticipants() >= this.fitnessClass.getSetParticipants()) {
            this.fitnessClass.setIsActive(false);
        }
        else {
            this.fitnessClass.setIsActive(true);
        }
        dataBase.updateFitnessClass(this.fitnessClass.getId(),this.fitnessClass);
    }
}
