package com.spring.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.spring.dto.PdsVO;

public class PdsExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disponsition", 
				"attachment;filename=\"pdsList.xls\";");
		
		HSSFSheet sheet=createFirstSheet(workbook); // sheet 생성
		
		createColumnLabel(sheet); //Label 생성.
		
		List<PdsVO> pdsList=(List<PdsVO>)model.get("pdsList");
		
		int rowNum=1;
		for(PdsVO pds:pdsList){
			createPdsRow(sheet,pds,rowNum++); // row 생성.
		}
		
	}
	
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook){
		HSSFSheet sheet=workbook.createSheet();
		workbook.setSheetName(0, "자료실 리스트");
		sheet.setColumnWidth(1, 256*50);
		sheet.setColumnWidth(2, 256*12);
		sheet.setColumnWidth(3, 256*20);
		return sheet;
	}
	
	private void createColumnLabel(HSSFSheet sheet){
		HSSFRow firstRow=sheet.createRow(0);
		HSSFCell cell=firstRow.createCell(0);
		cell.setCellValue("작성자");
		
		cell=firstRow.createCell(1);
		cell.setCellValue("내용");
		
		cell=firstRow.createCell(2);
		cell.setCellValue("날짜");
		
		cell=firstRow.createCell(3);
		cell.setCellValue("파일명");
		
	}
	
	private void createPdsRow(HSSFSheet sheet, PdsVO pds,int rowNum){
		HSSFRow row=sheet.createRow(rowNum);
		HSSFCell cell=row.createCell(0);
		cell.setCellValue(pds.getWriter());
		
		cell=row.createCell(1);
		cell.setCellValue(pds.getContent());
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String date=format.format(pds.getIndate());
		
		cell=row.createCell(2);
		cell.setCellValue(date);
		
		cell=row.createCell(3);
		cell.setCellValue(pds.getFileName());
	}
	
}









