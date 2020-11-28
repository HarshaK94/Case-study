package com.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.service.OrderAuditService;
import com.shared.model.Order;

@RestController
@RequestMapping("/order")
public class OrderAuditController {

	@Autowired
	private OrderAuditService orderAuditService;
	
	@GetMapping(value = "/OrderList")
	public List<Order> getAllLoggedinUser(){
			System.out.println("@@@@@@@@@@@@@@@  "+orderAuditService.getOrderList());
		return orderAuditService.getOrderList();
	}
}
