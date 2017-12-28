package com.spring.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFileUtils {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UploadFileUtils.class);
	
	
	public static String writeLog(String logPath, String log)
			throws Exception{
		
		String saveName="userBoardLog.txt";
		String savePath=calcPath(logPath);
		
		File target=new File(logPath+savePath,saveName);
		
		if(!target.exists()) {
			target.createNewFile();
		}
		
		String logFilePath=logPath+savePath+"/"+saveName;
		
		BufferedWriter out=
			new BufferedWriter(new FileWriter(logFilePath,true));
		
		out.write(log);
		out.newLine();
		out.close();
				
		return log;
	}
	
	
	
	
	// upload folder 지정.
		public static String calcPath(String uploadPath)throws Exception {
			
			Calendar cal=Calendar.getInstance();
			
			String yearPath=File.separator+cal.get(Calendar.YEAR);
			String monthPath=yearPath+File.separator+
					new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
			String datePath=monthPath+File.separator+
					new DecimalFormat("00").format(cal.get(Calendar.DATE));
			
			makeDir(uploadPath,yearPath,monthPath,datePath);
			
			logger.info(datePath);
			
			return datePath;
		}
		
		public static void makeDir(String uploadPath, String... paths){
			if(new File(paths[paths.length-1]).exists()){
				return;
			}
			for(String path:paths){
				File dirPath=new File(uploadPath+path);
				if(!dirPath.exists()){
					dirPath.mkdir();
				}
			}
		}
}
