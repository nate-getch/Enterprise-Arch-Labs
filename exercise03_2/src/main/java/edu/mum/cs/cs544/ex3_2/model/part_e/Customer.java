package edu.mum.cs.cs544.ex3_2.model.part_e;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Reservation> reservationList = new ArrayList<Reservation>();

	public Customer() {
	}
	
	public Customer(String name, Reservation reservation) {
		super();
		this.name = name;
		addReservation(reservation);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservation() {
		return reservationList;
	}

	public void setReservation(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	public void addReservation(Reservation reservation) {
		this.reservationList.add(reservation);
	}

}
