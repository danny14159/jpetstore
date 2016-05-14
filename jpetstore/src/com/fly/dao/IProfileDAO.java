package com.fly.dao;

import java.util.List;

import com.fly.bean.Profile;

/**
 * Interface for ProfileDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IProfileDAO {

	public void save(Profile entity);

	public void delete(Profile entity);

	public Profile update(Profile entity);

	public Profile findById(String id);

	public List<Profile> findAll();
}