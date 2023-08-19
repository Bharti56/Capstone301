package com.customer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.exception.CustomerNotFoundException;
import com.customer.serviceimpl.CustomerServiceimpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceimpl customerServiceimpl;
	private Map<String, Object> response;
	
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> createCustomer(@RequestBody Customer customer){
		response = new HashMap<>();
		response.put("message", "Order placed Successfully");
		response.put("status",HttpStatus.OK);
		response.put("body",customerServiceimpl.createCustomer(customer));
		response.put("Error",false);
		return new  ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		}
	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Object>> UpdateCustomerbyId(@RequestBody Customer customer,@PathVariable(value = "id") long  id) throws CustomerNotFoundException{
		response = new HashMap<>();
		response.put("message", "Order placed Successfully");
		response.put("status",HttpStatus.OK);
		response.put("body",customerServiceimpl.UpdateCustomer(customer, id));
		response.put("Error",false);
		return new  ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> cancelCustomer(@PathVariable long id){
		customerServiceimpl.deleteCustomer(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		
	}

}  