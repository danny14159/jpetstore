package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Supplier;
import com.fly.dao.ISupplierDAO;
import com.fly.service.ISupplierService;

@Service
public class SupplierService implements ISupplierService {

	@Resource
	private ISupplierDAO supplierDAO;
	
	@Transactional
	public void delete(Supplier entity) {
		supplierDAO.delete(entity);
	}

	public List<Supplier> findAll() {
		return supplierDAO.findAll();
	}

	public Supplier findById(String id) {
		return supplierDAO.findById(id);
	}

	@Transactional
	public void save(Supplier entity) {
		supplierDAO.save(entity);
	}

	@Transactional
	public Supplier update(Supplier entity) {
		return supplierDAO.update(entity);
	}

}
