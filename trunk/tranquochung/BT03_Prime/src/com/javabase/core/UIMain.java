package com.javabase.core;

import java.util.Scanner;
import com.javabase.maths.PrimeFactory;

public class UIMain {
	
	private static int choose() {
		Scanner scr = new Scanner(System.in);
		int result = 2;//default
		do {
			result = scr.nextInt();
			if (result != 1 && result != 2) {
				System.out.print("So vua nhap khong hop le, chon chuc nang 1 hoac 2:");
			}
		} while ( result != 1 && result != 2);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isLoop = true;
		do {
			// Menu
			System.out.println();
			System.out.println("1-Tim cac so nguyen to");
			System.out.println("2-Thoat chuong trinh");
			System.out.print("Hay chon chuc nang:");
			int n = choose();
			// Do anything	
			switch (n) {
			case 1:
				PrimeFactory ctx = new PrimeFactory();
				ctx.build();
				break;
			case 2: 
				isLoop = false;
				break;
			default:
				
				break;
			} 
			
			
		} while (isLoop);

	}

}
