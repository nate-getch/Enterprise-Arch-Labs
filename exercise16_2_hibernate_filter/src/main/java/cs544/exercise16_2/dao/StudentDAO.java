package cs544.exercise16_2.dao;

import cs544.exercise16_2.domain.Course;
import cs544.exercise16_2.domain.Student;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public StudentDAO() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		//Transaction tx = sf.getCurrentSession().beginTransaction();
		student.addCourse(course1);
		student.addCourse(course2);
		sf.getCurrentSession().persist(student);
		//tx.commit();
	}

	public Student load(long studentid) {
		
		Student student = (Student) sf.getCurrentSession().get(Student.class, studentid);
		//Hibernate.initialize(student.getCourselist());
		
		return student;
	}
}
