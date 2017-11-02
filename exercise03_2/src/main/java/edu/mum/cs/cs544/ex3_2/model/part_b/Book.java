package edu.mum.cs.cs544.ex3_2.model.part_b;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/*
Create an Optional Unidirectional ManyToOne association between Book and
Publisher using annotations and without using NULL fields in the database 
 */

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String isbn;
	private String title;
	private String author;
	
	@ManyToOne(cascade = CascadeType.ALL)
	// Optional Unidirectional ManyToOne - to avoid nullable fields on FK, use join table
	@JoinTable(name="book_publisher")
	private Publisher publisher;
	
	public Book() {}

	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		// publisher is optional, we don't need to set from constructor
		//this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
