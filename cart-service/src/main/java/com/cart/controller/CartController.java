package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cart.config.AccessToken;
import com.cart.service.CartService;
import com.shared.model.Cart;
import com.shared.model.Product;

@RestController
@RequestMapping("/cart")
public class CartController {
	

	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private CartService cartService;
	
	@PostMapping(value ="/cart" )
	public ResponseEntity saveCart(@RequestBody Cart cart) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", AccessToken.getAccessToken());
		HttpEntity<Product> productHttpEntity = new HttpEntity<Product>(httpHeaders);
		ResponseEntity responseEntity =null;
		try {
		 responseEntity = restTemplate.exchange("http://localhost:8762/product/product?id="+cart.getProductId(), HttpMethod.GET,productHttpEntity,Product.class);
		//model.addAttribute("students", responseEntity.getBody());
		Product ps = (Product) responseEntity.getBody();
		Integer productId = ps.getProductId();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   "+productId);
				cart.setProductId(productId);
			cart=	cartService.saveCart(cart);
		}catch (HttpStatusCodeException e) {
			e.printStackTrace();
			//@SuppressWarnings("rawtypes")
			 //responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString()).getBody();
			//model.addAttribute("error", responseEntity);
		}
		
		return responseEntity;
	}
	
	@GetMapping(value ="/cart",produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart getCartById(@RequestParam int id) {
		return cartService.getCartById(id);
	}
	
	@GetMapping(value = "/carts")
	public List<Cart> getCartList(){
		return cartService.getCartList();
	}
}
