package edu.mum.cs.cs544.ex3_2.model.part_a;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
Create a Bidirectional OneToMany association between Department and Employee
using annotations. 
*/

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String employeenumber;
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId")
	private Department department;

	public Employee() {
	}

	public Employee(String employeenumber, String name, Department department) {
		super();
		this.employeenumber = employeenumber;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getEmployeenumber() {
		return employeenumber;
	}

	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
