package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shared.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
