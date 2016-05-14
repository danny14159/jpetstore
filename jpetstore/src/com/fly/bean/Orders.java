package com.fly.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable {

	// Fields

	private Double orderid;
	private Account account;
	private Timestamp orderdate;
	private String shipaddr1;
	private String shipaddr2;
	private String shipcity;
	private String shipstate;
	private String shipzip;
	private String shipcountry;
	private String billaddr1;
	private String billaddr2;
	private String billcity;
	private String billstate;
	private String billzip;
	private String billcountry;
	private String courier;
	private Double totalprice;
	private String billtofirstname;
	private String billtolastname;
	private String shiptofirstname;
	private String shiptolastname;
	private String creditcard;
	private String exprdate;
	private String cardtype;
	private String locale;
	private Set<Orderstatus> orderstatuses = new HashSet<Orderstatus>(0);
	private Set<Lineitem> lineitems = new HashSet<Lineitem>(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Double orderid, Account account, Timestamp orderdate,
			String shipaddr1, String shipcity, String shipstate,
			String shipzip, String shipcountry, String billaddr1,
			String billcity, String billstate, String billzip,
			String billcountry, String courier, Double totalprice,
			String billtofirstname, String billtolastname,
			String shiptofirstname, String shiptolastname, String creditcard,
			String exprdate, String cardtype, String locale) {
		this.orderid = orderid;
		this.account = account;
		this.orderdate = orderdate;
		this.shipaddr1 = shipaddr1;
		this.shipcity = shipcity;
		this.shipstate = shipstate;
		this.shipzip = shipzip;
		this.shipcountry = shipcountry;
		this.billaddr1 = billaddr1;
		this.billcity = billcity;
		this.billstate = billstate;
		this.billzip = billzip;
		this.billcountry = billcountry;
		this.courier = courier;
		this.totalprice = totalprice;
		this.billtofirstname = billtofirstname;
		this.billtolastname = billtolastname;
		this.shiptofirstname = shiptofirstname;
		this.shiptolastname = shiptolastname;
		this.creditcard = creditcard;
		this.exprdate = exprdate;
		this.cardtype = cardtype;
		this.locale = locale;
	}

	/** full constructor */
	public Orders(Double orderid, Account account, Timestamp orderdate,
			String shipaddr1, String shipaddr2, String shipcity,
			String shipstate, String shipzip, String shipcountry,
			String billaddr1, String billaddr2, String billcity,
			String billstate, String billzip, String billcountry,
			String courier, Double totalprice, String billtofirstname,
			String billtolastname, String shiptofirstname,
			String shiptolastname, String creditcard, String exprdate,
			String cardtype, String locale, Set<Orderstatus> orderstatuses,
			Set<Lineitem> lineitems) {
		this.orderid = orderid;
		this.account = account;
		this.orderdate = orderdate;
		this.shipaddr1 = shipaddr1;
		this.shipaddr2 = shipaddr2;
		this.shipcity = shipcity;
		this.shipstate = shipstate;
		this.shipzip = shipzip;
		this.shipcountry = shipcountry;
		this.billaddr1 = billaddr1;
		this.billaddr2 = billaddr2;
		this.billcity = billcity;
		this.billstate = billstate;
		this.billzip = billzip;
		this.billcountry = billcountry;
		this.courier = courier;
		this.totalprice = totalprice;
		this.billtofirstname = billtofirstname;
		this.billtolastname = billtolastname;
		this.shiptofirstname = shiptofirstname;
		this.shiptolastname = shiptolastname;
		this.creditcard = creditcard;
		this.exprdate = exprdate;
		this.cardtype = cardtype;
		this.locale = locale;
		this.orderstatuses = orderstatuses;
		this.lineitems = lineitems;
	}

	
	public Orders(Double orderid, Account account, Timestamp orderdate,
			String shipaddr1, String shipaddr2, String shipcity,
			String shipstate, String shipzip, String shipcountry,
			String billaddr1, String billaddr2, String billcity,
			String billstate, String billzip, String billcountry,
			String courier, Double totalprice, String billtofirstname,
			String billtolastname, String shiptofirstname,
			String shiptolastname, String creditcard, String exprdate,
			String cardtype, String locale) {
		super();
		this.orderid = orderid;
		this.account = account;
		this.orderdate = orderdate;
		this.shipaddr1 = shipaddr1;
		this.shipaddr2 = shipaddr2;
		this.shipcity = shipcity;
		this.shipstate = shipstate;
		this.shipzip = shipzip;
		this.shipcountry = shipcountry;
		this.billaddr1 = billaddr1;
		this.billaddr2 = billaddr2;
		this.billcity = billcity;
		this.billstate = billstate;
		this.billzip = billzip;
		this.billcountry = billcountry;
		this.courier = courier;
		this.totalprice = totalprice;
		this.billtofirstname = billtofirstname;
		this.billtolastname = billtolastname;
		this.shiptofirstname = shiptofirstname;
		this.shiptolastname = shiptolastname;
		this.creditcard = creditcard;
		this.exprdate = exprdate;
		this.cardtype = cardtype;
		this.locale = locale;
	}

	// Property accessors
	@Id
	@Column(name = "ORDERID", unique = true, nullable = false, precision = 0)
	public Double getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Double orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "ORDERDATE", nullable = false, length = 7)
	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	@Column(name = "SHIPADDR1", nullable = false, length = 80)
	public String getShipaddr1() {
		return this.shipaddr1;
	}

	public void setShipaddr1(String shipaddr1) {
		this.shipaddr1 = shipaddr1;
	}

	@Column(name = "SHIPADDR2", length = 80)
	public String getShipaddr2() {
		return this.shipaddr2;
	}

	public void setShipaddr2(String shipaddr2) {
		this.shipaddr2 = shipaddr2;
	}

	@Column(name = "SHIPCITY", nullable = false, length = 80)
	public String getShipcity() {
		return this.shipcity;
	}

	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}

	@Column(name = "SHIPSTATE", nullable = false, length = 80)
	public String getShipstate() {
		return this.shipstate;
	}

	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}

	@Column(name = "SHIPZIP", nullable = false, length = 20)
	public String getShipzip() {
		return this.shipzip;
	}

	public void setShipzip(String shipzip) {
		this.shipzip = shipzip;
	}

	@Column(name = "SHIPCOUNTRY", nullable = false, length = 20)
	public String getShipcountry() {
		return this.shipcountry;
	}

	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}

	@Column(name = "BILLADDR1", nullable = false, length = 80)
	public String getBilladdr1() {
		return this.billaddr1;
	}

	public void setBilladdr1(String billaddr1) {
		this.billaddr1 = billaddr1;
	}

	@Column(name = "BILLADDR2", length = 80)
	public String getBilladdr2() {
		return this.billaddr2;
	}

	public void setBilladdr2(String billaddr2) {
		this.billaddr2 = billaddr2;
	}

	@Column(name = "BILLCITY", nullable = false, length = 80)
	public String getBillcity() {
		return this.billcity;
	}

	public void setBillcity(String billcity) {
		this.billcity = billcity;
	}

	@Column(name = "BILLSTATE", nullable = false, length = 80)
	public String getBillstate() {
		return this.billstate;
	}

	public void setBillstate(String billstate) {
		this.billstate = billstate;
	}

	@Column(name = "BILLZIP", nullable = false, length = 20)
	public String getBillzip() {
		return this.billzip;
	}

	public void setBillzip(String billzip) {
		this.billzip = billzip;
	}

	@Column(name = "BILLCOUNTRY", nullable = false, length = 20)
	public String getBillcountry() {
		return this.billcountry;
	}

	public void setBillcountry(String billcountry) {
		this.billcountry = billcountry;
	}

	@Column(name = "COURIER", nullable = false, length = 80)
	public String getCourier() {
		return this.courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	@Column(name = "TOTALPRICE", nullable = false, precision = 10)
	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	@Column(name = "BILLTOFIRSTNAME", nullable = false, length = 80)
	public String getBilltofirstname() {
		return this.billtofirstname;
	}

	public void setBilltofirstname(String billtofirstname) {
		this.billtofirstname = billtofirstname;
	}

	@Column(name = "BILLTOLASTNAME", nullable = false, length = 80)
	public String getBilltolastname() {
		return this.billtolastname;
	}

	public void setBilltolastname(String billtolastname) {
		this.billtolastname = billtolastname;
	}

	@Column(name = "SHIPTOFIRSTNAME", nullable = false, length = 80)
	public String getShiptofirstname() {
		return this.shiptofirstname;
	}

	public void setShiptofirstname(String shiptofirstname) {
		this.shiptofirstname = shiptofirstname;
	}

	@Column(name = "SHIPTOLASTNAME", nullable = false, length = 80)
	public String getShiptolastname() {
		return this.shiptolastname;
	}

	public void setShiptolastname(String shiptolastname) {
		this.shiptolastname = shiptolastname;
	}

	@Column(name = "CREDITCARD", nullable = false, length = 80)
	public String getCreditcard() {
		return this.creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	@Column(name = "EXPRDATE", nullable = false, length = 7)
	public String getExprdate() {
		return this.exprdate;
	}

	public void setExprdate(String exprdate) {
		this.exprdate = exprdate;
	}

	@Column(name = "CARDTYPE", nullable = false, length = 80)
	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	@Column(name = "LOCALE", nullable = false, length = 80)
	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Orderstatus> getOrderstatuses() {
		return this.orderstatuses;
	}

	public void setOrderstatuses(Set<Orderstatus> orderstatuses) {
		this.orderstatuses = orderstatuses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Lineitem> getLineitems() {
		return this.lineitems;
	}

	public void setLineitems(Set<Lineitem> lineitems) {
		this.lineitems = lineitems;
	}

}