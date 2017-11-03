package edu.mum.cs.cs544.exercises.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "address")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@Column(table = "address")
	private String street;

	@Column(table = "address")
	private String zip;

	@Column(table = "address")
	private String city;
	
	public Patient() {
		super();
	}

	public Patient(String name, String street, String zip, String city) {
		super();
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.city = city;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", street=" + street + ", zip=" + zip + ", city=" + city + "]";
	}

}
