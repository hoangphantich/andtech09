package com.hoangphan.check02h_bikenr;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CittynrExtractor {
	
	Map<Integer, String> map = new TreeMap<Integer, String>();
	
	{
		map.put(30, "Ha Noi");
		map.put(16, "Hai Phong");
		map.put(53, "Sai Gon");
	}
	
	Integer extractData(String str1){
		//get 2 char from str1
		String cityCodeStr = str1.substring(0, 2);
		int cityCode = Integer.parseInt(cityCodeStr);
		
		return cityCode;
	}
	
	String getCity(int cityCode){
		String cityName = map.get(cityCode);
		if(null != cityName){
			return cityName;
		}
		
		return null;
	}

}
