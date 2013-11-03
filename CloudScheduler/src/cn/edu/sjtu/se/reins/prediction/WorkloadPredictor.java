package cn.edu.sjtu.se.reins.prediction;

import cn.edu.sjtu.se.reins.excel.utils.ExcelHandler;

public class WorkloadPredictor {
	
	private String inputPath;
	private int historyWindow = 20;
	private int[] historyLoad = new int[12672];
	private double[] predictedLoad = new double[12672];
	private int curIndex = 0;
	
	public int getCurIndex() {
		return curIndex;
	}

	public void setCurIndex(int curIndex) {
		this.curIndex = curIndex;
	}

	public WorkloadPredictor(){
		
	}
	
	public WorkloadPredictor(String str){
		setInputPath(str);
	}
	
	public void init(){
		ExcelHandler eh = new ExcelHandler(getInputPath());
		eh.readColumn(historyLoad, 1, 1);
		eh.readColumn(predictedLoad, 1, 2);
	}
	
	public int predictNext(){
		int nextLoad = formatPrediction(predictedLoad[getCurIndex()]);
		setCurIndex(getCurIndex() + 1);
		return nextLoad;
	}
	
	public int formatPrediction(double source){
		//incase the predicted data < 0
		if(source < 0){
			return 0;
		}
		else{
			return (int) source;
		}
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public int getHistoryWindow() {
		return historyWindow;
	}

	public void setHistoryWindow(int historyWindow) {
		this.historyWindow = historyWindow;
	}

	public int[] getHistoryLoad() {
		return historyLoad;
	}

	public void setHistoryLoad(int[] historyLoad) {
		this.historyLoad = historyLoad;
	}

	public double[] getPredictedLoad() {
		return predictedLoad;
	}

	public void setPredictedLoad(double[] predictedLoad) {
		this.predictedLoad = predictedLoad;
	}

}
