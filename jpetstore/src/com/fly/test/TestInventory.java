package com.fly.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fly.bean.Inventory;
import com.fly.service.IInventoryService;
import com.fly.service.IItemService;

public class TestInventory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IInventoryService biz=(IInventoryService)context.getBean("inventoryService",IInventoryService.class);
//		biz.save(new Inventory("e",2.1));
		IItemService biz=(IItemService)context.getBean("itemService",IItemService.class);
		biz.listByProductId("K9-RT-01");
		
	}

}
