package com.hoangphan.tutor1002_txt.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network {
	
	public static InputStream getIsFromUrl(String url){
		//open connection
		try {
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection ) urlObj.openConnection();

			conn.setRequestMethod("GET");
			conn.connect();			
			
			//inputstream
			InputStream is = conn.getInputStream();
			return is;
		} catch (Exception ex){
		}
		
		return null;
	}

}
