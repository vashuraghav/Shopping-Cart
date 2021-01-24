package com.altimetrik.ee.demo.service.impl;

import java.util.List;

import com.altimetrik.ee.demo.entity.Product;
import com.altimetrik.ee.demo.exception.ProductNotFoundException;
import com.altimetrik.ee.demo.repository.ProductDao;
import com.altimetrik.ee.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public Product findBy(Long productId) throws ProductNotFoundException {
		Product product = productDao.findBy(productId);
		if (product != null)
			return product;
		else
			throw new ProductNotFoundException();
	}

	@Override
	public Product findBy(String description) throws ProductNotFoundException {
		Product product = productDao.findBy(description);
		if (product != null)
			return product;
		else
			throw new ProductNotFoundException();
	}

	@Override
	public List<Product> findByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productDao.findByCategory(category);
		if (products.isEmpty() || products == null)
			throw new ProductNotFoundException();
		else
			return products;
	}

	@Override
	public List<Product> findAll() throws ProductNotFoundException {
		List<Product> products = productDao.findAll();
		if (products.isEmpty() || products == null)
			throw new ProductNotFoundException();
		else
			return products;
	}

}
