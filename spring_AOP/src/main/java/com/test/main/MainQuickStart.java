package com.test.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.domain.NewArticleRequest;
import com.test.service.WriteArticleService;

public class MainQuickStart {
	
	public static void main(String[] args){
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:application-context.xml");
		
				
		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("206호", "오늘", "화이팅"));
	}
}








