package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shared.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
