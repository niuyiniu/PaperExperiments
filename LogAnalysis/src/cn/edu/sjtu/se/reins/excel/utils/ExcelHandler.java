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
		// ����Excel������
//		WritableSheet sheet1 = null;
		Workbook wb = null;
		try {
			// Excel����ļ�
			wb = Workbook.getWorkbook(file);

			// ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
			wwb = Workbook.createWorkbook(file, wb);
			
			
			
			WritableSheet[] sheets = wwb.getSheets();
			
			int sheetnum = sheets.length;

			// ��ȡ��һ�Ź�����
//			sheet1 = wwb.getSheet(0);
//
//			Label l = new Label(0, 0, "����");// ��1��
//			sheet1.addCell(l);
//			l = new Label(1, 0, "�绰");
//			sheet1.addCell(l);
//			l = new Label(2, 0, "��ַ");
//			sheet1.addCell(l);
//			l = new Label(0, 1, "Сף");// ��2��
//			sheet1.addCell(l);
//			l = new Label(1, 1, "1314***0974");
//			sheet1.addCell(l);
//			l = new Label(2, 1, "�人���");
//			sheet1.addCell(l);

			// ���һ��������
			WritableSheet newsheet = wwb.createSheet(sheetname, sheetnum);
			//newsheet.addCell(new Label(0, 0, "�ڶ�ҳ�Ĳ�������"));

			// �����
			wwb.write();

			// �ر���
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
			Sheet s = wb.getSheet(0);// ��1��sheet
			Cell c = null;
			int row = s.getRows();// ������
			int col = s.getColumns();// ������
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