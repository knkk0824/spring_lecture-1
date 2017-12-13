package com.spring.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utils.UploadFileUtils;

@Controller
public class UploadController {

	private static final Logger logger=
			LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/uploadForm",method=RequestMethod.GET)
	public void uploadForm(){}
	
	@RequestMapping(value="/uploadForm",method=RequestMethod.POST)
	public String upload(MultipartFile file,Model model) throws Exception{
		
		logger.info("originalName : "+file.getOriginalFilename());
		logger.info("size : "+file.getSize());
		logger.info("contentType : "+file.getContentType());
		
		String saveName=uploadFile(file.getOriginalFilename(),file.getBytes());
		
		model.addAttribute("savedName",saveName);
		
		return "uploadResult";
	}
	
	
	private String uploadFile(String originalName, byte[] fileData)
			throws Exception{
		
		UUID uid=UUID.randomUUID();
		String saveName=uid.toString().replace("-","")+"_"+originalName;
		
		File target=new File(uploadPath,saveName);
		
		FileCopyUtils.copy(fileData, target);
		
		return saveName;
	}
	
	@RequestMapping(value="/uploadAjax",method=RequestMethod.GET)
	public void uploadAjax(){}
	
	@RequestMapping(value="/uploadAjax",method=RequestMethod.POST)
	public ResponseEntity<String> uploadAjax(MultipartFile file)
							throws Exception{
		
		logger.info("originalName : "+file.getOriginalFilename());
		
		return new ResponseEntity<String>(
					UploadFileUtils.uploadFile(uploadPath,
						file.getOriginalFilename(),
						file.getBytes()),
					HttpStatus.CREATED
				);
	}
}







