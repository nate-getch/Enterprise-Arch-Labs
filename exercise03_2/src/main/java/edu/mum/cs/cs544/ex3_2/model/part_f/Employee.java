package edu.mum.cs.cs544.ex3_2.model.part_f;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "officeId")
	private Office office;

	public Employee() {
	}

	public Employee(String employeenumber, String name, Department department, Office office) {
		super();
		this.employeenumber = employeenumber;
		this.name = name;
		this.department = department;
		this.office = office;
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

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Employee [employeenumber=" + employeenumber + ", name=" + name + ", department=" + department
				+ ", office=" + office + "]";
	}

}
