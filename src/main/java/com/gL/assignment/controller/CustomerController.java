package com.gL.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gL.assignment.model.Customer;
import com.gL.assignment.service.impl.CustomerServiceImpl;

/* Class having all mappings and methods to call APIs 
 * to perform CRUD operations.
*/

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		String returnVal = "";
		// get the Customers from db;
		List<Customer> customers = customerServiceImpl.findAll();
		if (customers.size() > 0) {
			// add to the spring model
			theModel.addAttribute("Customers", customers);
			returnVal = "list-customers";
		} else {
			returnVal = "error";
		}
		return returnVal;
	}

	@RequestMapping("/addCustomer")
	public String addCustomer(Model theModel) {
		// create model attribute to bind form data.
		Customer customer = new Customer();
		theModel.addAttribute("Customer", customer);

		return "Customer-form"; // show Customer Form page
	}

	@RequestMapping("/UpdateCustomer")
	public String UpdateCustomer(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from the service
		Customer customer = customerServiceImpl.findById(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", customer);

		// send over to our form
		return "Customer-form"; // show Customer Form page
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name, @RequestParam("email") String email) {

		Customer customer;
		String returnVal = "";

		if (first_name.equals("") || last_name.equals("") || email.equals("")) {
			returnVal = "missing-page";
		} else {

			if (id != 0) {
				/*
				 * if id is not 0 then it exists inside table already, Update Operation
				 */
				customer = customerServiceImpl.findById(id);

				// put updated values to the customer object found from database.
				customer.setFirst_name(first_name);
				customer.setLast_name(last_name);
				customer.setEmail(email);

			} else {
				/*
				 * if id is 0 then it doesn't exist inside table, Create Operation
				 */
				customer = new Customer(first_name, last_name, email);
			}

			customerServiceImpl.save(customer);
			returnVal = "redirect:/customers/list"; // redirect to Customer List Page after operation
		}
		return returnVal;
	}

	@RequestMapping("/delete") // Using @DeleteMapping is throwing 405 error code
	public String delete(@RequestParam("customerId") int customerId) {
		// delete the customer
		customerServiceImpl.deleteById(customerId);
		return "redirect:/customers/list"; // redirect to Customer List Page after operation
	}

}
