package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping(value="/joinMember",method=RequestMethod.GET)
	public String joinMemberForm(){
		return "joinMemberForm";
	}
	
	@RequestMapping(value="/joinMember",method=RequestMethod.POST)
	public String joinMember(String id, 
							 String pwd, 
							 String name, 
							 String email,
							 HttpServletRequest request){
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		
		return "joinMember";
	}
	
	
}











