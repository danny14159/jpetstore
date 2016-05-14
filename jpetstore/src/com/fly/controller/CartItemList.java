package com.fly.controller;

import java.util.ArrayList;
import java.util.List;

import com.fly.bean.Item;
import com.fly.bean.Lineitem;
import com.fly.bean.LineitemId;
import com.fly.bean.Orders;


public class CartItemList {

	private List<CartItem> cartItemList = new ArrayList<CartItem>();;
	
	private int numberOfItems = 0;
	
	private double subTotal = 0.0;
	
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**�䶯���ﳵ��Ʒ����ӻ���ɾ������item��quantity���Ծ���
	 * @param item ֻ������Product,Item,Inventory,quantity����
	 */
	public void insertItem(CartItem item){
		int indexOfItem = cartItemList.indexOf(item);
		if(indexOfItem == -1){
			if(item.getQuantity()>0){
				cartItemList.add(item);
			}
		}
		else{
			CartItem originItem = cartItemList.get(indexOfItem);
			originItem.setQuantity(originItem.getQuantity()+item.getQuantity());
		}
		update();
	}
	
	public void removeByItemId(String itemId){
		CartItem citem = new CartItem();
		Item item = new Item();
		item.setItemid(itemId);
		citem.setItem(item);
		int removeIndex = cartItemList.indexOf(citem);
		if(removeIndex>-1){
			cartItemList.remove(removeIndex);
		}
		update();
	}
	
	/**
	 * ������Ʒ��������Ʒ�ܼ�
	 */
	private void update(){
		int numberOfItems = 0;
		
		double subTotal = 0.0;
		int cutIndex = -1;
		for(int i = 0,len = cartItemList.size();i<len;i++){
			CartItem item = cartItemList.get(i);
			if(item.getQuantity() >0){
				numberOfItems += item.getQuantity();
				subTotal += item.getTotalPrice();
			}
			else cutIndex = i;
		}
		
		//ɾ��С��0����Ʒ��
		if(cutIndex > -1)
			cartItemList.remove(cutIndex);
		
		this.numberOfItems = numberOfItems;
		this.subTotal = subTotal;
	}
	
	/**���ڴ��е�itemת���ɿ��Դ洢�����ݿ��item
	 * @param orderId
	 * @return
	 */
	public List<Lineitem> asLineList(double orderId){
		
		List<Lineitem> list = new ArrayList<Lineitem>();
		for(int i = 0,len=cartItemList.size();i<len;i++){
			CartItem citem = cartItemList.get(i);
			Lineitem litem = new Lineitem(new LineitemId((double)orderId, (double)(i+1)), citem.getItem().getItemid(), citem.getQuantity(), citem.getTotalPrice());
			list.add(litem);
		}
		
		return list;
		
	}
}
