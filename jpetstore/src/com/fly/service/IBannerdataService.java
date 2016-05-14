package com.fly.service;

import java.util.List;

import com.fly.bean.Bannerdata;

public interface IBannerdataService {
/**
 * ���Bannerdata
 * @param entity
 */
	public void save(Bannerdata entity);
/**
 * ɾ��Bannerdata
 * @param entity
 */
	public void delete(Bannerdata entity);
/**
 * ����Bannerdata
 * @param entity
 * @return
 */
	public Bannerdata update(Bannerdata entity);
/**
 * ͨ��id����Bannerdata
 * @param id
 * @return Bannerdata
 */
	public Bannerdata findById(String id);
/**
 * ͨ��bannername ����Bannername
 * @param bannername
 * @return List<Bannerdata>
 */
	public List<Bannerdata> findByBannername(String bannername);
/**
 * ��������Bannerdate
 * @return List<Bannerdata>
 */
	public List<Bannerdata> findAll();
}
