package com.fly.service;

import java.util.List;

import com.fly.bean.Bannerdata;

public interface IBannerdataService {
/**
 * 添加Bannerdata
 * @param entity
 */
	public void save(Bannerdata entity);
/**
 * 删除Bannerdata
 * @param entity
 */
	public void delete(Bannerdata entity);
/**
 * 更新Bannerdata
 * @param entity
 * @return
 */
	public Bannerdata update(Bannerdata entity);
/**
 * 通过id查找Bannerdata
 * @param id
 * @return Bannerdata
 */
	public Bannerdata findById(String id);
/**
 * 通过bannername 查找Bannername
 * @param bannername
 * @return List<Bannerdata>
 */
	public List<Bannerdata> findByBannername(String bannername);
/**
 * 查找所有Bannerdate
 * @return List<Bannerdata>
 */
	public List<Bannerdata> findAll();
}
