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
	public static int PERIOD = 10;//表示一个时间间隔是5分钟
	public static int SPLIT_NUMS = 24*60/PERIOD;
	public static String INPUT_PATH = "G:\\workload\\day81.out";
    public static int[] getFrequency(){ 	
    	int[] frequency = new int[SPLIT_NUMS];
    	for(int i=0; i<SPLIT_NUMS; i++){
    		frequency[i]=0;
    	}
    	try {
    		Date start_time = simFormat.parse(START_TIME);
			BufferedReader br = new BufferedReader(new FileReader(new File(INPUT_PATH)));
			String oneLine = br.readLine();
			oneLine = br.readLine();			
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
				//当前时间和起始时间的差距
				long gap_minute = (request.getDate().getTime()-start_time.getTime())/(1000*60);
				int index = (int) (gap_minute/PERIOD);
				if(index >= 0 && index < SPLIT_NUMS){
					frequency[index]++;
				}else{
					System.out.println("out of index!");
				}
				numbers++;
				if(numbers%100000 == 0){
					System.out.println("Have already done the first "+numbers+" logs");
				}
				oneLine = br.readLine();
			}
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
}
