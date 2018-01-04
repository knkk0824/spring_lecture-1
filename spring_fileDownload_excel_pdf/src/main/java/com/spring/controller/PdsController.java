package com.spring.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.PdsVO;

@Controller
@RequestMapping("/pds")
public class PdsController {
	
	@RequestMapping("/readPds")
	public String readPds(Model model){
		String url="pds/readPds";
		model.addAttribute("pds",
				new PdsVO("Koala.jpg",new Date(),"홍길동","코알라 사진.."));
		return url;
	}
	
	@RequestMapping("/download")
	public ModelAndView download(@RequestParam String fileName,
						   HttpServletRequest request,
						   HttpServletResponse response)throws Exception{
		File downloadFile = getFile(fileName,request);
		if(downloadFile==null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}		
		return new ModelAndView("download","downloadFile",downloadFile);
	}
	
	
	private File getFile(String fileName,HttpServletRequest request){
		String baseDir=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/files");
		
		return new File(baseDir,fileName);		
	}
	
	@RequestMapping("/pdsExcel")
	public ModelAndView pdsExcel(ModelAndView modelnview){
		List<PdsVO> pdsList=Arrays.asList(
					new PdsVO("a.jpg",new Date(),"김나래","어쩌구 저쩌구."),
					new PdsVO("b.jpg",new Date(),"박나래","어쩌구 저쩌구."),
					new PdsVO("c.jpg",new Date(),"최나래","어쩌구 저쩌구.")
		);
		
		modelnview.setViewName("pdsExcel");
		modelnview.addObject("pdsList",pdsList);
				
		return modelnview;
	}
}








