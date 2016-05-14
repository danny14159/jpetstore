package com.fly.service;

import java.util.List;

import com.fly.bean.Signon;

public interface ISignonService {
/**
 * 添加Signon信息
 * @param entity
 */
	public void save(Signon entity);
/**
 * 删除Signon信息
 * @param entity
 */
	public void delete(Signon entity);
/**
 * 更新Signon信息
 * @param entity
 * @return
 */
	public Signon update(Signon entity);
/**
 * 通过id查找对应的Signon信息
 * @param id
 * @return Signon
 */
	public Signon findById(String id);
/**
 * 查找所有Signon信息
 * @return List
 */
	public List<Signon> findAll();
}
