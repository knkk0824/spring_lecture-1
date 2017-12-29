package com.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.UrlUtils;

public class CustomAuthenticationEntryPoint 
				implements AuthenticationEntryPoint{

	private String loginFormPath;
	
	public void setLoginFormPath(String loginFormPath){
		this.loginFormPath=loginFormPath;
	}
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authExceptoin) throws IOException, ServletException {
		
		String redirectUrl=UrlUtils.buildFullRequestUrl(request);
		String encoded=response.encodeRedirectUrl(redirectUrl);
		response.sendRedirect(request.getContextPath()+loginFormPath+
				"?returl="+encoded);
	}
	

}
