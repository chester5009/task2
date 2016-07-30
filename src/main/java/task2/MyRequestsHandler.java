package task2;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.*;
import java.text.*;
//import org.json.simple.JSONObject;
//import org.json.simple.*;
//import java.util.HashMap;
//import java.util.Map;
import org.json.*;

class MyRequestsHandler {
	
	public MyRequestsHandler(){

	}

	public BufferedReader makeRequest(){
		BufferedReader buffer=null;
		try {
			//final String s1 = "http://www.google.ru/#q=sunrise+time"; 
			
			final String token="d726cd273f72c00060f950d5cf47da74";
			String address = "http://api.openweathermap.org/data/2.5/weather?id=524901&APPID=";
			//String query = "";
			//String charset = "UTF-8";



			URL u=new URL(address+token);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setRequestMethod("GET");
			//uc.setRequestProperty("Content-length", "0");
			uc.setUseCaches(false);
			uc.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
			buffer=br;
			int status = uc.getResponseCode();
			System.out.println(status);

			String line;
			StringBuilder sb=new StringBuilder();
			while((line=br.readLine())!= null){
				//System.out.println(line);
				sb.append(line);
			}
			System.out.println("LEN "+sb.length());
			String j=sb.toString();

			//System.out.println(j);
			JSONObject json = new JSONObject(j);
			//System.out.print("Мой ЖиСОН \n"+"Восход - "+json.getJSONObject("sys").get("sunrise")+"\n"+
			//								"Заход - "+json.getJSONObject("sys").get("sunset")+"\n");

			long time_rise=json.getJSONObject("sys").getLong("sunrise");
			long time_set=json.getJSONObject("sys").getLong("sunset");

			Date date=new Date(time_rise*1000L);
			SimpleDateFormat simple_data = new SimpleDateFormat("h:mm a");
			String finished_date1=simple_data.format(date);

			date=new Date(time_set*1000L);
			//simple_data = new SimpleDateFormat("h:mm a");
			//simple_data.setTimeZone(TimeZone.getTimeZone("GMT-4"));
			String finished_date2=simple_data.format(date);

			System.out.println(time_rise+" "+time_set);
			System.out.println("Восход - "+finished_date1+" "+
							 "Заход - "+finished_date2+"\n");

			return buffer;
			
		} catch (Exception e) {
			System.out.println("ERRRR " +e.getMessage());
		}
		
		return buffer;
	}
	public void writeInFile(String name,List<String> data){
		try{
			FileOutputStream writer=new FileOutputStream(name);
			for (String one: data) {
				byte[] buffer=one.getBytes();
				writer.write(buffer,0,buffer.length);

				buffer=new String("\n").getBytes();
				writer.write(buffer,0,buffer.length);
			}
		}catch (IOException e) {
			System.out.println("Error write in file");
		}
	}
}