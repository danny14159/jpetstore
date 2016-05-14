package com.fly.service;

import java.util.List;

import com.fly.bean.Profile;

public interface IProfileService {
	/**
	 * ���profile
	 * @param entity
	 */
	public void save(Profile entity);
/**
 * ɾ��profile
 * @param entity
 */
	public void delete(Profile entity);
/**
 * ����profile
 * @param entity
 * @return
 */
	public Profile update(Profile entity);
/**
 * ����id ����Profile
 * @param id
 * @return
 */
	public Profile findById(String id);
/**
 * ��������profile����list��ʽreturn
 * @return list
 */
	public List<Profile> findAll();
}
