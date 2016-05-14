package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Pager;
import com.fly.bean.Product;
import com.fly.dao.IProductDao;
import com.fly.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Resource
	private IProductDao productDao;
	
	
	@Transactional
	public void delete(Product entity) {
		productDao.delete(entity);
	}

	public List<Product> findAll() {
		List<Product> list=productDao.findAll();
		return list;
	}

	public Product findById(String id) {
		Product product=productDao.findById(id);
		return product;
	}

	@Transactional
	public void save(Product entity) {
		productDao.save(entity);
	}

	@Transactional
	public Product update(Product entity) {
		Product product=productDao.update(entity);
		return product;
	}

	public List<Product> findByCategoryId(String categoryId) {
		return productDao.findByCategoryId(categoryId);
	}

	public List<Product> search(String key) {
		return productDao.search(key);
	}

	public Pager searchByPage(String key, Integer ps, Integer pn) {
		return productDao.searchByPage(key, ps, pn);
	}

	
}
