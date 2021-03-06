package com.test.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.sql.DATE;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.domain.BoardVO;
import com.spring.domain.UserVO;
import com.spring.utils.LogFileUtils;

public class UserBoardLogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		BoardVO board=(BoardVO)modelAndView.getModel().get("board");
		
		
		if(board!=null){			
			String logPath=(String)modelAndView.getModel().get("logPath");
			
			HttpSession session=request.getSession();
			String loginUser=(String)session.getAttribute("loginUser");
			
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=format.format(new Date());
			
			//아이디, 날짜, IP, board.content			
			String log=loginUser+","
						+date+","
						+request.getRemoteAddr()+","
						+board.getContent();
			
			LogFileUtils.writeLog(logPath, log);
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}





