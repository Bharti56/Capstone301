package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.CustomerNotFoundException;
import com.customer.repository.CustomerRepository;


public interface CustomerService {

	public Customer createCustomer(Customer customer);
	
	public Customer UpdateCustomer(Customer customer ,long id) throws CustomerNotFoundException;
	
	public void deleteCustomer(long id);
}
