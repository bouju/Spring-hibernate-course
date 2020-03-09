package com.squad.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.squad.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer getCustomer(int id) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = session.createQuery("from Customer where id=:id", Customer.class);
		query.setParameter("id", id);
		
		// execute query and get result list
		Customer customer = query.uniqueResult();
		
		// return the results
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Customer> query = session.createQuery("from Customer "
													+ "order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get sesion
		Session session = sessionFactory.getCurrentSession();
		
		// save the customer
		session.save(customer);
		
	}

}
