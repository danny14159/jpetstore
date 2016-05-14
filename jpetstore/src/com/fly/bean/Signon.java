package com.fly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Signon entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "signon")
public class Signon implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Signon [password=" + password + ", username=" + username + "]";
	}

	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public Signon() {
	}

	/** full constructor */
	public Signon(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Property accessors
	@Id
	@Column(name = "USERNAME", unique = true, nullable = false, length = 25)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 25)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}