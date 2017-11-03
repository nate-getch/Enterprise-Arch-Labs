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

import edu.mum.cs.cs544.exercises.model.partA.*;

public class AppOrder {

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
        
        // add 
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            
            Customer c1 = new Customer("Nati", "Getch");
            Customer c2 = new Customer("Dani", "Abera");
            
            Product p1 = new Product("Samsung", "Samsung Galaxy");
            Product p2 = new Product("IPhone", "IPhone 7");
                       
            Order o1 = new Order( df.parse("04/17/2017"), c1);
            
            OrderLine orderLine1 = new OrderLine(2,p1);
            OrderLine orderLine2 = new OrderLine(1,p2);
            OrderLine orderLine3 = new OrderLine(2,p2);
            
            o1.addOrderLine(orderLine1);
            o1.addOrderLine(orderLine2);
            
            Order o2 = new Order( df.parse("09/25/2017"), c2);
            o2.addOrderLine(orderLine3);        

            // save 
            session.persist(o1);
            session.persist(o2);
            
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
               
        // Retrieve records
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Retrieve all customers
            @SuppressWarnings("unchecked")
            List<Order> orderList = session.createQuery("from Order").list();
            for (Order order : orderList) {
            	System.out.println("==============");
                System.out.println(
                	"Order ID = " + order.getOrderId() + 
                	", Date= " + order.getDate() 
                	+ ", Customer= " + order.getCustomer().getFirstname());
                
                order.getOrderLine().forEach(System.out::println);
                
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
