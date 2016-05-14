package com.fly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.bean.Account;
import com.fly.bean.Profile;
import com.fly.bean.Signon;
import com.fly.service.IAccountService;
import com.fly.service.IProfileService;
import com.fly.service.ISignonService;
import com.fly.controller.LoginController;

/**
 * 判断用户登陆状况。若登陆，则完成用户信息的读取。跳转。
 * @author lw
 *
 */
@Controller
@RequestMapping("/shop")
public class NewAccountController {
	@Resource
	private IProfileService profileService ;
	@Resource
	private ISignonService signonService;
	@Resource
	private LoginController loginController;
	@Resource
	private IAccountService accountService;
	/**
	 * 判断登陆情况，并传递用户信息
	 */
	@RequestMapping(value="/newAccount.do")
	public String newAccount(HttpServletRequest request,String op)
	{
		
		if("modify".equals(op)){
			Account account = loginController.getLoginAccount(request);
			Profile profile = profileService.findById(account.getUserid());
			Signon signon = signonService.findById(account.getUserid());
			request.setAttribute("account", account);
			request.setAttribute("profile", profile);
			request.setAttribute("signon", signon);
			}
		return "NewAccountForm";
	
	
}
	@RequestMapping("/ajaxAccountExist.do")
	@ResponseBody
	public Object ajaxAccountExist(String userid){
		
		Account account = accountService.findById(userid);
		return account!=null;
	}
}