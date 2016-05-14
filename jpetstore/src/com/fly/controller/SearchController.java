package com.fly.controller;


import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.bean.Pager;
import com.fly.bean.Product;
import com.fly.service.IProductService;

@Controller
@RequestMapping(value="/shop")
public class SearchController {
	@Resource
	private IProductService productService;
	@RequestMapping(value="/search.do")
	public String search(HttpServletRequest request,
			Integer ps,
			Integer pn,
			Model model,
			@ModelAttribute("key") @RequestParam("key")String keyword) throws Exception {
		if(keyword==null || "".equals(keyword)){
			model.addAttribute("keyEmpty", true);
			model.addAttribute("list", new ArrayList<Product>());
		}
		else{
			model.addAttribute("keyEmpty", false);
			Pager pager = productService.searchByPage(keyword,ps,pn);
			model.addAttribute("pager",pager);
		}
		return "SearchProducts";

	}

}
