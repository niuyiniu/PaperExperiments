package cn.edu.sjtu.se.reins.excel.utils;

import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelHandler {

	private static int WINDOWLEN = 20;
	
	public ExcelHandler(){
		
	}
	
	
	//write the request array into file file and in a sheet named sheetname
	public void writeArray(int[] array,File file, String sheetname){
		WritableWorkbook wwb = null;
		// 创建Excel工作表
//		WritableSheet sheet1 = null;
		Workbook wb = null;
		try {
			// Excel获得文件
			wb = Workbook.getWorkbook(file);

			// 打开一个文件的副本，并且指定数据写回到原文件
			wwb = Workbook.createWorkbook(file, wb);
			
			
			
			WritableSheet[] sheets = wwb.getSheets();
			
			int sheetnum = sheets.length;

			// 读取第一张工作表
//			sheet1 = wwb.getSheet(0);
//
//			Label l = new Label(0, 0, "姓名");// 第1行
//			sheet1.addCell(l);
//			l = new Label(1, 0, "电话");
//			sheet1.addCell(l);
//			l = new Label(2, 0, "地址");
//			sheet1.addCell(l);
//			l = new Label(0, 1, "小祝");// 第2行
//			sheet1.addCell(l);
//			l = new Label(1, 1, "1314***0974");
//			sheet1.addCell(l);
//			l = new Label(2, 1, "武汉武昌");
//			sheet1.addCell(l);

			// 添加一个工作表
			WritableSheet newsheet = wwb.createSheet(sheetname, sheetnum);
			//newsheet.addCell(new Label(0, 0, "第二页的测试数据"));

			// 输出流
			wwb.write();

			// 关闭流
			wwb.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void readExample(String filename){
		File file = new File(filename);
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(file);
			Sheet s = wb.getSheet(0);// 第1个sheet
			Cell c = null;
			int row = s.getRows();// 总行数
			int col = s.getColumns();// 总列数
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					c = s.getCell(j, i);
					System.out.print(c.getContents() + "  ");
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}		
		
	}
	
	public int[] readArray(){
		int[] array = new int[WINDOWLEN]; 
		return array;
		
	}

	public static int getWINDOWLEN() {
		return WINDOWLEN;
	}

	public static void setWINDOWLEN(int wINDOWLEN) {
		WINDOWLEN = wINDOWLEN;
	}


}