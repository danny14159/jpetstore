package com.fly.service;

import java.util.List;

import com.fly.bean.Supplier;

public interface ISupplierService {
	/**
	 * 添加ISupplier
	 * @param entity
	 */
	public void save(Supplier entity);
/**
 * 删除ISupplier
 * @param entity
 */
	public void delete(Supplier entity);
/**
 * 更新ISupplier
 * @param entity
 * @return Supplier
 */
	public Supplier update(Supplier entity);
/**
 * 通过id 查找ISupplier
 * @param id
 * @return Supplier
 */
	public Supplier findById(String id);
/**
 * 查找所有ISupplier
 * @returnList<Supplier>
 */
	public List<Supplier> findAll();
}
