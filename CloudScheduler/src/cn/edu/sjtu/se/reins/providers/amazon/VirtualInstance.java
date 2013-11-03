package cn.edu.sjtu.se.reins.providers.amazon;

public class VirtualInstance {
	
	private String OS;
	private String Region;
	private String Type;
	private double HourlyPrice;
	private double MonthlyPrice;
	
	public VirtualInstance(){
		setOS(new String("Linux"));
		setRegion(new String("US East"));
		setType(new String("Small(default)"));
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public double getMonthlyPrice() {
		return MonthlyPrice;
	}

	public void setMonthlyPrice(double monthlyPrice) {
		MonthlyPrice = monthlyPrice;
	}

	public double getHourlyPrice() {
		return HourlyPrice;
	}

	public void setHourlyPrice(double hourlyPrice) {
		HourlyPrice = hourlyPrice;
	}
	

}
