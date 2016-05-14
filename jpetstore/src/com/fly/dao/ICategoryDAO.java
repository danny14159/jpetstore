package com.fly.dao;

import java.util.List;

import com.fly.bean.Category;

/**
 * Interface for CategoryDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICategoryDAO {
	
	public void save(Category entity);

	public void delete(Category entity);

	public Category update(Category entity);

	public Category findById(String id);

	public List<Category> findAll();
}