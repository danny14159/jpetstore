package com.fly.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fly.bean.Account;
import com.fly.bean.Category;
import com.fly.bean.Product;
import com.fly.dao.IAccountDAO;
import com.fly.dao.impl.AccountDAO;
import com.fly.service.IAccountService;
import com.fly.service.IProductService;


public class WenTest {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountService biz = (IAccountService) context.getBean("accountService", IAccountService.class);
		biz.update(new Account("112", "11", "11","11","11","11","11","11","11","11"));
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IAccountDao biz = (IAccountDao) context.getBean("accountDao");
		List<Account> list=biz.findAll();
		for(Account a:list){
			System.out.println(a);
		}
		//IProductService biz1 = (IProductService) context.getBean("productService", IProductService.class);
		//biz1.update(new Product("11", new Category("11", "11", "11")));
	}
	
	
	
}
