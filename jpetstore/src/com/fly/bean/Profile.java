package com.fly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Profile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "profile")
public class Profile implements java.io.Serializable {

	// Fields

	private String userid;
	@Override
	public String toString() {
		return "Profile [banneropt=" + banneropt + ", favcategory="
				+ favcategory + ", langpref=" + langpref + ", mylistopt="
				+ mylistopt + ", userid=" + userid + "]";
	}

	private String langpref;
	private String favcategory;
	private Double mylistopt;
	private Double banneropt;

	// Constructors

	/** default constructor */
	public Profile() {
	}

	/** minimal constructor */
	public Profile(String userid, String langpref) {
		this.userid = userid;
		this.langpref = langpref;
	}

	/** full constructor */
	public Profile(String userid, String langpref, String favcategory,
			Double mylistopt, Double banneropt) {
		this.userid = userid;
		this.langpref = langpref;
		this.favcategory = favcategory;
		this.mylistopt = mylistopt;
		this.banneropt = banneropt;
	}


	// Property accessors
	@Id
	@Column(name = "USERID", unique = true, nullable = false, length = 80)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "LANGPREF", nullable = false, length = 80)
	public String getLangpref() {
		return this.langpref;
	}

	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}

	@Column(name = "FAVCATEGORY", length = 30)
	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	@Column(name = "MYLISTOPT", precision = 0)
	public Double getMylistopt() {
		return this.mylistopt;
	}

	public void setMylistopt(Double mylistopt) {
		this.mylistopt = mylistopt;
	}

	@Column(name = "BANNEROPT", precision = 0)
	public Double getBanneropt() {
		return this.banneropt;
	}

	public void setBanneropt(Double banneropt) {
		this.banneropt = banneropt;
	}

}