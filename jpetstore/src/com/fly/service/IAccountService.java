package com.fly.service;

import java.util.List;

import com.fly.bean.Account;
import com.fly.bean.Profile;
import com.fly.bean.Signon;


public interface IAccountService {
	/**
	 * ���Account
	 * @param entity
	 */
	public void save(Account entity);
/**
 * ɾ��Account
 * @param entity
 */
	public void delete(Account  entity);
/**
 * ����Account
 * @param entity
 * @return 
 */
	public Account update(Account entity);
/**
 * ͨ��id����account
 * @param id
 * @return Account
 */
	public Account  findById(String id);
/**
 * �õ������˻���Ϣ��
 * @return list<Account> 
 */
	public List<Account> findAll();
	/**
	 * 
	 * @param signon
	 * @return Account ����  ����null��ʾ�û������ڣ��ǿձ�ʾ������½������Account
	 */
	public Account login(Signon signon);
	/**
	 * �洢�û���Signon��Ϣ��account��Ϣ��profile��Ϣ
	 * @param signon
	 * @param profile
	 * @param account
	 */
	public boolean setAccount (Signon signon,Profile profile, Account account);
	
	/**
	 * ����Account��Ϣ
	 * @param account
	 * @param profile
	 * @param signon
	 * @return
	 */
	
	public boolean updateAccount(Account account, Profile profile, Signon signon);
}
