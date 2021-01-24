package com.altimetrik.ee.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customers", catalog = "shopping_cart_db")
public class Customer implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customerId", unique = true, nullable = false)
	private Long customerId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "password", nullable = false, length = 256)
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Order> orders = new ArrayList<Order>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Cart> carts = new ArrayList<Cart>();

	public Customer() {
	}

	public Customer(Long customerId, String lastName, String firstName, String username, String password) {
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}

	public Long getIdcustomer() {
		return this.customerId;
	}

	public void setIdcustomer(Long idcustomer) {
		this.customerId = idcustomer;
	}

	public String getFirstName() { return this.firstName; }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

}
