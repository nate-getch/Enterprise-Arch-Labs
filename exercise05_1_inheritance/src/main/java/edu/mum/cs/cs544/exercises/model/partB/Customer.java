package edu.mum.cs.cs544.exercises.model.partB;

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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	private String lastname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private List<Order> orderList = new ArrayList();
	
	public Customer() {}

	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		//addOrder(order);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Order> getOrder() {
		return orderList;
	}

	public void setOrder(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public void addOrder(Order order) {
		this.orderList.add(order);
		order.setCustomer(this);
	}
	
}
