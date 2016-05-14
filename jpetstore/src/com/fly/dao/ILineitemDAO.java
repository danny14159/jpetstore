package com.fly.dao;

import java.util.List;

import com.fly.bean.Lineitem;
import com.fly.bean.LineitemId;


public interface ILineitemDAO {
		
    public void save(Lineitem entity);
  
    public void delete(Lineitem entity);
 
	public Lineitem update(Lineitem entity);
	
	public Lineitem findById( LineitemId id);

	public List<Lineitem> findByProperty(String propertyName, Object value);
	
	public List<Lineitem> findByItemid(Object itemid);
	
	public List<Lineitem> findByQuantity(Object quantity);
	
	public List<Lineitem> findByUnitprice(Object unitprice);

	public List<Lineitem> findAll();	
}