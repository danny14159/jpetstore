package com.fly.dao;

import java.util.List;

import com.fly.bean.Inventory;

public interface IInventoryDAO {
	public void save(Inventory entity);
	public void delete(Inventory entity);
	public Inventory update(Inventory entity);
	public Inventory findById(String id);
	public List<Inventory> findAll();
}
