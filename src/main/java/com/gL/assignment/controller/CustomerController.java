package com.gL.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gL.assignment.model.Customer;
import com.gL.assignment.service.impl.CustomerServiceImpl;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		// get the Customers from db;
		List<Customer> customers = customerServiceImpl.findAll();

		// add to the spring model
		theModel.addAttribute("Customers", customers);

		return "list-customers";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data.
		Customer customer = new Customer();
		theModel.addAttribute("Customer", customer);

		return "Customer-form";
	}


	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from the service
		Customer customer = customerServiceImpl.findById(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", customer);

		// send over to our form
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name, @RequestParam("email") String email) {

		Customer customer;
		if (id != 0) {
			// Update Operation
			customer = customerServiceImpl.findById(id);

			// put updated values to the book object found from database.
			customer.setFirst_name(first_name);
			customer.setLast_name(last_name);
			customer.setEmail(email);

		} else {
			// Create Operation
			customer = new Customer(first_name, last_name, email);
		}

		customerServiceImpl.save(customer);
		return "redirect:/customers/list";
	}

	@DeleteMapping("/delete/{customerId}")
	public String delete(@PathVariable("customerId") int theId) {
		// delete the book
		customerServiceImpl.deleteById(theId);
		return "redirect:/customers/list";
	}

}
