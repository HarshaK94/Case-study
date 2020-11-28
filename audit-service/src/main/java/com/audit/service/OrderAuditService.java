package com.audit.service;

import java.util.List;

import com.shared.model.Order;

public interface OrderAuditService {

	public List<Order> getOrderList();
}
