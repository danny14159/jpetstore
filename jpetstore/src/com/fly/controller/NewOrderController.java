package com.fly.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fly.bean.Account;
import com.fly.bean.Lineitem;
import com.fly.bean.Orders;
import com.fly.service.ILineItemService;
import com.fly.service.IOrdersService;
import com.fly.service.impl.LineItemService;
import com.fly.service.impl.OrdersService;

@Controller
@RequestMapping("/shop")
public class NewOrderController {
	@Resource
	private IOrdersService orderService;
	@Resource
	private ILineItemService lineItemService;

	@RequestMapping("/newOrder.do")
	protected String NewOrder(HttpServletRequest req, HttpServletResponse resp,
			Orders orders, String op) throws IOException {

		Account account = new LoginController().getLoginAccount(req);
		if (null == account) {
			resp.sendRedirect("login.do?redirect=newOrder.do");

		} else {
			if ("submitOrder".equals(op) && "POST".equals(req.getMethod())) {
				System.out.println("进入提交方法");
				HttpSession ses = req.getSession();
				CartItemList cart = (CartItemList) ses
						.getAttribute(ShoppingCartController.SES_SHOPPING_CART);
				if (null != cart) {

					Orders order = orderService.findMaxOrderBySql();
					double maxOrderid = order.getOrderid() + 1;
					
					// 插购物商品
					List<Lineitem> litems = cart.asLineList(maxOrderid);

					if (litems.size() == 0) {
						resp.sendRedirect("shoppingCart.do");

					}

					Timestamp time = new Timestamp(new Date().getTime());

					orders.setOrderid(maxOrderid);
					orders.setOrderdate(time);
					orders.setAccount(account);
					orders.setCourier( "UPS");
					orders.setLocale("CA");
					orders.setShipaddr1((String)req.getParameter("billaddr1"));
					orders.setShipaddr2((String)req.getParameter("billaddr2"));
					orders.setShipcity((String)req.getParameter("billcity"));
					orders.setShipzip((String)req.getParameter("billzip"));
					orders.setShipcountry((String)req.getParameter("billcountry"));
					orders.setShipstate((String)req.getParameter("billstate"));
					orders.setShiptofirstname((String)req.getParameter("billtofirstname"));
					orders.setShiptolastname((String)req.getParameter("billtolastname"));
					orders.setTotalprice(cart.getSubTotal());
					orderService.save(orders);
					

					for (Lineitem litem : litems) {

						lineItemService.save(litem);
					}

					ses.setAttribute(ShoppingCartController.SES_SHOPPING_CART,
							null);// q清空购物车
					resp.sendRedirect("orderDetail.do?orderid="
							+ orders.getOrderid());

				} else {
					resp.sendRedirect("shoppingCart.do");
				}
			} else {
				return "OrderForm";
			}
		}
		return null;

	}

}
