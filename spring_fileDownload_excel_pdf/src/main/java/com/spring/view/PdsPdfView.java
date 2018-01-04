package com.spring.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.dto.PdsVO;

public class PdsPdfView extends AbstractPdfView{
	
	private String fontPath="c:\\windows\\Fonts\\malgun.ttf";
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
									Document document,
									PdfWriter writer, 
									HttpServletRequest request, 
									HttpServletResponse response)
												throws Exception {
		
		List<PdsVO> pdsList=(List<PdsVO>)model.get("pdsList");
		
		Table table=new Table(4,pdsList.size()+1);
		
		table.setPadding(5);
		
		BaseFont bfKor=BaseFont.createFont(fontPath,BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		
		Font font=new Font(bfKor);
		
		Cell cell=new Cell(new Paragraph("작성자",font));
		
		cell.setHeader(true);
		
		table.addCell(cell);
		
		cell=new Cell(new Paragraph("내용",font));
		table.addCell(cell);
		cell=new Cell(new Paragraph("날짜",font));
		table.addCell(cell);
		cell=new Cell(new Paragraph("파일명",font));
		table.addCell(cell);
		table.endHeaders();
		
		for(PdsVO pds:pdsList){
			cell=new Cell(new Paragraph(pds.getWriter(),font));
			table.addCell(cell);
			
			cell=new Cell(new Paragraph(pds.getContent(),font));
			table.addCell(cell);
			
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			table.addCell(format.format(pds.getIndate()));
			
			cell=new Cell(new Paragraph(pds.getFileName(),font));
			table.addCell(cell);
		}
		
		document.add(table);
		
	}

}




