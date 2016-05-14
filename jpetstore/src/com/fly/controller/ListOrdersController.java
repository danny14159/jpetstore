package com.fly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fly.bean.Account;
import com.fly.service.IOrdersService;
@Controller
@RequestMapping("/shop")
public class ListOrdersController {

	private IOrdersService ordersService;
	
	public IOrdersService getIordersService() {
		return ordersService;
	}
	@Resource
	public void setIordersService(IOrdersService iordersService) {
		this.ordersService = iordersService;
	}
	@Resource
	private LoginController loginController;
	
	/**
	 * 
	 * @param request
	 * @return List <Oeders> listOrder 用于传递订单
	 */
	@RequestMapping(value="/listOrders.do")
	public String listOrders(HttpServletRequest request)
	{	
		
		Account account = loginController.getLoginAccount(request);
		request.setAttribute("listOrders",this.ordersService.findByUserId(account.getUserid()));	
		return "listOrder";
	}


	
}
