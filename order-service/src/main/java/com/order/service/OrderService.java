package com.order.service;

import java.util.List;

import com.shared.model.Order;

public interface OrderService {

	public Order saveOrder(Order order);
	
	public Order getOrderById(Integer id);
	
	public List<Order> getOrderList();

}
