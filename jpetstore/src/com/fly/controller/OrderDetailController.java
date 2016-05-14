package com.fly.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fly.bean.Lineitem;
import com.fly.bean.Orders;
import com.fly.dao.IOrdersDAO;
import com.fly.dao.impl.OrdersDAO;
import com.fly.service.ILineItemService;
import com.fly.service.IOrdersService;
import com.fly.service.impl.LineItemService;
import com.fly.service.impl.OrdersService;


@Controller
@RequestMapping("/shop")
public class OrderDetailController {

	
	

	@Resource
	private IOrdersService orderService;
	@Resource
	private ILineItemService lineItemService;
	
	@RequestMapping("/orderDetail.do")
	protected String Order(HttpServletRequest req,Model model)
	{
		String orderid = req.getParameter("orderid");
		
		Orders order = orderService.findById(Double.parseDouble(orderid));
		model.addAttribute("order",order);
		
		List<Lineitem> lineItem=lineItemService.findByProperty("orders", order);
		
		model.addAttribute("lineItem",lineItem);
		return "OrderDetail";
	}		
	
	
		
		
	

}
