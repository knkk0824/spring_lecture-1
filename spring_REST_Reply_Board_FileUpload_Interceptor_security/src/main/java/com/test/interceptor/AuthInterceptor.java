package com.test.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		boolean result=false;
		
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
				
		if(session.getAttribute("loginUser")!=null){
			result=true;
		}else{
			out.println("<script>alert('로그인이 필요합니다');</script>");
			out.println("<script>location.href='"+request.getContextPath()
					+"/user/login';</script>");
		}
		
		return result;
	}
	
	

}
