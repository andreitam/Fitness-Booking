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
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<String, Object>();
        for (String envName : env.keySet()) {
            if (envName.contains("JDBC_DATABASE_URL")) {
                logger.warn(System.getenv("JDBC_DATABASE_URL"));
                configOverrides.put("javax.persistence.jdbc.url", env.get(envName));
            }
            if (envName.contains("JDBC_DATABASE_USERNAME")) {
                logger.warn(System.getenv("JDBC_DATABASE_USERNAME"));
                configOverrides.put("javax.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("JDBC_DATABASE_PASSWORD")) {
                logger.warn(System.getenv("JDBC_DATABASE_PASSWORD"));
                configOverrides.put("javax.persistence.jdbc.password", env.get(envName));
            }
        }
        emf = Persistence.createEntityManagerFactory("JpaGym",configOverrides);
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
