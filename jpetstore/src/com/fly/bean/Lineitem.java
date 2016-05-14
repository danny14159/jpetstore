package com.fly.bean;

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
 * Lineitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lineitem")
public class Lineitem implements java.io.Serializable {

	// Fields

	private LineitemId id;
	@Override
	public String toString() {
		return "Lineitem [id=" + id + ", itemid=" + itemid + ", orders="
				+ orders + ", quantity=" + quantity + ", unitprice="
				+ unitprice + "]";
	}

	private Orders orders;
	private String itemid;
	private Double quantity;
	private Double unitprice;

	// Constructors

	/** default constructor */
	public Lineitem() {
	}

	/** full constructor */
	public Lineitem(LineitemId id, Orders orders, String itemid,
			Double quantity, Double unitprice) {
		this.id = id;
		this.orders = orders;
		this.itemid = itemid;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "orderid", column = @Column(name = "ORDERID", nullable = false, precision = 0)),
			@AttributeOverride(name = "linenum", column = @Column(name = "LINENUM", nullable = false, precision = 0)) })
	public LineitemId getId() {
		return this.id;
	}

	public void setId(LineitemId id) {
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

	@Column(name = "ITEMID", nullable = false, length = 10)
	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	@Column(name = "QUANTITY", nullable = false, precision = 0)
	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Column(name = "UNITPRICE", nullable = false, precision = 10)
	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Lineitem(LineitemId id, String itemid, Double quantity,
			Double unitprice) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

}