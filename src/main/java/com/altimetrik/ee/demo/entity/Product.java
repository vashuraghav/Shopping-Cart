package com.altimetrik.ee.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products", catalog = "shopping_cart_db")
public class Product implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "productId", unique = true, nullable = false)
	private Long productId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Category category;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "price", nullable = false, precision = 10)
	private BigDecimal price;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<LineItem> linesItems = new ArrayList<LineItem>();

	public Product() {
	}

	public Product(String description, BigDecimal price) {
		this.description = description;
		this.price = price;
	}

	public Product(Category category, String description, BigDecimal price, List<LineItem> linesItems) {
		this.category = category;
		this.description = description;
		this.price = price;
		this.linesItems = linesItems;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<LineItem> getLinesItems() {
		return this.linesItems;
	}

	public void setLinesItems(List<LineItem> linesItems) {
		this.linesItems = linesItems;
	}

}
