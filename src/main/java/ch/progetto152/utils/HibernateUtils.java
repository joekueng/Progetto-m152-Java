package ch.progetto152.utils;

import ch.progetto152.entity.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtils {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Location.class);
            configuration.addAnnotatedClass(LocationVisited.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Waypoints.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
