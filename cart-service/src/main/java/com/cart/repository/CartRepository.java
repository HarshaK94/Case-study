package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shared.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
