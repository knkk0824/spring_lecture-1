package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String joinMember(MemberRequest memberReq,
							 Model model){
		
		model.addAttribute("member", memberReq);
	
		return "joinMember";
	}
	
	
}











