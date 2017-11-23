package com.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		List<MemberVO> memberList=memberService.getMemberList();
		model.addAttribute("memberList",memberList);
	}
	
	@RequestMapping(value="/createMember",method=RequestMethod.GET)
	public String createMember()throws Exception{
		return "/member/createMemberForm";
	}
	
	@RequestMapping(value="/createMember",method=RequestMethod.POST)
	public String createMember(MemberVO member)throws Exception{		
		memberService.insertMember(member);		
		return "redirect:/member/listAll";
	}
	
	@RequestMapping(value="/readMember",method=RequestMethod.GET)
	public void readMember(String userid,Model model)throws Exception{
		MemberVO member=memberService.getMemberById(userid);
		model.addAttribute(member);		
	} 
	
	@RequestMapping(value="/modifyMember",method=RequestMethod.GET)
	public void modifyMember(String userid,Model model)throws Exception{
		MemberVO member=memberService.getMemberById(userid);
		model.addAttribute(member);
	}
	
	@RequestMapping(value="/modifyMember",method=RequestMethod.POST)
	public String modifyMember(MemberVO member)throws Exception{
		System.out.println(member);
		member.setUpdatedate(new Date());
		memberService.updateMember(member);
		return "redirect:/member/listAll";
	}
	
	@RequestMapping(value="/removeMember",method=RequestMethod.POST)
	public String removeMember(String userid)throws Exception{
		memberService.deleteMember(userid);
		return "redirect:/member/listAll";
	}
}








