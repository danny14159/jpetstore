package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Category;
import com.fly.dao.ICategoryDAO;
import com.fly.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Resource
	private ICategoryDAO categoryDAO;
	
	@Transactional
	public void delete(Category entity) {
		categoryDAO.delete(entity);
	}

	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	public Category findById(String id) {
		return categoryDAO.findById(id);
	}

	@Transactional
	public void save(Category entity) {
		categoryDAO.save(entity);
	}

	@Transactional
	public Category update(Category entity) {
		return categoryDAO.update(entity);
	}

}
