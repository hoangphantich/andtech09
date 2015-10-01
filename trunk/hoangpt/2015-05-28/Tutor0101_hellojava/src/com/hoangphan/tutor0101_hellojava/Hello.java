package com.hoangphan.tutor0101_hellojava;

public class Hello {
	/**
	 * properties, field, attribute
	 * global variable
	 */
	static String name = "bac Ho";
	
	void sayMorningToMai(){
		System.out.println("Chao em Mai");
	}
	
	void sayMorning(String name){
		//name: local variable
		System.out.println("Chao em "+name);
	}
	
	static void sayMorningtoUnCle(){
		System.out.println("Nghiem. Chung chao "+name);
	}

}
