package com.fly.service;

import java.util.List;

import com.fly.bean.Item;

public interface IItemService {
	/**
	 * 目录的保存
	 * @param entity传入目录的实体
	 */
	public void save(Item entity);
	/**
	 * 目录的删除
	 * @param entity传入目录的实体
	 */
	public void delete(Item entity);
	/**
	 * 目录的更新
	 * @param entity传入目录的实体
	 * @return目录信息
	 */
	public Item update(Item entity);
	/**
	 * 根据ID查找
	 * @param id传入目录的ID
	 * @return目录信息
	 */
	public Item findById(String id);
	/**
	 * 查找所有信息放到list中
	 * @return
	 */
	public List<Item> findAll();
	/**
	 * 根据产品ID查找信息
	 * @param productId传入产品ID
	 * @return目录的集合
	 */
	public List<Item> listByProductId(String productId);

}
