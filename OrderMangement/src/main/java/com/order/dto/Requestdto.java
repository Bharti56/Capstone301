package com.order.dto;

import com.order.entity.Order;

public class Requestdto {
private Order orderr;


public Order getOrderr() {
	return orderr;
}

public void setOrderr(Order orderr) {
	this.orderr = orderr;
}

public Requestdto() {
	super();
	// TODO Auto-generated constructor stub
}

public Requestdto(Order orderr) {
	super();
	this.orderr = orderr;
}

@Override
public String toString() {
	return "Requestdto [orderr=" + orderr + "]";
}



}
