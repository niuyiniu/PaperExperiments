package cn.edu.sjtu.se.reins.provision;

import cn.edu.sjtu.se.reins.prediction.WorkloadPredictor;

public class WorkloadScheduler {
	
	private String input; 
	
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
	}
	
	public void schedule(){
		
	}
	
	public void printCurSolution(){
		
	}
	
	

}
