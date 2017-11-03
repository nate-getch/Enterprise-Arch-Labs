package edu.mum.cs.cs544.exercises.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String doctortype;
	private String firstname;
	private String lastname;
	
	public Doctor() {
		super();
	}

	public Doctor(String doctortype, String firstname, String lastname) {
		super();
		this.doctortype = doctortype;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctortype() {
		return doctortype;
	}

	public void setDoctortype(String doctortype) {
		this.doctortype = doctortype;
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

	@Override
	public String toString() {
		return "Doctor [doctortype=" + doctortype + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
