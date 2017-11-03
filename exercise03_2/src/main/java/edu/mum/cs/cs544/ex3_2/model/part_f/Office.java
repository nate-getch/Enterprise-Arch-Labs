package edu.mum.cs.cs544.ex3_2.model.part_f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {
	@Id
	@GeneratedValue
	private int id;
	private String roomnumber;
	private String building;
	
	@OneToMany(mappedBy = "office")
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	public Office() {}
	
	public Office(String roomnumber, String building) {
		super();
		this.roomnumber = roomnumber;
		this.building = building;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public List<Employee> getEmployee() {
		return employeeList;
	}

	public void setEmployee(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	public void addEmployee(Employee employee) {
		employee.setOffice(this);
		this.employeeList.add(employee);
	}

	@Override
	public String toString() {
		return "Office [roomnumber=" + roomnumber + ", building=" + building + "]";
	}
	
}
