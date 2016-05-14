package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Account;
import com.fly.bean.Profile;
import com.fly.bean.Signon;
import com.fly.dao.IAccountDAO;
import com.fly.dao.IProfileDAO;
import com.fly.dao.ISignonDAO;
import com.fly.service.IAccountService;

@Service
public class AccountService implements IAccountService {


	@Resource
	private IAccountDAO accountDAO;
	@Resource
	private ISignonDAO signonDAO;
	@Resource
	private IProfileDAO profileDAO;

	@Transactional
	public void delete(Account entity) {
		accountDAO.delete(entity);
	}

	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	public Account findById(String id) {
		return accountDAO.findById(id);
	}

	@Transactional
	public void save(Account entity) {
		accountDAO.save(entity);
	}

	@Transactional
	public Account update(Account entity) {
		return accountDAO.update(entity);
	}
	
	public Account login(Signon signon) {	
		Account account=new Account();
		Signon signonCheck = this.signonDAO.findById(signon.getUsername());
		account=accountDAO.findById(signon.getUsername());
		if(account==null||!signon.getPassword().equals( signonCheck.getPassword()))
		return null;
		else
		return account;
	}
	@Transactional
	public boolean setAccount(Signon signon, Profile profile, Account account) {
		try {
			this.accountDAO.save(account);
			this.signonDAO.save(signon);
			this.profileDAO.save(profile);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}

		
	}

	@Transactional
	public boolean updateAccount(Account account, Profile profile, Signon signon) {
		//String userid = account.getUserid();
		/*account.setUserid(null);
		profile.setUserid(null);
		signon.setUsername(null);*/
//		accountUtil.update(account, Cnd.where("userid", "=",userid )); 
//		profileUtil.update(profile, Cnd.where("userid", "=",userid ));
//		SignonUtil.update(signon, Cnd.where("username", "=",userid ));
		accountDAO.update(account);
		signonDAO.update(signon);
		profileDAO.update(profile);
		//account.setUserid(userid);
		return true;
	}
	
	

}
