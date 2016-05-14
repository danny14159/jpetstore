package com.fly.test;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fly.bean.Account;
import com.fly.service.ICategoryService;

// 子控制器,实现了org.springframework.web.servlet.mvc.Controller控制器接口
@Controller
@RequestMapping("/shop")
public class AccountController {
	
	@Resource
	private ICategoryService categoryService;
      
	/**
	 * ModelAndView 它里边封装了要显示的页面以及页面要显示的数据
	 */
	@ResponseBody
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView  mav=new ModelAndView();
          System.out.println("发送的请求到达了子控制器");
//          request.setAttribute("msg", "msgmsg");
//          request.getRequestDispatcher("main.jsp").forward(request, response);
//          
          //mav.addObject("msg", "msgmsg!!!!!!!");
          //mav.setViewName("main.jsp");
          return mav;
	}
	
	@RequestMapping("/test.do")
	@ResponseBody
	public Object a(Model model,
			@CookieValue String user_address,
			@RequestHeader("Accept-Language") String language){
		 System.out.println("发送的请求到达了子控制器a");
		return user_address+","+language;
	}
	@RequestMapping(value="/reg.do")
	public String b(Model model){
		System.out.println("发送的请求到达了子控制器b");
		
		model.addAttribute("list", categoryService.findAll());
		return "main";
	}

}
