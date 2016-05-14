package com.fly.service;

import java.util.List;

import com.fly.bean.Inventory;

public interface IInventoryService {
	/**
	 * 保存
	 * @param entity传入存货清单的实体
	 */
	public void save(Inventory entity);
	/**
	 * 删除
	 * @param entity传入存货清单的实体
	 */
	public void delete(Inventory entity);
	/**
	 * 更新
	 * @param entity传入目录清单的实体
	 * @return目录清单的信息
	 */
	public Inventory update(Inventory entity);
	/**
	 * 根据目录ID得到目录清单
	 * @param itemId传入目录ID
	 * @return目录清单的信息
	 */
	public Inventory findByItemId(String itemId);
	/**
	 * 查找所有目录清单
	 * @return目录清单的集合
	 */
	public List<Inventory> findAll();

}
