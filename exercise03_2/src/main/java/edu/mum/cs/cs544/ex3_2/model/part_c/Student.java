package edu.mum.cs.cs544.ex3_2.model.part_c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String studentid;
	private String firstname;
	private String lastname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_course")
	private List<Course> course = new ArrayList<Course>();
	
	public Student() {}
	
	public Student(String studentid, String firstname, String lastname) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public void assignCourse(Course course) {
		this.course.add(course);
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + "]";
	}
		
}
