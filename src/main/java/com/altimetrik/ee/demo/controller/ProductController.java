package com.altimetrik.ee.demo.controller;

import java.util.List;

import com.altimetrik.ee.demo.entity.Product;
import com.altimetrik.ee.demo.exception.ProductNotFoundException;
import com.altimetrik.ee.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
		List<Product> products = productService.findAll();
		return new ResponseEntity<List<Product>> (products, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Product> getBy(@PathVariable("productId") Long productId) throws ProductNotFoundException  {
		Product product = productService.findBy(productId);
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products?description={description}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Product> getByDescription(@PathVariable("description") String description) throws ProductNotFoundException  {
		Product product = productService.findBy(description);
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getByCategory(@RequestParam("category") String category) throws ProductNotFoundException  {
		List<Product> products = productService.findByCategory(category);
		return new ResponseEntity<List<Product>> (products, HttpStatus.OK);
	}

}
