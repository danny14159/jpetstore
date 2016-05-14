package com.fly.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fly.bean.Category;
import com.fly.service.ICategoryService;

public class TEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICategoryService biz = (ICategoryService) context.getBean("categoryService", ICategoryService.class);
	
		Category dog = biz.findById("DOGS");
		//System.out.println(dog.getProducts());
		//dao.delete(new Category("1"));
		//biz.save(new Category("1"));
		//biz.update(new Category("1","3","6"));
	}

}
