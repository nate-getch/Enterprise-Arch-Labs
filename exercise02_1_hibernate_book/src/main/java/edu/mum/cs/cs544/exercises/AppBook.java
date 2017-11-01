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

import edu.mum.cs.cs544.exercises.model.Book;

public class AppBook {

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
        
        // add books
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            
            // Create new instance of book and set values in it
            Book book1 = new Book("Spring & HIbernate", "12345", "Abe Kebe", 12.5, df.parse("04/17/2006"));
            // save book1
            session.persist(book1);
            
            // Create book2 instance
            Book book2 = new Book("Head first JSP", "7890", "Jon Doe", 45.5, df.parse("02/25/2015"));
            // save book2
            session.persist(book2);
            
            // Create book3 instance
            Book book3 = new Book("JQuery", "34567", "Daniel Arega", 9.25, df.parse("07/10/2017"));
            // save book3
            session.persist(book3);
            
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
        
        // Retrieve a book from the database and change its title and price
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
                       
            Book book1 = (Book) session.load(Book.class, 1);
            System.out.println("b111"+book1.getISBN());
            // update book1
            book1.setTitle("The Alchemist");
            book1.setPrice(65.99);
                        
            // delete book with id 2 -> use lazy load
            Book book2 = (Book) session.load(Book.class, 2);
            session.delete(book2);
                     
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
            List<Book> bookList = session.createQuery("from Book").list();
            for (Book book : bookList) {
                System.out.println("Title= " + book.getTitle() + ", ISBN= "
                        + book.getISBN() + ", price= " + book.getPrice() + 
                        ", Publish date= " + book.getPublish_date() );
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
