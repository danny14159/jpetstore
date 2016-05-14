package com.fly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.bean.Account;
import com.fly.bean.Item;
import com.fly.bean.Product;
import com.fly.bean.Profile;
import com.fly.service.IInventoryService;
import com.fly.service.IItemService;
import com.fly.service.IProductService;
import com.fly.service.IProfileService;
import com.fly.service.impl.InventoryService;
import com.fly.service.impl.ItemService;
import com.fly.service.impl.ProductService;
import com.fly.service.impl.ProfileService;

@Controller
@RequestMapping("/shop")
public class ShoppingCartController{
	@Resource
	IProductService productService;
	@Resource
	IItemService itemService ;
	@Resource
	IInventoryService inventoryService ;
	@Resource
	IProfileService profileService;
	public static final String SES_SHOPPING_CART="cart";

	@RequestMapping("/shoppingCart.do")
	protected String ShopingCart(HttpServletRequest request,String op,String itemid,Integer itemQty)
	{
		HttpSession ses = request.getSession();
		CartItemList cart = (CartItemList) ses.getAttribute(SES_SHOPPING_CART);
		if(null == cart) {
			cart = new CartItemList();
			ses.setAttribute("cart", cart);
		}
		if("addItem".equals(op)){
			CartItem item = new CartItem();			
			Item i=  itemService.findById(itemid);
			item.setItem(i);
			item.setProduct(productService.findById(i.getItemid()));
			item.setInventory(inventoryService.findByItemId(itemid));
			item.setQuantity(itemQty);
			cart.insertItem(item);
		}
		else if("removeItem".equals(op)){

			cart.removeByItemId(itemid);
		}
		Account account=new LoginController().getLoginAccount(request);
		if(account==null){
			
		}
		else{
			Profile pro=profileService.findById(account.getUserid());
			List<Product> pd=productService.findByCategoryId(pro.getFavcategory());
			ses.setAttribute("pd", pd);
			
		}
		request.setAttribute("cart",cart);
		return "ShoppingCart";
	}
	
	@RequestMapping("/ajax/shoppingCart.do")
	@ResponseBody
	public Object ajaxAddToCart(
			HttpServletRequest request,
			String op,
			String itemid,
			Integer itemQty){
		
		HttpSession ses = request.getSession();
		CartItemList cart = (CartItemList) ses.getAttribute(SES_SHOPPING_CART);
		if(null == cart) {
			cart = new CartItemList();
			ses.setAttribute("cart", cart);
		}
		if("addItem".equals(op)){
			CartItem item = new CartItem();			
			Item i=  itemService.findById(itemid);
			item.setItem(i);
			item.setProduct(productService.findById(i.getItemid()));
			item.setInventory(inventoryService.findByItemId(itemid));
			item.setQuantity(itemQty);
			cart.insertItem(item);
		}
		else if("removeItem".equals(op)){

			cart.removeByItemId(itemid);
		}
		Account account=new LoginController().getLoginAccount(request);
		if(account==null){
			
		}
		else{
			Profile pro=profileService.findById(account.getUserid());
			List<Product> pd=productService.findByCategoryId(pro.getFavcategory());
			ses.setAttribute("pd", pd);
			
		}
		request.setAttribute("cart",cart);
		return true;
	}
}
