package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Bannerdata;
import com.fly.dao.IBannerdataDAO;
import com.fly.service.IBannerdataService;
@Service
public class BannerdataService implements IBannerdataService{

private IBannerdataDAO bannerdataDAO;
	public IBannerdataDAO getBannerdataDAO() {
		return bannerdataDAO;
	}
	@Resource
	public void setBannerdataDAO(IBannerdataDAO bannerdataDAO) {
		this.bannerdataDAO = bannerdataDAO;
	}
	@Transactional
	public void delete(Bannerdata entity) {
		bannerdataDAO.delete(entity);
		
	}

	public List<Bannerdata> findAll() {
		return bannerdataDAO.findAll();
	}

	public List<Bannerdata> findByBannername(String bannername) {
		return bannerdataDAO.findByBannername(bannername);
	}

	public Bannerdata findById(String id) {
		return bannerdataDAO.findById(id);
	}
	@Transactional
	public void save(Bannerdata entity) {
		bannerdataDAO.save(entity);
		
	}
	@Transactional
	public Bannerdata update(Bannerdata entity) {
		return bannerdataDAO.update(entity);

	}

}
