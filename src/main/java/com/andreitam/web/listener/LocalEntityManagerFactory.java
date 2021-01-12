package com.andreitam.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {
    static final Logger logger = LogManager.getLogger();
    private static EntityManagerFactory emf;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.warn(System.getenv("DATABASE_URL"));
        System.out.println(System.getenv("DATABASE_URL"));
        emf = Persistence.createEntityManagerFactory("JpaGym");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return emf.createEntityManager();
    }
}
