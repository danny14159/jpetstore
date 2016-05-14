package com.fly.service;

import java.util.List;

import com.fly.bean.Category;

public interface ICategoryService {
	/**
	 * ���Category
	 * @param entity
	 */
	public void save(Category entity);
/**
 * ɾ�� Category
 * @param entity
 */
	public void delete(Category entity);
/**
 * ����Category
 * @param entity
 * @return
 */
	public Category update(Category entity);
/**
 * ͨ��id Ѱ��Category
 * @param id
 * @return Category
 */
	public Category findById(String id);
/**
 * �������� Category
 * @return List<Category> 
 */
	public List<Category> findAll();
}
