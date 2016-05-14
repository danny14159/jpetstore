package com.fly.dao;

import java.util.List;

import com.fly.bean.Account;

/**
 * Interface for AccountDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IAccountDAO {

	public void save(Account entity);

	public void delete(Account entity);

	public Account update(Account entity);

	public Account findById(String id);

	public List<Account> findAll();
	

}