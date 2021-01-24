package com.altimetrik.ee.demo.repository;

import com.altimetrik.ee.demo.entity.Product;

import java.util.List;


public interface ProductDao {

	Product findBy(Long productId);
	Product findBy(String description);
	List<Product> findByCategory(String category);
	List<Product> findAll();
	
}
