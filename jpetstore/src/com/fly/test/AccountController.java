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

// �ӿ�����,ʵ����org.springframework.web.servlet.mvc.Controller�������ӿ�
@Controller
@RequestMapping("/shop")
public class AccountController {
	
	@Resource
	private ICategoryService categoryService;
      
	/**
	 * ModelAndView ����߷�װ��Ҫ��ʾ��ҳ���Լ�ҳ��Ҫ��ʾ������
	 */
	@ResponseBody
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView  mav=new ModelAndView();
          System.out.println("���͵����󵽴����ӿ�����");
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
		 System.out.println("���͵����󵽴����ӿ�����a");
		return user_address+","+language;
	}
	@RequestMapping(value="/reg.do")
	public String b(Model model){
		System.out.println("���͵����󵽴����ӿ�����b");
		
		model.addAttribute("list", categoryService.findAll());
		return "main";
	}

}
