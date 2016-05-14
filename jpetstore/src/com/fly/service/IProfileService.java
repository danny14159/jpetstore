package com.fly.service;

import java.util.List;

import com.fly.bean.Profile;

public interface IProfileService {
	/**
	 * 添加profile
	 * @param entity
	 */
	public void save(Profile entity);
/**
 * 删除profile
 * @param entity
 */
	public void delete(Profile entity);
/**
 * 更新profile
 * @param entity
 * @return
 */
	public Profile update(Profile entity);
/**
 * 根据id 查找Profile
 * @param id
 * @return
 */
	public Profile findById(String id);
/**
 * 查找所有profile，以list形式return
 * @return list
 */
	public List<Profile> findAll();
}
