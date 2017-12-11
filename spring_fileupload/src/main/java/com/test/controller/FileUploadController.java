package com.test.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	private String uploadPath=null;
	
	@RequestMapping(value="/upload/form", method=RequestMethod.GET)
	public String form(){
		return "upload/fileUploadForm";
	}
	
	@RequestMapping(value="/upload/multipartFile",method=RequestMethod.POST)
	public String uploadMultipartFile(
			@RequestParam("f") MultipartFile multipartFile,
			@RequestParam("title") String title,
			Model model,HttpServletRequest request) throws Exception{
		
		uploadPath=request.getSession().getServletContext()
				.getRealPath("resources/upload");
		
		if(!multipartFile.isEmpty()){
			File file=new File(uploadPath,UUID.randomUUID().toString().replace("-", "")
					+"$$"+multipartFile.getOriginalFilename()
					);
			
			multipartFile.transferTo(file);
			
			model.addAttribute("title", title);
			model.addAttribute("fileName",file.getName());
			model.addAttribute("uploadPath",file.getAbsolutePath());
			
			return "upload/fileUploaded"; 
			
		}
		
		return "upload/noUploadFile";
	}	

}








