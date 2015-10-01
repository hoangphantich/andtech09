package com.hoangphan.tutor0101_hellojava;

import java.util.Scanner;

public class Main {
	
	/**
	 * bootstrap
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Java");
		
		//use class Hello
		Hello hello = new Hello();
		hello.sayMorningToMai();
		
		//hoi ten
		System.out.print("Em ten gi:"); //monitor
		Scanner scan = new Scanner(System.in); //keyboard
		String name = scan.next();
		hello.sayMorning(name);
		
		Hello.sayMorningtoUnCle();
		
		//primitive type
		//-- number: char[ascii], byte, int, long, float, double
		//-- String
		int age = 8;
		long number = 100000000;
		
		char c = 3;
		char d = 'D'; //ascii = 104
		
		String welcome = "Chao ban Huong"; //object
		for (int i = 0; i < age; i++) {
			System.out.println(welcome);
		}
		
		float interest = 0.1f;
		double income = number*interest;
		System.out.println("After 1 year, income is: "+income+". ^^");
	}
}
