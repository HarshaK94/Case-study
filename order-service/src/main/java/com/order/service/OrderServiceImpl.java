package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.repository.OrderRepository;
import com.shared.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository repository;
	
	@Override
	public Order saveOrder(Order order) {
		return repository.saveAndFlush(order);
	}

	@Override
	public Order getOrderById(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public List<Order> getOrderList() {
		return repository.findAll();
	}

}
