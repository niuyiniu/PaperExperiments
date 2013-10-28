package cn.edu.sjtu.se.reins.main;

import java.io.File;

import cn.edu.sjtu.se.reins.luh.*;
import cn.edu.sjtu.se.reins.excel.utils.ExcelHandler;

public class MainClass {
    public static void main(String[] args){
    	
    	String sheetname = "day81";
    	File file = new File("K:\\workload\\test.xlsx");
    	//int[] requestByMin = FrequencyAnalyser.getFrequency();
    	int[] requestByMin = {1,2,3,4,6};
    	ExcelHandler eh = new ExcelHandler();
    	eh.writeArray(requestByMin, file, sheetname);
    }
}
