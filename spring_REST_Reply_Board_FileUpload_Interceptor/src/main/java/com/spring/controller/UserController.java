package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.UserVO;
import com.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void login()throws Exception{} 
	
	@ResponseBody
	@RequestMapping(value="/loginPost",method=RequestMethod.POST,
					produces="text/html;charset=utf-8")
	public String loginPost(LoginRequest loginReq,
						  	HttpSession session,
						  	HttpServletRequest request)
		throws Exception{
		
		String msg="";
		
		UserVO user=userService.login(loginReq.getUid());		
		
		
		if(user!=null){
			if(loginReq.getUpwd().equals(user.getUpwd())){
				//로그인 성공
				session.setAttribute("loginUser", user);
				
				msg="alert('로그인 성공했습니다.');"
					+"location.href='"+request.getContextPath()+"/sboard/list'";
			}else{// 패스워드 불일치
				msg="alert('패스워드가 일치하지 않습니다.');"
					+"history.go(-1);";
			}
		}else{//아이디 부재...
			msg="alert('아이디가 존재하지 않습니다.');"
				 +"history.go(-1);";
		}
		return "<script>"+msg+"</script>";
	}
}




