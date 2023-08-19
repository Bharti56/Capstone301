package com.order.service;


import java.util.Optional;

import com.order.entity.Order;
import com.order.exeption.ResourceNotFoundException;

public interface OrderService  {
//	public Order createdOrder(Order order);
	
	public Optional<Order> getOrderById(long id);
	
	public Order updateOrderbyId(Order order,long id) throws ResourceNotFoundException;
	
	public void deleteByOrder(long id);
	

}
