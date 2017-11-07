package com.mum.edu.mongodemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

    @Id
    private String id;
    
    private String firstName;
    private String lastName;
    private String zipcode;

    public Customer() {}

    public Customer(String firstName, String lastName, String zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
    }
    
    public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s' , Zip='%s']",
                id, firstName, lastName, zipcode);
    }

}