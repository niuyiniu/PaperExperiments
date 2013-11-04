package cn.edu.sjtu.se.reins.excel.utils;

import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelHandler {
	
	public String inputPath;
	public Workbook workbook;
	
	public ExcelHandler(){
		
	}
		
	public ExcelHandler(String str){
		setInputPath(str);
		try {
			workbook = Workbook.getWorkbook(new File(str));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public Workbook getWb() {
		return workbook;
	}

	public void setWb(Workbook wb) {
		this.workbook = wb;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	//write the request array into file file and in a sheet named sheetname
	public void writeArray(int[] array, String[] periods, String sheetname,WritableWorkbook wwb){

		try {
			WritableSheet[] sheets = wwb.getSheets();			
			int sheetnum = sheets.length;
			System.out.println("now have " + sheetnum +" sheets,creating the next one");
			// add a new sheet
			WritableSheet newsheet = wwb.createSheet(sheetname, sheetnum);
			System.out.println("number of sheets after creating : " + wwb.getSheets().length);
			
			writePeriod(0, newsheet, periods);
			writeRequest(1, newsheet, array);
			for(int i = 0; i < array.length; i++){
				newsheet.addCell(new Label(1, i, Integer.toString(array[i])));
			}
		} catch (WriteException e) {
			e.printStackTrace();
		}				
	}
	
	private void writePeriod(int columnIndex, WritableSheet ws, String[] content){
		for(int i = 0; i < content.length; i++){
			try {
				ws.addCell(new Label(columnIndex, i, content[i]));
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void writeRequest(int columnIndex, WritableSheet ws, int[] content){
		for(int i = 0; i < content.length; i++){
			try {
				ws.addCell(new Label(columnIndex, i, Integer.toString(content[i])));
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void appendRequest(int[] requests, WritableWorkbook wwb){
		WritableSheet newsheet = wwb.getSheet(0);
		Cell[] cells = newsheet.getColumn(1);
		for(int i = 0; i < requests.length; i++){
			try {
				newsheet.addCell(new Label(1, cells.length + i, Integer.toString(requests[i])));
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void writeAllPeriods(String[] periods, String sheetname, WritableWorkbook wwb){
		WritableSheet newsheet = wwb.createSheet(sheetname, 0);
		for(int i = 0; i < periods.length; i++){
			try {
				newsheet.addCell(new Label(0, i, periods[i]));
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public void readColumn(int[] array, int sheetIndex, int columnIndex){
		if(workbook != null){
			Sheet s = workbook.getSheet(sheetIndex);
			Cell[] col = s.getColumn(columnIndex);
			System.out.println("cells length " + col.length);
			for(int i = 0; i < col.length; i++){
				if(col[i].getContents() != null){
					array[i] = Integer.parseInt(col[i].getContents());
					System.out.println(array[i]);
				}
			}			
		}		
		
	}
	
	public void readColumn(double[] array, int sheetIndex, int columnIndex){
		if(workbook != null){
			Sheet s = workbook.getSheet(sheetIndex);
			Cell[] col = s.getColumn(columnIndex);
			System.out.println("cells length " + col.length);
			for(int i = 0; i < col.length; i++){
				if(col[i].getContents() != null && col[i].getContents().length() != 0){
					array[i] = Double.parseDouble(col[i].getContents());
					System.out.println(array[i]);
				}
				else{
					
				}
			}			
		}		
		
	}
}
