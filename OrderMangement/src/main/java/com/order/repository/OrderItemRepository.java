package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
