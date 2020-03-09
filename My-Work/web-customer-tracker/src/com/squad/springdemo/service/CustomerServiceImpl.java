package com.squad.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad.springdemo.dao.CustomerDAO;
import com.squad.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveOrUpdateCustomer(Customer customer) {
		customerDAO.saveOrUpdateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
		
	}

	
	
}
