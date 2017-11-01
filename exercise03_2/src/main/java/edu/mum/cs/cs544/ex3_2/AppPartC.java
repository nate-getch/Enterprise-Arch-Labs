package edu.mum.cs.cs544.ex3_2;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.mum.cs.cs544.ex3_2.model.part_c.Student;
import edu.mum.cs.cs544.ex3_2.model.part_c.Course;

public class AppPartC {

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
            
            // create book
            Student stud1 = new Student("98612", "nati", "getch");
            Student stud2 = new Student("98562", "dani", "abera");
            
            // create publisher
            Course course1 = new Course("WAP", "WEb app prog", stud1);
            Course course2 = new Course("EA", "Enterprise arch", stud2);
            course1.addStudent(stud2);
            
            // save books
            session.persist(stud1);
            session.persist(stud2);
            session.persist(course1);
            session.persist(course2);
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
        
        // display records from db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Retrieve all books
            @SuppressWarnings("unchecked")
            List<Student> studentList = session.createQuery("from Student").list();
            for (Student student : studentList) {
            	System.out.println("======================");
                System.out.println("Student Name = " + student.getFirstname());
                student.getCourse().forEach(System.out::println);
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
