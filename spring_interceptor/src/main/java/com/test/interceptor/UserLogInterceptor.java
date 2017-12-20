package com.test.interceptor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserLogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		boolean result=true;
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("loginUser");
		
		if(id!=null){
			String savePath="/WEB-INF/log";
			ServletContext context=session.getServletContext();
			String logFilePath=context.getRealPath(savePath)+"/log.txt";
			
			// 이어쓰기 : new FileWriter(logFilePath,true)
			// 새로쓰기 : new FileWriter(logFilePath,false) : 기본값
			
			BufferedWriter out=
					new BufferedWriter(new FileWriter(logFilePath,true));
			
			Date date=new Date();
			String reqURL=request.getRequestURI().replace(
					request.getContextPath(), "/");
			String ip=request.getRemoteAddr();
			
			String log=id+","+date.toString()+","+reqURL+","+ip;
			
			out.write(log);
			out.newLine();
			out.close();
					
		}else{
			
		}
		
		return result;
	}
	

}





