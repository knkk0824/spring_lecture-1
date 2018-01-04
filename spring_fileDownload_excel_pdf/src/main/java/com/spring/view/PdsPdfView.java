package com.spring.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public class PdsPdfView extends AbstractPdfView{
	
	private String fontPath="c:\\windows\\Fonts\\malgun.ttf";
	
	@Override
	protected void buildPdfDocument(Map<String, Object> map, 
									Document document,
									PdfWriter writer, 
									HttpServletRequest request, 
									HttpServletResponse response)
												throws Exception {
		
	}

}
