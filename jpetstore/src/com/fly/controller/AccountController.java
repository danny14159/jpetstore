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
import com.fly.bean.Profile;
import com.fly.bean.Signon;
import com.fly.service.IAccountService;
import com.fly.service.IProfileService;
import com.fly.service.ISignonService;

@Controller(value = "accController")
@RequestMapping("/shop")
public class AccountController {
	private IAccountService accountService;

	public IAccountService getAccountService() {
		return accountService;
	}

	@Resource(name = "accountService")
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}
	
	@Resource
	private LoginController loginController;

	@RequestMapping(value = "/account.do")
	public String account(
			HttpServletRequest request,
			HttpServletResponse response, 
			Account account, 
			Signon signon,
			Profile profile,
			String op,
			String checkbox1,
			String checkbox2) {
		if ("ajaxSearchAccount".equals(op)) {
			// true表示存在，false表示不存在
			// Account a = accountUtil.load(Cnd.where("userid", "=",
			// request.getParameter("USERID")));

			response.setContentType("text/json; charset=UTF-8");
			//response.getWriter().print(account != null);
			// return ;
		}
		
		account.setStatus("OK");
		signon.setUsername(account.getUserid());
		profile.setMylistopt("on".equals(checkbox1)?1d:0d);
		profile.setBanneropt("on".equals(checkbox2)?1d:0d);
		
		boolean success = false;
		// 修改
		if ("modify".equals(op)) {
			success = this.accountService.updateAccount(account, profile,
					signon);
		}
		// 注册
		else {
			success = this.accountService.setAccount(signon, profile, account);
		}

		if (success) {
			//accountService.login(signon);
			loginController.loginAccount(signon, request);
			return "redirect:index.do";
		} else {
			return "redirect:newAccount";
		}
	}
}
