package cn.edu.sjtu.se.reins.providers.amazon;

public class ProvisionSolution {
	
	private int onDemandAmount = 0;
	private int reservedAmount = 0;
	private int spotAmount = 0;
	
	public void print(){
		System.out.print("OnDemand \\t Reserved \\t Spot");
		System.out.print(getOnDemandAmount() + " \\t " + getReservedAmount() + " \\t " + getSpotAmount());
	}
	
	public ProvisionSolution(int a, int b, int c){
		setOnDemandAmount(a);
		setReservedAmount(b);
		setSpotAmount(c);
	}
	
	public int getOnDemandAmount() {
		return onDemandAmount;
	}
	public void setOnDemandAmount(int onDemandAmount) {
		this.onDemandAmount = onDemandAmount;
	}
	public int getReservedAmount() {
		return reservedAmount;
	}
	public void setReservedAmount(int reservedAmount) {
		this.reservedAmount = reservedAmount;
	}
	public int getSpotAmount() {
		return spotAmount;
	}
	public void setSpotAmount(int spotAmount) {
		this.spotAmount = spotAmount;
	}

}
