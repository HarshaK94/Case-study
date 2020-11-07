package com.cart.service;

import java.util.List;

import com.shared.model.Cart;

public interface CartService {

	public Cart saveCart(Cart cart);
	
	public Cart getCartById(Integer id);
	
	public List<Cart> getCartList();
}
