package com.altimetrik.ee.demo.service;

import com.altimetrik.ee.demo.entity.Product;
import com.altimetrik.ee.demo.exception.ProductNotFoundException;

import java.util.List;


public interface ProductService {

	Product findBy(Long productId) throws ProductNotFoundException;
	Product findBy(String description) throws ProductNotFoundException;
	List<Product> findByCategory(String category) throws ProductNotFoundException;
	List<Product> findAll() throws ProductNotFoundException;
	
}
