package com.hoangphan.tutor1002_txt.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFactory {
	
	public static String decode(InputStream is){
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line ="";
		String filesTxt = "";
		try {
			while ((line = reader.readLine()) != null) {
				filesTxt += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filesTxt;
	}
	
}
