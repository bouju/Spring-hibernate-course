package com.squad.springdemo.service;

import java.util.List;

import com.squad.springdemo.entity.Customer;

public interface CustomerService {

	public Customer getCustomer(int id);
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
}
