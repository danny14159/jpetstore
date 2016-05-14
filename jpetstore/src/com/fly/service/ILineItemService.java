package com.fly.service;

import java.util.List;

import com.fly.bean.Lineitem;
import com.fly.bean.LineitemId;

public interface ILineItemService {
/**
 * ���LineItem
 * @param entity
 */
    public void save(Lineitem entity);
  /**
   * ɾ��LineItem
   * @param entity
   */
    public void delete(Lineitem entity);
 /**
  * ����LineItem
  * @param entity
  * @return Lineitem
  */
	public Lineitem update(Lineitem entity);
	/**
	 * ͨ��idѰ��Lineitem
	 * @param id
	 * @return Lineitem 
	 */
	public Lineitem findById( LineitemId id);
/**
 * ͨ�����Բ���Property
 * @param propertyName
 * @param value
 * @return List<Lineitem> 
 */
	public List<Lineitem> findByProperty(String propertyName, Object value);
	/**
	 * ͨ��itemid����Property
	 * @param itemid
	 * @return List<Lineitem>
	 */
	public List<Lineitem> findByItemid(Object itemid);
/**
 * ͨ��quantity����Property
 * @param quantity
 * @return  List<Lineitem>
 */
	public List<Lineitem> findByQuantity(Object quantity);
	/**
	 * ͨ��unitprice����Property
	 * @param quantity
	 * @return  List<Lineitem>
	 */
	public List<Lineitem> findByUnitprice(Object unitprice);
	/**
	 * ��������Property
	 * @param quantity
	 * @return  List<Lineitem>
	 */
	public List<Lineitem> findAll();	
}
