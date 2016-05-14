package com.fly.service;

import java.util.List;

import com.fly.bean.Lineitem;
import com.fly.bean.LineitemId;

public interface ILineItemService {
/**
 * 添加LineItem
 * @param entity
 */
    public void save(Lineitem entity);
  /**
   * 删除LineItem
   * @param entity
   */
    public void delete(Lineitem entity);
 /**
  * 更新LineItem
  * @param entity
  * @return Lineitem
  */
	public Lineitem update(Lineitem entity);
	/**
	 * 通过id寻找Lineitem
	 * @param id
	 * @return Lineitem 
	 */
	public Lineitem findById( LineitemId id);
/**
 * 通过属性查找Property
 * @param propertyName
 * @param value
 * @return List<Lineitem> 
 */
	public List<Lineitem> findByProperty(String propertyName, Object value);
	/**
	 * 通过itemid查找Property
	 * @param itemid
	 * @return List<Lineitem>
	 */
	public List<Lineitem> findByItemid(Object itemid);
/**
 * 通过quantity查找Property
 * @param quantity
 * @return  List<Lineitem>
 */
	public List<Lineitem> findByQuantity(Object quantity);
	/**
	 * 通过unitprice查找Property
	 * @param quantity
	 * @return  List<Lineitem>
	 */
	public List<Lineitem> findByUnitprice(Object unitprice);
	/**
	 * 查找所有Property
	 * @param quantity
	 * @return  List<Lineitem>
	 */
	public List<Lineitem> findAll();	
}
