package edu.mum.cs.cs544.ex3_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.mum.cs.cs544.ex3_2.model.part_e.Reservation;
import edu.mum.cs.cs544.ex3_2.model.part_e.Customer;
import edu.mum.cs.cs544.ex3_2.model.part_e.Book;

public class AppPartE {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;
        
        // add record to db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            
            Book book1 = new Book("12345", "Head first JQuery", "Henry Ford");
            Book book2 = new Book("12345", "Head first Java", "Jon Doe");

            Reservation reservation1 = new Reservation(dt.parse("2017-01-02"), book1);
            Reservation reservation2 = new Reservation(dt.parse("2017-07-18"), book2);
            Reservation reservation3 = new Reservation(dt.parse("2017-11-03"), book1);
            
            // create customer
            Customer customer1 = new Customer("Nate", reservation1);
            customer1.addReservation(reservation2); 
            
            Customer customer2 = new Customer("Dani", reservation3);
            
            // save 
            session.persist(customer1);            
            session.persist(customer2);
            tx.commit();

        } catch (HibernateException | ParseException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        // display records from db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Retrieve all customers
            @SuppressWarnings("unchecked")
            List<Customer> customerList = session.createQuery("from Customer").list();
            for (Customer customer : customerList) {
            	System.out.println("======================");
                System.out.println("Customer Name = " + customer.getName());
                System.out.println("Reseration Info = "); 
                customer.getReservation().forEach(
                		t -> System.out.println("Reservation Date: "+ t.getDate() + " Book:" + t.getBook().getTitle() )
                		);
                
                System.out.println("======================");
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
