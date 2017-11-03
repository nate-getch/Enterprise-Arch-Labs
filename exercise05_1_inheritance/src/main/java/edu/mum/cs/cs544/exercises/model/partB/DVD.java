package edu.mum.cs.cs544.exercises.model.partB;

import javax.persistence.Entity;

@Entity
public class DVD extends Product{
	private String genre;
	public DVD() {
		super();
	}
	public DVD(String name, String description, String genre) {
		super(name,description);
		this.genre = genre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "DVD [genre=" + genre + ", Name= " + super.getName() + "]";
	}
	
}