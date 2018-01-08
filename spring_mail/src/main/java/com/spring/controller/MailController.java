package com.spring.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private MailSender sender;
	
	@RequestMapping("/mailForm")
	public void mailForm(){}
	
	@RequestMapping("/simple")
	public void simpleMail(MailRequest mailReq,HttpServletResponse response)
		throws Exception{
		
		SimpleMailMessage message=new SimpleMailMessage(); //text message
		
		message.setSubject(mailReq.getTitle());
		message.setFrom(mailReq.getFrom());
		message.setText(mailReq.getContent());
		message.setTo(mailReq.getTo());
		
		sender.send(message);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(""
				+ "<script>"
				+ "alert(\"메일을 성공적으로 보냈습니다.\");"
				+ "history.go(-1);"
				+ "</script>");
	}
	
	@RequestMapping("/html")
	public void sendMailHtml(MailRequest mailReq,HttpServletResponse response)
								throws Exception{
		
		JavaMailSender mailSender=(JavaMailSender)sender;		
		MimeMessage message=mailSender.createMimeMessage();		
		message.setSubject(mailReq.getTitle(),"utf-8");
		String htmlContent="<h2>"+mailReq.getContent()+"</h2>";
		message.setText(htmlContent,"utf-8","html");
		message.setFrom(new InternetAddress(mailReq.getFrom()));
		message.addRecipient(RecipientType.TO, 
					new InternetAddress(mailReq.getTo()));		
		mailSender.send(message);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();		
		out.print(""
				+ "<script>"
				+ "alert(\"메일을 성공적으로 보냈습니다.\");"
				+ "history.go(-1);"
				+ "</script>");
	}
	
	@RequestMapping("/inline")
	public void mailInline(MailRequest mailReq,
						   HttpServletRequest request,
						   HttpServletResponse response)
								  		throws Exception{		
		
		JavaMailSender mailSender=(JavaMailSender)sender;
		
		MimeMessage message=mailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper=
				new MimeMessageHelper(message,true,"utf-8");
		
		messageHelper.setSubject(mailReq.getTitle());
		
		String htmlContent="<h2>"+mailReq.getContent()+"</h2>"
						+"<img src='cid:signature' />";
		
		messageHelper.setText(htmlContent,true);
		messageHelper.setFrom(mailReq.getFrom(),"운영자");
		messageHelper.setTo(new InternetAddress(mailReq.getTo()));
		
		ServletContext ctx=request.getSession().getServletContext();
		
		String filePath = ctx.getRealPath("/WEB-INF/img");
		String fileName="123.jpg";
		
		File file=new File(filePath,fileName);
		
		messageHelper.addInline("signature", new FileDataSource(file));
		
		
		mailSender.send(message);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();		
		out.print(""
				+ "<script>"
				+ "alert(\"메일을 성공적으로 보냈습니다.\");"
				+ "history.go(-1);"
				+ "</script>");
	}
	
	
	@RequestMapping("/attach")
	public void mailAttach(HttpServletRequest request,
						   HttpServletResponse response,
						   MailRequest mailReq) throws Exception{
		JavaMailSender mailSender=(JavaMailSender)sender;
		
		MimeMessage message=mailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper=
				new MimeMessageHelper(message,true,"utf-8");
		
		messageHelper.setSubject(mailReq.getTitle());
		
		String htmlContent="<h2>"+mailReq.getContent()+"</h2>"
						+"<img src='cid:signature' />";
		
		messageHelper.setText(htmlContent,true);
		messageHelper.setFrom(mailReq.getFrom(),"운영자");
		messageHelper.setTo(new InternetAddress(mailReq.getTo()));
		
		ServletContext ctx=request.getSession().getServletContext();
		
		String filePath = ctx.getRealPath("/WEB-INF/img");
		String fileName="123.jpg";
		
		File file=new File(filePath,fileName);	
		
		messageHelper.addInline("signature", new FileDataSource(file));
		
		messageHelper.addAttachment(file.getName(), file);
		
		mailSender.send(message);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();		
		out.print(""
				+ "<script>"
				+ "alert(\"메일을 성공적으로 보냈습니다.\");"
				+ "history.go(-1);"
				+ "</script>");
		
	}
	
	
}






