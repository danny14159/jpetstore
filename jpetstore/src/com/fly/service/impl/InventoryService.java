package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Inventory;
import com.fly.dao.IInventoryDAO;
import com.fly.service.IInventoryService;
@Service
public class InventoryService implements IInventoryService {
	@Resource
	private IInventoryDAO inventoryDao;
	@Transactional
	public void delete(Inventory entity) {
		// TODO Auto-generated method stub
		inventoryDao.delete(entity);

	}

	public List<Inventory> findAll() {
		// TODO Auto-generated method stub
		return inventoryDao.findAll();
	}

	public Inventory findByItemId(String itemId) {
		// TODO Auto-generated method stub
		return inventoryDao.findById(itemId);
	}
	@Transactional
	public void save(Inventory entity) {
		// TODO Auto-generated method stub
		inventoryDao.save(entity);

	}
	@Transactional
	public Inventory update(Inventory entity) {
		// TODO Auto-generated method stub
		return inventoryDao.update(entity);
	}

}
