package edu.mum.cs.cs544.ex3_2.model.part_c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String coursenumber;
	private String name;
	
	@ManyToMany
	@JoinTable(name="student_course")
	private List<Student> student = new ArrayList<Student>();
	
	public Course() {}
	
	public Course(String coursenumber, String name, Student student) {
		super();
		this.coursenumber = coursenumber;
		this.name = name;
		addStudent(student);
	}

	public String getCoursenumber() {
		return coursenumber;
	}

	public void setCoursenumber(String coursenumber) {
		this.coursenumber = coursenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	public void addStudent(Student student) {
		this.student.add(student);
	}

	@Override
	public String toString() {
		return "Course [coursenumber=" + coursenumber + ", name=" + name + "]";
	}
	
}
