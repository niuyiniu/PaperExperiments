package cn.edu.sjtu.se.reins.providers.amazon;

public class ReservedInstance extends VirtualInstance{
	
	private double ReservedPrice;
	private int ReservedTerm;//default 1 year term
	
	public ReservedInstance(){
		setHourlyPrice(0.034);
		setReservedPrice(61.000);
		setReservedTerm(1);	
	}

	public double getReservedPrice() {
		return ReservedPrice;
	}

	public void setReservedPrice(double reservedPrice) {
		ReservedPrice = reservedPrice;
	}

	public int getReservedTerm() {
		return ReservedTerm;
	}

	public void setReservedTerm(int reservedTerm) {
		ReservedTerm = reservedTerm;
	}

}
