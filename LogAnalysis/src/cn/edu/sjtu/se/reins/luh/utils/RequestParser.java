package cn.edu.sjtu.se.reins.luh.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class RequestParser {
	public static DateFormat getDefaultDateFormat(){
		DateFormat defaultDF = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",Locale.ENGLISH);
		defaultDF.setTimeZone(TimeZone.getTimeZone("GMT"));
		return defaultDF;
	}
	
	public static String getCurrentDate(){
		DateFormat defaultFormat = RequestParser.getDefaultDateFormat();
		return defaultFormat.format(new Date());
	}
	
	public static Date parseRequestDate(String requestDate,DateFormat df) 
		throws ParseException{
		
		Date date = df.parse(requestDate);
		return date;
	}
	public static Request parseRequestString(String requestString, DateFormat df)
			throws ParseException {
		if (requestString == null) {
			System.out.println("the request string is null!");
			return null;
		}
		String[] tokens = requestString.split("[\\s-\"\\[\\]]+");
		if (tokens == null || tokens.length <= 0) {
			System.out.println("illegal request string!");
			return null;
		}

		String dateString;
		String resource;
		int size;
		try {
			dateString = tokens[RequestToken.Date.getIndex()];
			resource = tokens[RequestToken.Resource.getIndex()];
			int i = RequestToken.ReplySize.getIndex();
			//String sizeString = tokens[RequestToken.ReplySize.getIndex()];
			//size = Integer.parseInt(sizeString);
		} catch (Exception ex) {
			// ignore
			return null;
		}

		Request r = new Request();
		Date date = RequestParser.parseRequestDate(dateString, df);
		r.setResource(resource);
		r.setDate(date); // set the time(in milliseconds) after the start time
		//r.setSize(size);
		return r;
	}
}
