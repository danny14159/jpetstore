package com.fly.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fly.service.IProductService;

@Controller
@RequestMapping("/shop")
public class ViewProductController {
	@Resource
	private IProductService productService;
	
	@RequestMapping("/viewCategory.do")
	public String viewProduct(
			String cate,Model model){
		model.addAttribute("list", productService.findByCategoryId(cate));
		return "ViewCategory";
	}
}
