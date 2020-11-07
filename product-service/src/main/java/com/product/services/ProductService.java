package com.product.services;

import java.util.List;

import com.shared.model.Product;

public interface ProductService {

	public Product save(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
}
