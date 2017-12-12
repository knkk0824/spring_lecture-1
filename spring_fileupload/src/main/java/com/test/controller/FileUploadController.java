package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.dto.FileCommand;
import com.test.dto.FileVO;
import com.test.service.FileService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileService service;
	
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
		
		/*파일용량제한*/
		if(multipartFile.getSize()>(1024*1024*5)){
			return "upload/uploadFileLimitedError";
		}
		
		
		uploadPath=request.getSession().getServletContext()
				.getRealPath("resources/upload");
		
		if(!multipartFile.isEmpty()){
			File file=new File(uploadPath,UUID.randomUUID().toString().replace("-", "")
					+"$$"+multipartFile.getOriginalFilename());
			
			multipartFile.transferTo(file);
			
			model.addAttribute("title", title);
			model.addAttribute("fileName",file.getName());
			model.addAttribute("uploadPath",file.getAbsolutePath());
			
			return "upload/fileUploaded"; 
			
		}
		
		return "upload/noUploadFile";
	}	
	
	@RequestMapping(value="/upload/multipartHttpServletRequest",
			method=RequestMethod.POST)
	public String uploadByMultipartHttpServletRequest(
				MultipartHttpServletRequest request,
				Model model
			)throws IOException{
		
		MultipartFile multipartFile=request.getFile("f");
		
		
		/*파일용량제한*/
		if(multipartFile.getSize()>(1024*1024*5)){
			return "upload/uploadFileLimitedError";
		}
		
		
		uploadPath=request.getSession().getServletContext()
				.getRealPath("resources/upload");
		
		
		if(!multipartFile.isEmpty()){
			File file=new File(uploadPath,UUID.randomUUID().toString().replace("-", "")
					+"$$"+multipartFile.getOriginalFilename());
			
			multipartFile.transferTo(file);
			
			model.addAttribute("title", request.getParameter("title"));
			model.addAttribute("fileName",file.getName());
			model.addAttribute("uploadPath",file.getAbsolutePath());
			
			return "upload/fileUploaded"; 
			
		}
		
		return "upload/noUploadFile";
	}
	
	
	@RequestMapping(value="/upload/commandObj",method=RequestMethod.POST)
	public String uploadByCommandObj(FileCommand command,Model model,
									HttpServletRequest request)
											throws IOException{
		
		MultipartFile multipartFile = command.getF();
		
		/*파일용량제한*/
		if(multipartFile.getSize()>(1024*1024*5)){
			return "upload/uploadFileLimitedError";
		}
		
		uploadPath=request.getSession().getServletContext()
				.getRealPath("resources/upload");
		
		if(!multipartFile.isEmpty()){
			File file=new File(uploadPath,UUID.randomUUID().toString().replace("-", "")
					+"$$"+multipartFile.getOriginalFilename());
			
			multipartFile.transferTo(file);
			
			model.addAttribute("title", command.getTitle());
			model.addAttribute("fileName",file.getName());
			model.addAttribute("uploadPath",file.getAbsolutePath());
			
			
			FileVO vo = command.toFileVO();
			vo.setFilename(file.getName());
			vo.setUploadpath(file.getAbsolutePath());
			vo.setFilesize((int)multipartFile.getSize());
			
			try {
				service.addFile(vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return "upload/fileUploaded"; 
			
		}
		
		return "upload/noUploadFile";
	}
	
}








