package com.order.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long customerId;
	private String status;
	private long restaurantId;  
	@CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
//   
    
    @OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL)
    @JoinColumn(name="oi_fk")
    private List<OrderItem> orderitem;
    
    
	public Long getId() {
		return id;
	}
	public List<OrderItem> getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	

	public Order(long id, long customerId, String status, long restaurantId, LocalDateTime createDateTime,
			LocalDateTime updateDateTime, List<OrderItem> orderitem) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.status = status;
		this.restaurantId = restaurantId;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.orderitem = orderitem;
	}
	public Order() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", status=" + status + ", restaurantId="
				+ restaurantId + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime
				+ "]";
	}
	

}
