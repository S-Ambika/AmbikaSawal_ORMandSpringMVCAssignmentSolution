package com.gL.assignment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gL.assignment.dao.CustomerRepository;
import com.gL.assignment.model.Customer;

/* Class having implementation of Service and Dependency Injection of Repository
 * to perform CRUD operations
*/
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);

	}

	@Override
	public void deleteById(int customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
	}

}
