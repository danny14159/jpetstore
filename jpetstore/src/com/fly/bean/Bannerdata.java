package com.fly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bannerdata entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bannerdata")
public class Bannerdata implements java.io.Serializable {

	// Fields

	private String favcategory;
	private String bannername;

	// Constructors

	/** default constructor */
	public Bannerdata() {
	}

	/** minimal constructor */
	public Bannerdata(String favcategory) {
		this.favcategory = favcategory;
	}

	/** full constructor */
	public Bannerdata(String favcategory, String bannername) {
		this.favcategory = favcategory;
		this.bannername = bannername;
	}

	// Property accessors
	@Id
	@Column(name = "FAVCATEGORY", unique = true, nullable = false, length = 80)
	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	@Column(name = "BANNERNAME")
	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

}