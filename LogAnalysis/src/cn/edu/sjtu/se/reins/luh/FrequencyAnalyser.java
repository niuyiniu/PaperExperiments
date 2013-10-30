package cn.edu.sjtu.se.reins.luh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.sjtu.se.reins.luh.utils.Request;
import cn.edu.sjtu.se.reins.luh.utils.RequestParser;

public class FrequencyAnalyser {
	static SimpleDateFormat simFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	public static String START_TIME = "1998.01.23 22:00:01";
	public static int PERIOD = 10;//��ʾһ��ʱ������5����
	public static int SPLIT_NUMS = 24*60/PERIOD;
	public String INPUT_PATH = "";
	
	public FrequencyAnalyser(){
		
	}
	
    public int[] getFrequency(){ 	
    	int[] frequency = new int[SPLIT_NUMS];
    	for(int i=0; i<SPLIT_NUMS; i++){
    		frequency[i]=0;
    	}
    	try {
    		Date start_time = simFormat.parse(START_TIME);
			BufferedReader br = new BufferedReader(new FileReader(new File(getINPUT_PATH())));
			String oneLine = br.readLine();
			oneLine = br.readLine();
			Request r = RequestParser.parseRequestString(oneLine, RequestParser.getDefaultDateFormat());
			start_time = RequestParser.parseRequestString(oneLine, RequestParser.getDefaultDateFormat()).getDate();
			int numbers = 0;
			int null_numbers = 0;
			while(oneLine != null){
				Request request = RequestParser.parseRequestString(oneLine, RequestParser.getDefaultDateFormat());
				if (request == null) {
					//System.out.println("null request! "+oneLine);
					null_numbers++;
					oneLine = br.readLine();
					continue;
				}
				//
				long gap_minute = (request.getDate().getTime()-start_time.getTime())/(1000*60);
				int index = (int) (gap_minute/PERIOD);
				if(index >= 0 && index < SPLIT_NUMS){
					frequency[index]++;
				}else{
					System.out.println("out of index!");
				}
				numbers++;
				if(numbers%1000000 == 0){
					System.out.println("Have already done the first "+numbers+" logs");
				}
				oneLine = br.readLine();
			}
			br.close();
			System.out.println("now all get done");
			System.out.println("null numbers: "+null_numbers);
			for(int i=0; i < SPLIT_NUMS; i++){
				System.out.println(frequency[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frequency;
    	
    }
	public String getINPUT_PATH() {
		return INPUT_PATH;
	}
	public void setINPUT_PATH(String iNPUT_PATH) {
		INPUT_PATH = iNPUT_PATH;
	}
}
