package com.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/main")
	public void main(){}
	
	@RequestMapping("/page1")
	public void page1(){}
	
	@RequestMapping("/page2")
	public void page2(){}
	
	@RequestMapping("/loginForm")
	public void loginForm(){}
	
	@RequestMapping("login")
	public String login(String id, String pwd, HttpSession session){
		
		String url="redirect:main";		
		session.setAttribute("loginUser", id);		
		return url;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String url="redirect:main";
		
		session.invalidate();
		
		return url;
		
	}
	
}







