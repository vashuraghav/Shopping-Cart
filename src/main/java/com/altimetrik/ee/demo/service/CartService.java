package com.altimetrik.ee.demo.service;


import com.altimetrik.ee.demo.entity.Cart;

public interface CartService {

	Long save(Cart cart);
	void add(Long cartId, Long productId, Integer quantity);
	Long ordered(Long cartId);

}
