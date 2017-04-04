package ru.java.mantis.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.java.mantis.model.UsersData;


import java.util.List;

/**
 * Created by Studenov-DV on 24.03.2017.
 */
public class HbConnectionTest {

    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void testHbConnection(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UsersData> result = session.createQuery( "from UsersData" ).list();
        for ( UsersData group : result ) {
 //           System.out.println(group);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testHbConnectionContact(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UsersData> result = session.createQuery( "from UsersData" ).list();
        for ( UsersData contact : result ) {
         //   System.out.println(contact);
           // System.out.println(contact.getGroups());
            System.out.println("contacts in groups" + contact);

        }
        session.getTransaction().commit();
        session.close();
    }
}
