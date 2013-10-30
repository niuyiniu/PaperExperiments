package cn.edu.sjtu.se.reins.main;

import cn.edu.sjtu.se.reins.excel.utils.BatchHandler;


public class MainClass {
    public static void main(String[] args){
    	
    	BatchHandler bh = new BatchHandler();
    	bh.setSourceDir(args[0]);
    	bh.setTargetFile(args[1]);
    	bh.setSumFile(args[2]);

    	bh.InitPeriodsInDay(10);
    	bh.InitPeriodsInAll(10);
    	bh.start();
    	System.out.println("batch handler process over");
    }
}
