package com.fly.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.bean.Account;
import com.fly.bean.Signon;
import com.fly.service.IAccountService;

@Controller
@RequestMapping("/shop")
public class LoginController {
	public static final String SES_ACCOUNT="account";
	/**
	 * 验证码的session key
	 */
	public static final String SES_CHECKCODE="ses.checkcode";
	@Resource
	private IAccountService accountService;
	
	/**获取已经登录的用户函数
	 * @param req
	 * @return
	 */
	public Account getLoginAccount(HttpServletRequest req){
		
		return (Account)req.getSession().getAttribute(SES_ACCOUNT);
	}
	
	/**用户登录函数
	 * @param username
	 * @param password
	 * @param req
	 * @return
	 */
	public Account loginAccount(Signon signon,HttpServletRequest req){
		Account account = accountService.login(signon);
		req.getSession().setAttribute(SES_ACCOUNT, account);
		return account;
	}
	

	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(String op,HttpServletRequest request){
		if("logout".equals(op)){
			request.getSession().removeAttribute(SES_ACCOUNT);
			return "redirect:index.do";
		}
		return "SignonForm";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(
			Signon signon,
			Model model,
			HttpServletRequest request,
			HttpSession ses,
			String checkcode,
			String redirect){
		
		if("".equals(checkcode)){
			model.addAttribute("msg", "还没输入验证码！");
			return "SignonForm";
		}
		if(!ses.getAttribute(SES_CHECKCODE).toString().toLowerCase().equals(checkcode.toLowerCase())){
			model.addAttribute("msg", "抱歉，验证码不正确！");
			return "SignonForm";
		}
		Account account = loginAccount(signon, request);
		if(null == account){
			model.addAttribute("msg", "用户名或密码错误！");
			return "SignonForm";
		}
		if(redirect!=null && !"".equals(redirect)){
			return "redirect:"+redirect;
		}
		return "redirect:index.do";
	}
	public Color getRandomColor(int startrgb,int endrgb){
		Random random=new Random();
		return new Color(startrgb+random.nextInt(endrgb-startrgb),
				startrgb+random.nextInt(endrgb-startrgb),
				startrgb+random.nextInt(endrgb-startrgb));
	}
	
	@RequestMapping("/checkcode.do")
	public void checkCode(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache_Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		final int 
		height=38,
		font_size=30,//字号
		char_space = 5,//字符间距
		n_char = 4; //字符数
		int width=n_char*(font_size+char_space) + char_space; //总宽
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
	//	Graphics2D g2d=(Graphics2D)g;
		Random random=new Random();
		Font mFont=new Font("Consolas",Font.BOLD,font_size);
		g.setColor(getRandomColor(180,255));
		g.fillRect(0, 0, width, height);
		g.setFont(mFont);
		//画一些随机的线
		for(int i=0;i<2;i++){
			g.setColor(getRandomColor(100,255));
			g.drawLine(0, random.nextInt(height), width, random.nextInt(height));
		}
		for(int i=0;i<2;i++){
			g.setColor(getRandomColor(100,255));
			g.drawLine(random.nextInt(width), 0, height, random.nextInt(width));
		}
		//画一些随机的点
		for(int i=0;i<20;i++){
			g.setColor(getRandomColor(100,250));
			g.fillOval(random.nextInt(width), 
					random.nextInt(height), random.nextInt(6), random.nextInt(6));		
		}
		//生成随机验证文字sRand
		String sRand="";	
		String singlechar="";
		for(int i=0;i<n_char;i++){
			g.setColor(getRandomColor(50,200));
			int flag=random.nextInt(3)+1;
			switch(flag){
			case 1:singlechar=""+(char)((char)random.nextInt(26)+'A');break;
			case 2:singlechar=""+(char)((char)random.nextInt(26)+'a');break;
			case 3:singlechar=""+(char)((char)random.nextInt(10)+'0');break;
			}
			sRand+=singlechar;
			g.drawString(singlechar, char_space+i*font_size,( height-font_size)/2+(int)(font_size*0.8));
		}
		//g.drawString(sRand, 18, 14);
		
		//将验证码保存到session中
		HttpSession session=request.getSession(true);
		session.setAttribute(SES_CHECKCODE, sRand);
		
		//输出生成的验证码图片
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
