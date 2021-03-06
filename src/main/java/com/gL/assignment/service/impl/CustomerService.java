package com.gL.assignment.service.impl;

import java.util.List;

import com.gL.assignment.model.Customer;

/* Interface having all services required 
 * to perform CRUD operations
*/
public interface CustomerService {
	
	List<Customer> findAll();

	Customer findById(int customerId);

	void save(Customer customer);

	void deleteById(int customerId);

}
