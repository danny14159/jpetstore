package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Profile;
import com.fly.dao.IProfileDAO;
import com.fly.service.IProfileService;
@Service
public class ProfileService implements IProfileService {

	@Resource
	private IProfileDAO iprofile;
	
	@Transactional
	public void delete(Profile entity) {
		iprofile.delete(entity);
	}

	public List<Profile> findAll() {
		return iprofile.findAll();
	}

	public Profile findById(String id) {
		return iprofile.findById(id);
	}

	@Transactional
	public void save(Profile entity) {
		iprofile.save(entity);
	}

	@Transactional
	public Profile  update(Profile entity) {
		return iprofile.update(entity);
	}

}
