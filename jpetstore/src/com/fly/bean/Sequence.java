package com.fly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sequence entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sequence")
public class Sequence implements java.io.Serializable {

	// Fields

	private String name;
	private Double nextid;

	// Constructors

	/** default constructor */
	public Sequence() {
	}

	/** full constructor */
	public Sequence(String name, Double nextid) {
		this.name = name;
		this.nextid = nextid;
	}

	// Property accessors
	@Id
	@Column(name = "NAME", unique = true, nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NEXTID", nullable = false, precision = 0)
	public Double getNextid() {
		return this.nextid;
	}

	public void setNextid(Double nextid) {
		this.nextid = nextid;
	}

}