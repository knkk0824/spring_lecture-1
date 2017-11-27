package com.spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionController {
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex){
		ModelAndView modelnView=new ModelAndView();
		
		modelnView.setViewName("error_common");
		modelnView.addObject("exception",ex);
		return modelnView;
	}
}








