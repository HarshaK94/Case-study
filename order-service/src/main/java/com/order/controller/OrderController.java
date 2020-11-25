package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.order.service.OrderService;
import com.shared.model.Cart;
import com.shared.model.Order;
import com.shared.model.Product;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private OrderService orderService;
	
	@PostMapping(value ="/order" )
	public ResponseEntity saveCart(@RequestBody Order order) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", com.order.config.AccessToken.getAccessToken());
		HttpEntity<Product> productHttpEntity = new HttpEntity<Product>(httpHeaders);
		ResponseEntity responseEntity =null;
		try {
		 responseEntity = restTemplate.exchange("http://localhost:8768/cart/cart?id="+order.getCartId(), HttpMethod.GET,productHttpEntity,Cart.class);
		//model.addAttribute("students", responseEntity.getBody());
		Cart cart = (Cart) responseEntity.getBody();
		Integer cartId = cart.getCartId();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   "+cartId);
				order.setCartId(cartId);
			order=	orderService.saveOrder(order);
		}catch (HttpStatusCodeException e) {
			e.printStackTrace();
			//@SuppressWarnings("rawtypes")
			 //responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString()).getBody();
			//model.addAttribute("error", responseEntity);
		}
		
		return responseEntity;
	}
	
	@GetMapping(value ="/order")
	public Order getOrderById(@RequestParam int id) {
		return orderService.getOrderById(id);
	}
	
	@GetMapping(value = "/orders")
	public List<Order> getCartList(){
		return orderService.getOrderList();
	}

}
