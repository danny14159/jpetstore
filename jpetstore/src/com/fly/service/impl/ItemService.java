package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Item;
import com.fly.dao.IItemDAO;
import com.fly.service.IItemService;
@Repository
public class ItemService implements IItemService {
	@Resource
	private IItemDAO itemDao;
	public void delete(Item entity) {
		// TODO Auto-generated method stub
		itemDao.delete(entity);

	}

	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemDao.findAll();
	}

	public Item findById(String id) {
		// TODO Auto-generated method stub
		return itemDao.findById(id);
	}

	public void save(Item entity) {
		// TODO Auto-generated method stub
		itemDao.save(entity);

	}

	public Item update(Item entity) {
		// TODO Auto-generated method stub
		return itemDao.update(entity);
	}
	@Transactional
	public List<Item> listByProductId(String productId) {
		// TODO Auto-generated method stub
		return itemDao.listByProductId(productId);
	}
	
}
