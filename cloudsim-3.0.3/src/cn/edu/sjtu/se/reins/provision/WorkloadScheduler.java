package cn.edu.sjtu.se.reins.provision;

import java.util.LinkedList;

import cn.edu.sjtu.se.reins.application.templates.WorldcupApp;
import cn.edu.sjtu.se.reins.prediction.WorkloadPredictor;
import cn.edu.sjtu.se.reins.providers.amazon.*;

public class WorkloadScheduler {
	
	private String input; 
	private static int averageLow = 0;
	private static int averageHigh = 0;
	
	private static LinkedList<ProvisionSolution> solutions = new LinkedList<ProvisionSolution>();
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public WorkloadScheduler(){
		
	}
	
	public void start(){
		WorkloadPredictor wp = new WorkloadPredictor(input);
		wp.init();
		int initialVM = WorldcupApp.INITIALVM;
		ProvisionSolution initialSolution = new ProvisionSolution(initialVM, 0, 0);
		solutions.addLast(initialSolution);
	}
	
	public void schedule(){
		
	}
	
	public void printSolutions(){
		
	}

	public static int getAverageLow() {
		return averageLow;
	}

	public static void setAverageLow(int averageLow) {
		WorkloadScheduler.averageLow = averageLow;
	}

	public static int getAverageHigh() {
		return averageHigh;
	}

	public static void setAverageHigh(int averageHigh) {
		WorkloadScheduler.averageHigh = averageHigh;
	}
	
	

}
