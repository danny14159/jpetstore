package com.fly.dao;

import java.util.List;

import com.fly.bean.Bannerdata;



/**
 * Interface for BannerdataDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IBannerdataDAO {
	
	public void save(Bannerdata entity);

	public void delete(Bannerdata entity);

	public Bannerdata update(Bannerdata entity);

	public Bannerdata findById(String id);

	public List<Bannerdata> findByBannername(String bannername);

	public List<Bannerdata> findAll();
}