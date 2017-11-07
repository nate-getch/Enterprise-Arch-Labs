package com.mum.edu.mongodemo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

    @Query("{zipcode: { $regex: '?0$' } })")
    public List<Customer> findByZipcode(String zipcode);
}