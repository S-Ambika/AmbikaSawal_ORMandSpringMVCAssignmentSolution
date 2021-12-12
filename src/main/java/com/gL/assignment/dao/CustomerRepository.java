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

@Repository
public class CustomerRepository {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	CustomerRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

	@Transactional
	public Customer findById(int customerId) {
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Transactional
	public void save(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(customer);
		transaction.commit();
	}

	@Transactional
	public void deleteById(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
		transaction.commit();

	}

	@Transactional
	public void print(List<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
