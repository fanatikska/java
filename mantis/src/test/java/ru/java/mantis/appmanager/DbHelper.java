package ru.java.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.java.mantis.model.UsersData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Studenov-DV on 27.03.2017.
 */
public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public HashSet<UsersData> users() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UsersData> result = session.createQuery("from UsersData").list();
        session.getTransaction().commit();
        session.close();
        return new HashSet<UsersData>(result);
    }
}
