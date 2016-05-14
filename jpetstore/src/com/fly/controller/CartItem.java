package com.fly.controller;

import com.fly.bean.Inventory;
import com.fly.bean.Item;
import com.fly.bean.Product;


public class CartItem {

	private Product product;
	
	private Item item;
	
	private Inventory inventory;
	
	private double quantity;
	
	//以下三个属性需要更新
	private boolean inStock;
	
	private double totalPrice;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public boolean isInStock() {
		update();
		return inStock;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		this.update();
		return totalPrice;
	}

	@Override
	public boolean equals(Object obj) {
		CartItem item = (CartItem)obj;
		return item.getItem().getItemid().equals(this.getItem().getItemid());
	}
	
	@Override
	public int hashCode() {
		System.out.println("hash");
		return super.hashCode();
	}
	
	/**
	 * 更新自己的后两个个字段
	 */
	public void update(){
		this.inStock = this.inventory.getQty()>=quantity;
		this.totalPrice = this.quantity*item.getListprice();
	}
}
