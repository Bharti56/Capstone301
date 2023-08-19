package com.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String customerName;
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Customer(long id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
