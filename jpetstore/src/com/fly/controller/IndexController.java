package com.fly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fly.bean.Account;
import com.fly.service.IBannerdataService;
import com.fly.service.IProductService;
import com.fly.service.IProfileService;

@Controller
@RequestMapping("/shop")
public class IndexController {

	public IProfileService getProfileService() {
		return profileService;
	}

	@Resource(name = "profileService")
	public void setProfileService(IProfileService profileService) {
		this.profileService = profileService;
	}

	public IBannerdataService getBannerdataService() {
		return bannerdataService;
	}

	@Resource(name = "bannerdataService")
	public void setBannerdataService(IBannerdataService bannerdataService) {
		this.bannerdataService = bannerdataService;
	}

	public IProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	private IProfileService profileService;
	private IBannerdataService bannerdataService;
	private IProductService productService;

	@RequestMapping("/index.do")
	public String getBannerdata(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		// ÅÐ¶ÏÒ»ÏÂÊÇ·ñµÇÂ¼
		if (account != null) {

			request.setAttribute("bannerdata", this.bannerdataService
					.findById(this.profileService.findById(account.getUserid())
							.getFavcategory()));

		}
		return "index";
	}


}
