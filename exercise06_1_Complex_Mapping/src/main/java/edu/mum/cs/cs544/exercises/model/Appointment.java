package edu.mum.cs.cs544.exercises.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String appdate;

	@Embedded
	private Payment payment;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Patient patient;

	@OneToOne(cascade = CascadeType.ALL)
	private Doctor doctor;

	public Appointment() {
	}

	public Appointment(String appdate, Payment payment, Patient patient, Doctor doctor) {
		super();
		this.appdate = appdate;
		this.payment = payment;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppdate() {
		return appdate;
	}

	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [appdate=" + appdate + ", payment=" + payment + ", patient=" + patient + ", doctor="
				+ doctor + "]";
	}

}
