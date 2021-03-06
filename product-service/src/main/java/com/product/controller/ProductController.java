package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.services.ProductService;
import com.shared.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product")
	@PreAuthorize("hasAuthority('create_profile')")
	public Product saveProduct(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@GetMapping(value = "/product",produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('read_profile')")
	public Product getProductById(@RequestParam int id) {
		System.out.println("############  "+id);
		Product product= productService.getProductById(id);
		
		return product; 
	}
	
	@GetMapping(value = "/products")
	@PreAuthorize("hasAuthority('read_profile')")
	public List<Product> getProductList(){
		return productService.getAllProduct();
	}
	
	
}
