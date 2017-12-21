package com.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		boolean result=false;
		
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser")!=null){
			result=true;
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(
					"<script>alert('로그인이 필요합니다.');"
					+ "history.go(-1);</script>"					
					);
		}		
		
		return result;
	}

}







