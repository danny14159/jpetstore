package com.fly.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fly.service.IInventoryService;
import com.fly.service.IItemService;
import com.fly.service.IProductService;
/**
 * 显示item细节
 * @author lw
 *
 */
@Controller
@RequestMapping("/shop")
public class ItemDetailController {
	private IProductService productService;
	private IItemService itemService;
	@Resource
	private IInventoryService inventoryService;
	
	public IProductService getProductService() {
		return productService;
	}

	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public IItemService getItemService() {
		return itemService;
	}

	@Resource
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}
/**
 * item详情显示功能，跳转至item.jsp
 * @param request
 * @param itemid
 * @param model
 * @return
 * @throws IOException
 */
	@RequestMapping(value = "/itemDetail.do")
	public String itemdetail(HttpServletRequest request, String itemid,
			Model model) throws IOException {
		System.out.println(itemid);
		model.addAttribute("item", itemService.findById(itemid));
		model.addAttribute("product", productService.findById(itemService
				.findById(itemid).getProduct().getProductid()));
		model.addAttribute("inventory",inventoryService.findByItemId(itemid));
		return "Item";

	}
}
