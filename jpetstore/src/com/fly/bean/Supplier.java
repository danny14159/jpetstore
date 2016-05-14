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
 * Supplier entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "supplier")
public class Supplier implements java.io.Serializable {

	// Fields

	private Double suppid;
	private String name;
	private String status;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private Set<Item> items = new HashSet<Item>(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** minimal constructor */
	public Supplier(Double suppid, String status) {
		this.suppid = suppid;
		this.status = status;
	}

	/** full constructor */
	public Supplier(Double suppid, String name, String status, String addr1,
			String addr2, String city, String state, String zip, String phone,
			Set<Item> items) {
		this.suppid = suppid;
		this.name = name;
		this.status = status;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.items = items;
	}

	// Property accessors
	@Id
	@Column(name = "SUPPID", unique = true, nullable = false, precision = 0)
	public Double getSuppid() {
		return this.suppid;
	}

	public void setSuppid(Double suppid) {
		this.suppid = suppid;
	}

	@Column(name = "NAME", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "STATUS", nullable = false, length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "ADDR1", length = 80)
	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	@Column(name = "ADDR2", length = 80)
	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	@Column(name = "CITY", length = 80)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE", length = 80)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ZIP", length = 5)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "PHONE", length = 80)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplier")
	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}