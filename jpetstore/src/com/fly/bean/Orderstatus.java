package com.fly.bean;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Orderstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderstatus")
public class Orderstatus implements java.io.Serializable {

	// Fields

	private OrderstatusId id;
	private Orders orders;
	private Timestamp timestamp;
	private String status;

	// Constructors

	/** default constructor */
	public Orderstatus() {
	}

	/** full constructor */
	public Orderstatus(OrderstatusId id, Orders orders, Timestamp timestamp,
			String status) {
		this.id = id;
		this.orders = orders;
		this.timestamp = timestamp;
		this.status = status;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "orderid", column = @Column(name = "ORDERID", nullable = false, precision = 0)),
			@AttributeOverride(name = "linenum", column = @Column(name = "LINENUM", nullable = false, precision = 0)) })
	public OrderstatusId getId() {
		return this.id;
	}

	public void setId(OrderstatusId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERID", nullable = false, insertable = false, updatable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Column(name = "TIMESTAMP", nullable = false, length = 7)
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "STATUS", nullable = false, length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}