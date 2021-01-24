package com.altimetrik.ee.demo.repository;

import com.altimetrik.ee.demo.entity.Cart;

public interface CartDao {

	Cart findBy(Long cartId);
	Long save(Cart cart);
	void update(Cart cart);
	
}
