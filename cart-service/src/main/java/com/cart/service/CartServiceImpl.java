package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.repository.CartRepository;
import com.shared.model.Cart;

@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}

	@Override
	public Cart getCartById(Integer id) {
		System.out.println(" cart service >>> "+cartRepository.getOne(id));
		return cartRepository.getOne(id);
	}

	@Override
	public List<Cart> getCartList() {
		return cartRepository.findAll();
	}

}
