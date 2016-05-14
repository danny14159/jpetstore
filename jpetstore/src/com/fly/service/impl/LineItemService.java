package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Lineitem;
import com.fly.bean.LineitemId;
import com.fly.dao.ILineitemDAO;
import com.fly.dao.impl.LineitemDAO;
import com.fly.service.ILineItemService;

@Service
public class LineItemService implements ILineItemService {

	@Resource
	private ILineitemDAO lineItemDAO;
	
	@Transactional
	public void delete(Lineitem entity) {
		// TODO Auto-generated method stub
		lineItemDAO.delete(entity);
	}

	public List<Lineitem> findAll() {
		// TODO Auto-generated method stub
		return lineItemDAO.findAll();
	}

	public Lineitem findById(LineitemId id) {
		// TODO Auto-generated method stub
		return lineItemDAO.findById(id);
	}

	public List<Lineitem> findByItemid(Object itemid) {
		// TODO Auto-generated method stub
		return lineItemDAO.findByItemid(itemid);
	}


	public List<Lineitem> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return lineItemDAO.findByProperty(propertyName, value);
	}

	public List<Lineitem> findByQuantity(Object quantity) {
		// TODO Auto-generated method stub
		return lineItemDAO.findByQuantity(quantity);
	}

	public List<Lineitem> findByUnitprice(Object unitprice) {
		// TODO Auto-generated method stub
		return lineItemDAO.findByUnitprice(unitprice);
	}

	@Transactional
	public void save(Lineitem entity) {
		// TODO Auto-generated method stub

		lineItemDAO.save(entity);
	}

	@Transactional
	public Lineitem update(Lineitem entity) {
		// TODO Auto-generated method stub
		return lineItemDAO.update(entity);
	}

}
