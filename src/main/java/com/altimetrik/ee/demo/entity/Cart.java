package com.altimetrik.ee.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "carts", catalog = "shopping_cart_db")
public class Cart implements Serializable {

	@Id
	@Column(name = "cartId", unique = true, nullable = false)
	private Long cartId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	@Column(name = "subtotal", nullable = false, precision = 10)
	private BigDecimal subtotal;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<LineItem> linesItems = new ArrayList<LineItem>();

	public Cart() {
	}

	public Cart(Long cartId, Customer customer, BigDecimal subtotal) {
		this.cartId = cartId;
		this.customer = customer;
		this.subtotal = subtotal;
	}

	public Cart(Long cartId, Customer customer, BigDecimal subtotal, List<LineItem> linesItems) {
		this.cartId = cartId;
		this.customer = customer;
		this.subtotal = subtotal;
		this.linesItems = linesItems;
	}


	public Long getCartId() {
		return this.cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customers) {
		this.customer = customers;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public List<LineItem> getLinesItems() {
		return this.linesItems;
	}

	public void setLinesItems(List<LineItem> linesItems) {
		this.linesItems = linesItems;
	}
	
	public BigDecimal calculateTotal(){
		BigDecimal total = BigDecimal.ZERO;
		for (LineItem lineItem : this.getLinesItems()) {
			total.add(lineItem.getPrice().multiply(new BigDecimal(lineItem.getQuantity())));		
		}
		return total;
	}
}
