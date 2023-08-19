package com.customer.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.CustomerNotFoundException;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@Service
public class CustomerServiceimpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer UpdateCustomer(Customer customer, long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer cust = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer", "id", id));
		cust.setCustomerName(customer.getCustomerName());
		return customerRepository.save(cust);
		
		
	}

	@Override
	public void deleteCustomer(long id) {
		 customerRepository.deleteById(id);
		
	}
	

}
