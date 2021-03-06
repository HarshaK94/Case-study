package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.repository.ProductRepository;
import com.shared.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
		return productRepository.saveAndFlush(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		System.out.println("@@@@@@@@@@@@@@@@@@@ "+id);
		Product product = productRepository.getOne(id);
		System.out.println("@$$$$$$$$$$$$$$$$$$$$$ "+product);
		return product;
	}

	
	
}
