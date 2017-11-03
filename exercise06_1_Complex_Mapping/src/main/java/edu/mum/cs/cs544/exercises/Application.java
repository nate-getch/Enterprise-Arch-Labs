package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.mum.cs.cs544.exercises.model.*;

public class Application {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;
        
        // add records
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            Doctor doc1 = new Doctor("Eye Doc", "Frank", "Brown");
            Patient patient1 = new Patient("Jon Doe","1000 N", "52257", "springfiled");
            Payment pay1 = new Payment("12/06/08", 100);
            
            Appointment appointment1 = new Appointment("15/05/08", pay1, patient1, doc1);
            
            // save 
            session.persist(appointment1);
                       
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        // Retrieve and log all book records
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Retrieve all books
            @SuppressWarnings("unchecked")
            List<Appointment> appointmentList = session.createQuery("from Appointment").list();
            for (Appointment appointment : appointmentList) {
                System.out.println(
                		"Appoitnment Date = " +  appointment.getAppdate() +
                		", Doc = " +  appointment.getDoctor().getFirstname() +
                		", Patient = " +  appointment.getPatient().getName() +
                		", Patient street address = " +  appointment.getPatient().getStreet() 
                );
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
}
