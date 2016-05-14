package com.fly.service;

import java.util.List;

import com.fly.bean.Account;
import com.fly.bean.Profile;
import com.fly.bean.Signon;


public interface IAccountService {
	/**
	 * 添加Account
	 * @param entity
	 */
	public void save(Account entity);
/**
 * 删除Account
 * @param entity
 */
	public void delete(Account  entity);
/**
 * 更新Account
 * @param entity
 * @return 
 */
	public Account update(Account entity);
/**
 * 通过id查找account
 * @param id
 * @return Account
 */
	public Account  findById(String id);
/**
 * 得到所有账户信息，
 * @return list<Account> 
 */
	public List<Account> findAll();
	/**
	 * 
	 * @param signon
	 * @return Account 对象  返回null表示用户不存在，非空表示正常登陆，返回Account
	 */
	public Account login(Signon signon);
	/**
	 * 存储用户的Signon信息，account信息，profile信息
	 * @param signon
	 * @param profile
	 * @param account
	 */
	public boolean setAccount (Signon signon,Profile profile, Account account);
	
	/**
	 * 更新Account信息
	 * @param account
	 * @param profile
	 * @param signon
	 * @return
	 */
	
	public boolean updateAccount(Account account, Profile profile, Signon signon);
}
