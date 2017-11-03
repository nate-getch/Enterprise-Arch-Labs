package edu.mum.cs.cs544.exercises.model.partA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	public OrderLine() {}

	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderLine [quantity=" + quantity + ", product=" + product + "]";
	}
	
}
