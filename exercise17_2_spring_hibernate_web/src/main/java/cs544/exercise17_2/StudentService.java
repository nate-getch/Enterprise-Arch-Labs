package cs544.exercise17_2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO studentdao;
//	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	/*
	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}*/
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void loadInitData() {
		this.studentdao.loadInitData();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Student getStudent(long studentid) {
		//Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.load(studentid);
//		Hibernate.initialize(student.getCourselist());
		//tx.commit();
		return student;
	}
}
