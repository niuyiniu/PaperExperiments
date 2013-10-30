package cn.edu.sjtu.se.reins.excel.utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.JXLException;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import cn.edu.sjtu.se.reins.luh.FrequencyAnalyser;

public class BatchHandler {
	
	private String sourceDir;
	private String targetFile;
	private String sumFile;
	
	private static String[] periodsInAll = new String[144*88];
	private static String[] periodsInDay = new String[144];
	
	private static SimpleDateFormat dateFormatter= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private static SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	
	public BatchHandler(){
		
	}
	
	public void start(){
		//Start from 4 since the first four log files are empty
//		setSourceDir("K:\\workload");
//		setTargetFile("K:\\workload\\test.xls");
		WritableWorkbook wwb;
		WritableWorkbook swb;
		try {
			wwb = Workbook.createWorkbook(new File(getTargetFile()));
			swb = Workbook.createWorkbook(new File(getSumFile()));
			ExcelHandler eh = new ExcelHandler();
			eh.writeAllPeriods(periodsInAll, "TotalWorkloadByTenMinutes", swb);
			//Start from 4 since the first four log files are empty
			for(int i = 4; i < 92; i++){
				String day = "day" + Integer.toString(i+1);
//				System.out.println(day);
//		    	String sheetname = "day81";
				if(day.equals("day33")){
					System.out.println("here");
				}
		    	FrequencyAnalyser fa = new FrequencyAnalyser();
		    	fa.setINPUT_PATH(sourceDir + day + ".out");
		    	System.out.println(fa.getINPUT_PATH());
		    	int[] requestByMin = fa.getFrequency();
		    		
		    	eh.writeArray(requestByMin, periodsInDay, day, wwb);
		    	eh.appendRequest(requestByMin, swb);
			}
			wwb.write();
			wwb.close();
			swb.write();
			swb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JXLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InitPeriodsInAll(int interval){
		String startTime = "4/30/1998 22:00:00";
//		String endTime = "1998/7/26 21:50";
		try {
			Date stime = dateFormatter.parse(startTime);
			System.out.println(stime.getTime());
			for(int i = 0; i < 12672; i++){//144*88Day
//				if(i == 3579){
//					System.out.println("");
//					long j = 89602200000;
//					j += 600000;
//				}
				long currentTime = stime.getTime() + i * interval * 60 * 1000L;
//				System.out.println(currentTime);
				Date newTime = new Date(currentTime);
				String currentPeriod = dateFormatter.format(newTime);
//				System.out.println(currentPeriod + " i: " + i);
				periodsInAll[i] = currentPeriod;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void InitPeriodsInDay(int interval){
		String startTime = "22:00:00";
		try {
			Date stime = timeFormatter.parse(startTime);
//			System.out.println(stime.getTime());
			for(int i = 0; i < 144; i++){
				long currentTime = stime.getTime() + i * interval * 60 * 1000L;
//				System.out.println(currentTime);
				Date newTime = new Date(currentTime);
				String currentPeriod = timeFormatter.format(newTime);
//				System.out.println(currentPeriod);
				periodsInDay[i] = currentPeriod;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
	}

	public String getSourceDir() {
		return sourceDir;
	}

	public void setSourceDir(String sourceDir) {
		this.sourceDir = sourceDir;
	}

	public String getTargetFile() {
		return targetFile;
	}

	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

	public String getSumFile() {
		return sumFile;
	}

	public void setSumFile(String sumFile) {
		this.sumFile = sumFile;
	}

}
