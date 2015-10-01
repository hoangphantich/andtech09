package com.hoangphan.check02h_bikenr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BikenrValidator {
	
	//consume memory
	/**
	 * str1 = 29K4
	 * @param str1
	 * @return
	 */
	static boolean checkNr1(String str1){
		String regex = "^[1-9][0-9][A-Z][1-9]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str1);
		
		if(matcher.matches()){
			return true;
		}
		
		return false;
	}

	static boolean checkNr2(String str2){
		return str2.matches("\\d{2}");
	}

	static boolean checkNr3(String str3){
		return str3.matches("\\d{3}");
	}
	
	
}
