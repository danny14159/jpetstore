package com.fly.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.fly.bean.Orders;



/**
 * Interface for OrdersDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IOrdersDAO {
	
	public void save(Orders entity);

	public void delete(Orders entity);

	public Orders update(Orders entity);

	public Orders findById(double  orderid);
	public List<Orders> findByUserId(String userid);

	
	public List<Orders> findAll();
	
	public Orders findMaxOrderBySql();
}