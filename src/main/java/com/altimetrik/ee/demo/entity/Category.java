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
@Table(name = "categories", catalog = "shopping_cart_db")
public class Category implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "categoryId", unique = true, nullable = false)
	private Integer categoryId;

	@Column(name = "description", nullable = false, length = 20)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Product> products = new ArrayList<Product>();

	public Category() {
	}

	public Category(String description) {
		this.description = description;
	}

	public Category(String description, List<Product> products) {
		this.description = description;
		this.products = products;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> productses) {
		this.products = productses;
	}

}
