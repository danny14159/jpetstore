package com.fly.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderstatusId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class OrderstatusId implements java.io.Serializable {

	// Fields

	private Double orderid;
	private Double linenum;

	// Constructors

	/** default constructor */
	public OrderstatusId() {
	}

	/** full constructor */
	public OrderstatusId(Double orderid, Double linenum) {
		this.orderid = orderid;
		this.linenum = linenum;
	}

	// Property accessors

	@Column(name = "ORDERID", nullable = false, precision = 0)
	public Double getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Double orderid) {
		this.orderid = orderid;
	}

	@Column(name = "LINENUM", nullable = false, precision = 0)
	public Double getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Double linenum) {
		this.linenum = linenum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderstatusId))
			return false;
		OrderstatusId castOther = (OrderstatusId) other;

		return ((this.getOrderid() == castOther.getOrderid()) || (this
				.getOrderid() != null
				&& castOther.getOrderid() != null && this.getOrderid().equals(
				castOther.getOrderid())))
				&& ((this.getLinenum() == castOther.getLinenum()) || (this
						.getLinenum() != null
						&& castOther.getLinenum() != null && this.getLinenum()
						.equals(castOther.getLinenum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderid() == null ? 0 : this.getOrderid().hashCode());
		result = 37 * result
				+ (getLinenum() == null ? 0 : this.getLinenum().hashCode());
		return result;
	}

}