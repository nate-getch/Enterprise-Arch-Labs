package edu.mum.cs.cs544.ex3_2.model.part_f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Employee> employee;

	public Department() {
	}

	public Department(String name, Employee employee) {
		super();
		this.name = name;
		this.employee = new ArrayList<Employee>();
		// add employee thru constructor b/c every department has at least one employee
		addEmployee(employee);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void addEmployee(Employee employee) {
		employee.setDepartment(this);
		this.employee.add(employee);
	}

}
