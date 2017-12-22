package com.test.interceptor;

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
		
		System.out.println("!!!!!!!!!!!!"+board);
		
		if(board!=null){			
			String logPath=(String)modelAndView.getModel().get("logPath");
			
			HttpSession session=request.getSession();
			UserVO loginUser=(UserVO)session.getAttribute("loginUser");
						
			//아이디, 날짜, IP, board.content			
			String log=loginUser.getUid()+","
						+new DATE().toString()+","
						+request.getRemoteAddr()+","
						+board.getContent();
			
			LogFileUtils.writeLog(logPath, log);
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}





