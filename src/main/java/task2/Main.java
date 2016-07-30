package task2;
import java.io.File;
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

public class Main {

	public static void main(String[] args) {
		MyRequestsHandler mrh=new MyRequestsHandler();
		
		BufferedReader br=mrh.makeRequest();
		
		
		String line;
		

		/*try {
			final String s1 = "http://www.google.ru/#q=sunrise+time"; 
			final String s2 = "https://www.yandex.ru/"; 

			String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
			String query = "";
			String charset = "UTF-8";

			URL u=new URL(s1+URLEncoder.encode(query,charset));
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("Content-length", "0");
			uc.setUseCaches(false);
			uc.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
			int status = uc.getResponseCode();
			System.out.println(status);
			String line;
			while((line=br.readLine())!= null){
				System.out.println(line);
			}

			
		} catch (Exception e) {
			System.out.println("ERRRR" +e.getMessage());
		}
		
		System.out.println("HEEEEE");*/
	}

}