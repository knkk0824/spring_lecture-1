package com.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DownloadController {	
	
	@RequestMapping("/file/{fileId}")
	public ModelAndView download(@PathVariable String fileId,
								 HttpServletRequest request,
							     HttpServletResponse response)
							     		throws Exception{
		
		File downloadFile = getFile(fileId,request);
		if(downloadFile==null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}		
		return new ModelAndView("download","downloadFile",downloadFile);
	}
	
	private File getFile(String fileId,HttpServletRequest request){
		String baseDir=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/files");
		if(fileId.equals("1")){
			return new File(baseDir,"Koala.jpg");
		}		
		return null;
	}
}





