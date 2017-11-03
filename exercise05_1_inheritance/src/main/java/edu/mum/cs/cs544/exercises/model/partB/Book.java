package edu.mum.cs.cs544.exercises.model.partB;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
	private String title;
	public Book() {
		super();
	}
	public Book(String name, String description, String title) {
		super(name,description);
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", Name= " + super.getName() +"]";
	}
	
}
