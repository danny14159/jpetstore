package com.fly.service;

import java.util.List;

import com.fly.bean.Orders;

public interface IOrdersService {
/**
 * ���IOrders
 * @param entity
 */
	public void save(Orders entity);
	/**
	 * ɾ��IOrders
	 * @param entity
	 */
	public void delete(Orders entity);
/**
 * ����Orders
 * @param entity
 * @return Orders
 */
	public Orders update(Orders entity);
/**
 * ͨ��id����Orders
 * @param id
 * @return Orders
 */
	public Orders findById(double id);
/**
 * ͨ��UserId����Orders
 * @param userid
 * @return List<Orders>
 */
	public List<Orders> findByUserId(String userid);
/**
 * ��������Orders
 * @return List<Orders>
 */
	public List<Orders> findAll();
	
	/**
	 * Ѱ��Orderid����order
	 * @return Orders
	 */
	public Orders findMaxOrderBySql();
}
