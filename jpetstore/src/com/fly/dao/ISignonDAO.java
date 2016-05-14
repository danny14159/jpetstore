package com.fly.dao;

import java.util.List;

import com.fly.bean.Signon;

/**
 * Interface for SignonDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISignonDAO {

	public void save(Signon entity);

	public void delete(Signon entity);

	public Signon update(Signon entity);

	public Signon findById(String id);

	public List<Signon> findAll();
}