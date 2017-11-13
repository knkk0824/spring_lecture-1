package com.test.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.original.Print;

public class Main {

	public static void main(String[] args) {
		
		/*Print print=new Print();*/
		
		ApplicationContext ctx=
		new GenericXmlApplicationContext("classpath:application-context.xml");
		
		PrintBean print=ctx.getBean("printBean",PrintBean.class);
		
		System.out.println(print.sum(3, 5));
		System.out.println(print.sub(3, 5));
		System.out.println(print.multi(3, 5));
		System.out.println(print.dev(3, 5));

	}

}
