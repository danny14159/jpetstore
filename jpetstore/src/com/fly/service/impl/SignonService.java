package com.fly.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fly.bean.Signon;
import com.fly.dao.ISignonDAO;
import com.fly.service.ISignonService;


@Service
public class SignonService implements ISignonService {

	@Resource
	private ISignonDAO isignon;
	
	@Transactional
	public void delete(Signon entity) {
		isignon.delete(entity);
	}

	public List<Signon> findAll() {
		return isignon.findAll();
	}

	public Signon findById(String id) {
		return isignon.findById(id);
	}

	@Transactional
	public void save(Signon entity) {
		isignon.save(entity);
	}

	@Transactional
	public Signon  update(Signon entity) {
		return isignon.update(entity);
	}

}
