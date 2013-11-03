package cn.edu.sjtu.se.reins.main;

import cn.edu.sjtu.se.reins.provision.WorkloadScheduler;

public class MainClass {

	public static void main(String[] args){
		
		System.out.println("Starting to provision resources...");
		WorkloadScheduler ws = new WorkloadScheduler();
		ws.setInput(args[0]);
		ws.start();
		System.out.println("Provision end.");
		
	}
}
