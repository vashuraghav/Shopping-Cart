package com.altimetrik.ee.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "orders", catalog = "shopping_cart_db")
public class Order implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderId", unique = true, nullable = false)
	private Long orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordered", nullable = false, length = 19)
	private Date ordered;

	@Column(name = "status", nullable = false, length = 20)
	private String status;

	@Column(name = "total", nullable = false, precision = 10)
	private BigDecimal total;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<LineItem> linesItems = new ArrayList<LineItem>();

	public Order() {
	}

	public Order(Long orderId, Customer customer, Date ordered, String status, BigDecimal total, List<LineItem> linesItems) {
		this.orderId = orderId;
		this.customer = customer;
		this.ordered = ordered;
		this.status = status;
		this.total = total;
		this.linesItems = linesItems;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrdered() {
		return this.ordered;
	}

	public void setOrdered(Date ordered) {
		this.ordered = ordered;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<LineItem> getLinesItems() {
		return this.linesItems;
	}

	public void setLinesItems(List<LineItem> linesItems) {
		this.linesItems = linesItems;
	}

	public static class BuilderOrder {

		private Long orderId;
		private Customer customer;
		private Date ordered;
		private String status;
		private BigDecimal total;
		private List<LineItem> linesItems = new ArrayList<LineItem>();

		public BuilderOrder setOrderId(Long orderId) {
			this.orderId = orderId;
			return this;
		}

		public BuilderOrder setCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public BuilderOrder setOrdered(Date ordered) {
			this.ordered = ordered;
			return this;
		}

		public BuilderOrder setStatus(String status) {
			this.status = status;
			return this;
		}

		public BuilderOrder setTotal(BigDecimal total) {
			this.total = total;
			return this;
		}

		public BuilderOrder setLinesItems(List<LineItem> linesItems) {
			this.linesItems = linesItems;
			return this;
		}

		public Order build() {
			return new Order(this.orderId, this.customer, this.ordered,
					this.status, this.total, this.linesItems);
		}
	}
}
