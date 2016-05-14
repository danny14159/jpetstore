package com.fly.service;

import java.util.List;

import com.fly.bean.Supplier;

public interface ISupplierService {
	/**
	 * ���ISupplier
	 * @param entity
	 */
	public void save(Supplier entity);
/**
 * ɾ��ISupplier
 * @param entity
 */
	public void delete(Supplier entity);
/**
 * ����ISupplier
 * @param entity
 * @return Supplier
 */
	public Supplier update(Supplier entity);
/**
 * ͨ��id ����ISupplier
 * @param id
 * @return Supplier
 */
	public Supplier findById(String id);
/**
 * ��������ISupplier
 * @returnList<Supplier>
 */
	public List<Supplier> findAll();
}
