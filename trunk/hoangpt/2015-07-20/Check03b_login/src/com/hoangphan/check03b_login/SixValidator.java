package com.hoangphan.check03b_login;

interface Validator {
	boolean validator(String text);
}

public class SixValidator implements Validator {

	@Override
	public boolean validator(String text) {
		if(text.length() >= 6){
			return true;
		}
		
		return false;
	}
}
