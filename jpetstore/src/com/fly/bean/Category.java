package com.fly.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	// Fields

	private String catid;
	private String name;
	private String descn;
	
	private Set<Product> products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String catid) {
		this.catid = catid;
	}

	/** full constructor */
	public Category(String catid, String name, String descn,
			Set<Product> products) {
		this.catid = catid;
		this.name = name;
		this.descn = descn;
		this.products = products;
	}

	public Category(String catid, String name, String descn) {
		super();
		this.catid = catid;
		this.name = name;
		this.descn = descn;
	}

	// Property accessors
	@Id
	@Column(name = "CATID", unique = true, nullable = false, length = 10)
	public String getCatid() {
		return this.catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	@Column(name = "NAME", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCN")
	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [catid=" + catid + ", descn=" + descn + ", name="
				+ name + "]";
	}


}