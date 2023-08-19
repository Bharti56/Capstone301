package com.order.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.order.entity.Order;
import com.order.exeption.ResourceNotFoundException;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

//	@Override
//	public Order createdOrder(Order order) {
//		// TODO Auto-generated method stub
//		return orderRepository.save(order);
//	}

	@Override
	public Optional<Order> getOrderById(long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public Order updateOrderbyId(Order order,long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Order exisitingOrder=orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order", "id", id));
		exisitingOrder.setCustomerId(order.getCustomerId());
		exisitingOrder.setRestaurantId(order.getRestaurantId());
		exisitingOrder.setStatus(order.getStatus());
		exisitingOrder.setCreateDateTime(order.getCreateDateTime());
		exisitingOrder.setUpdateDateTime(order.getUpdateDateTime());
		
		return orderRepository.save(exisitingOrder);
		
	}

	@Override
	public void deleteByOrder(long id) {
		orderRepository.deleteById(id);
		
	}

	}








