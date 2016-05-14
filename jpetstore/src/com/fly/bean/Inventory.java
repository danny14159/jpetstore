package com.fly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Inventory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inventory")
public class Inventory implements java.io.Serializable {
	
	// Fields
	
	private String itemid;
	private Double qty;

	// Constructors

	/** default constructor */
	public Inventory() {
	}

	/** full constructor */
	public Inventory(String itemid, Double qty) {
		this.itemid = itemid;
		this.qty = qty;
	}

	// Property accessors
	@Id
	@Column(name = "ITEMID", unique = true, nullable = false, length = 10)
	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	@Column(name = "QTY", nullable = false, precision = 0)
	public Double getQty() {
		return this.qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

}