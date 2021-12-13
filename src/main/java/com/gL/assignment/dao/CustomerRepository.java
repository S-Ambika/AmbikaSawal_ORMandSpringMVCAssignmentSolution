package com.gL.assignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gL.assignment.model.Customer;

/* Class having all methods required 
 * to perform CRUD operations,
 * Methods will get called by Service Impl class
*/

@Repository
public class CustomerRepository {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	CustomerRepository(SessionFactory sFactory) {
		this.sessionFactory = sFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	public List<Customer> findAll() {
		List<Customer> customers = session.createQuery("from Customer").list(); // name of entity class
		return customers;
	}

	public Customer findById(int customerId) {
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Transactional // Required only with save, update and delete operations
	public void save(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(customer);
		transaction.commit();
	}

	@Transactional // Required only with save, update and delete operations
	public void deleteById(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
		transaction.commit();

	}

	public void print(List<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
