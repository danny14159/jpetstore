package com.fly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.service.IItemService;
import com.fly.service.IProductService;

@Controller
@RequestMapping("/shop")
public class ViewItemController {
	@Resource
	private IItemService itemService;
	@Resource
	private IProductService productService;
	@RequestMapping(value="/viewItem.do")
	public String viewItem(HttpServletRequest request,@RequestParam(value="productId") String productId ){
		request.setAttribute("list", this.itemService.listByProductId(productId));
		request.setAttribute("product", this.productService.findById(productId));
		return "Product";
	}

}
