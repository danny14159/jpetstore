package com.fly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fly.bean.Account;
import com.fly.bean.Orders;
import com.fly.bean.Profile;
import com.fly.bean.Signon;
import com.fly.service.IAccountService;
import com.fly.service.IOrdersService;
import com.fly.service.IProfileService;
import com.fly.service.ISignonService;

@Controller
@RequestMapping("/shop")
public class DeleteOrderController {
	@Resource
	private IOrdersService orderService;
	@RequestMapping("/deleteorder.do")
	protected void deleteOrder(HttpServletRequest req, HttpServletResponse resp,
		String orderid	) throws IOException{
		Orders order = orderService.findById(Double.parseDouble(orderid));
		orderService.delete(order);
		resp.sendRedirect("listOrders.do");
		
	}
}
