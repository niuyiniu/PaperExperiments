package cn.edu.sjtu.se.reins.luh.utils;

public enum RequestToken {
	ClientID(0),
	Date(1),
	TimeZone(2),
	RequestMethod(3),
	Resource(4),
	HTTPProtocol(5),
	HTTPReplyCode(6),
	ReplySize(7), //This field may be missing if the HTTPReplyCode is not 200
	
	//Date token
	Day(0),
	Month(1),
	Year(2),
	Hour(3),
	Minute(4),
	Second(5);
	
	private int index;
	public final static String HTTPOKSTATUS = "200";
	
	RequestToken(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
}
