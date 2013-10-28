package cn.edu.sjtu.se.reins.luh.utils;

import java.util.Date;

public class Request {

	private Date date;
	private String resource;
	private int size;
	
	public Request(){
		
	}
	
	public Request(Date date, String resource){
		this.date = date;
		this.resource = resource;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getResourceKey(){
		return this.resource+"_"+this.size;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		else if(!(o instanceof Request))
			return false;
		else{
			Request r = (Request)o;
			return this.resource.equals(r.resource)
				&& this.size == r.size;
		}
	}
	
	@Override
	public int hashCode(){
		return (this.resource+this.size).hashCode();
	}
	
	public String toString(){
		return new String("("+date.toGMTString()+" , "+resource+" , "+size+")");
	}
}
