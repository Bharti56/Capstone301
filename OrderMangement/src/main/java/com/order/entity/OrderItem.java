package com.order.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
public class OrderItem {
	@Id
	private Long itemId;
	private String name;
	private int quantity;
	private double price;
	
	
	public OrderItem(String name, int quantity, double price, Order order, Long itemId) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	

	
}
	

