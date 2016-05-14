package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Bannerdata;
import com.fly.bean.Orders;
import com.fly.dao.IBannerdataDAO;
import com.fly.dao.IOrdersDAO;
import com.fly.service.IBannerdataService;
import com.fly.service.IOrdersService;

@Service
public class OrdersService implements IOrdersService{

	private IOrdersDAO ordersDAO;
	public IOrdersDAO getOrdersDAO() {
		return ordersDAO;
	}
@Resource
	public void setOrdersDAO(IOrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
@Transactional
	public void delete(Orders entity) {
		ordersDAO.delete(entity);
		
	}

	public List<Orders> findAll() {
		return ordersDAO.findAll();
	}

	public Orders findById(double id) {
		return ordersDAO.findById(id);
	}

	public List<Orders> findByUserId(String userid) {
		return ordersDAO.findByUserId(userid);
	}
	@Transactional

	public void save(Orders entity) {
		ordersDAO.save(entity);
		
	}
	@Transactional
	public Orders update(Orders entity) {
		return ordersDAO.update(entity);
	}
	public Orders findMaxOrderBySql() {
		// TODO Auto-generated method stub
		return ordersDAO.findMaxOrderBySql();
	}
	
}
