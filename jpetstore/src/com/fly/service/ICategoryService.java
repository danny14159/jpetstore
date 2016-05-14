package com.fly.service;

import java.util.List;

import com.fly.bean.Category;

public interface ICategoryService {
	/**
	 * 添加Category
	 * @param entity
	 */
	public void save(Category entity);
/**
 * 删除 Category
 * @param entity
 */
	public void delete(Category entity);
/**
 * 更新Category
 * @param entity
 * @return
 */
	public Category update(Category entity);
/**
 * 通过id 寻找Category
 * @param id
 * @return Category
 */
	public Category findById(String id);
/**
 * 查找所有 Category
 * @return List<Category> 
 */
	public List<Category> findAll();
}
