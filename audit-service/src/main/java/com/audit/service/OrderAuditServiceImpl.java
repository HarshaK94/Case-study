package com.audit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.repository.OrderAuditRepository;
import com.shared.model.Order;

@Service
public class OrderAuditServiceImpl implements OrderAuditService{

	@Autowired
	private OrderAuditRepository repository;
	
	
	@Override
	public List<Order> getOrderList() {
		return repository.findAll() ;
	}

}
