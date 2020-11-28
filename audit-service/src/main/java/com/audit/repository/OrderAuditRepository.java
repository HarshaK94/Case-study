package com.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shared.model.Order;

public interface OrderAuditRepository extends JpaRepository<Order, Integer>{

	
}
