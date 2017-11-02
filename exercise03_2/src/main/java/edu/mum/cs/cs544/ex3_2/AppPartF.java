package edu.mum.cs.cs544.ex3_2;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.mum.cs.cs544.ex3_2.model.part_f.Department;
import edu.mum.cs.cs544.ex3_2.model.part_f.Employee;
import edu.mum.cs.cs544.ex3_2.model.part_f.Office;

public class AppPartF {

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
                               
            Department department1 = new Department("compro");
            Department department2 = new Department("business");
            Office office1 = new Office("room001", "Verial hall");
            Office office2 = new Office("room007", "Dalby hall");
            
            // create employee
            Employee emp1 = new Employee("123", "Nati Getch", department1, office1);
            Employee emp2 = new Employee("456", "Dani Abera", department2, office1);
            Employee emp3 = new Employee("789", "Mike Afe", department1, office2);
            
            // save employees
            session.persist(emp1);
            session.persist(emp2);
            session.persist(emp3);

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

            // Retrieve all employees
            @SuppressWarnings("unchecked")
            List<Employee> empList = session.createQuery("from Employee").list();
            for (Employee emp : empList) {
            	System.out.println("===========");
                System.out.println("Employee = " + emp.getName() + 
                		", Department= " + emp.getDepartment().getName() +
                		", Office=" + emp.getOffice().getRoomnumber() + " " + emp.getOffice().getBuilding());
                //System.out.println("===");
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
