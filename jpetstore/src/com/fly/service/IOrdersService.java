package com.fly.service;

import java.util.List;

import com.fly.bean.Orders;

public interface IOrdersService {
/**
 * 添加IOrders
 * @param entity
 */
	public void save(Orders entity);
	/**
	 * 删除IOrders
	 * @param entity
	 */
	public void delete(Orders entity);
/**
 * 更新Orders
 * @param entity
 * @return Orders
 */
	public Orders update(Orders entity);
/**
 * 通过id查找Orders
 * @param id
 * @return Orders
 */
	public Orders findById(double id);
/**
 * 通过UserId查找Orders
 * @param userid
 * @return List<Orders>
 */
	public List<Orders> findByUserId(String userid);
/**
 * 查找所有Orders
 * @return List<Orders>
 */
	public List<Orders> findAll();
	
	/**
	 * 寻找Orderid最大的order
	 * @return Orders
	 */
	public Orders findMaxOrderBySql();
}
