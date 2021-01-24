package com.altimetrik.ee.demo.service.impl;

import java.util.Date;

import com.altimetrik.ee.demo.entity.Cart;
import com.altimetrik.ee.demo.entity.LineItem;
import com.altimetrik.ee.demo.entity.Order;
import com.altimetrik.ee.demo.entity.Product;
import com.altimetrik.ee.demo.repository.CartDao;
import com.altimetrik.ee.demo.repository.OrderDao;
import com.altimetrik.ee.demo.repository.ProductDao;
import com.altimetrik.ee.demo.service.CartService;
import com.altimetrik.ee.demo.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CartServiceImp implements CartService {

	@Autowired
	CartDao cartDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;

	@Override
	public Long save(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public void add(Long cartId, Long productId, Integer quantity) {
		Cart cart = cartDao.findBy(cartId);
		Product product = productDao.findBy(productId);
		cart.getLinesItems().add(new LineItem(cart, product, quantity, product.getPrice()));
		cartDao.update(cart);
	}

	@Override
	public Long ordered(Long cartId) {
		Cart cart = cartDao.findBy(cartId);
		Order order = new Order.BuilderOrder()
				.setCustomer(cart.getCustomer())
				.setOrdered(new Date())
				.setStatus(OrderStatus.NEW.toString())
				.setTotal(cart.calculateTotal())
				.setLinesItems(cart.getLinesItems())
				.build();
		return orderDao.save(order);
	}

}
