package com.javabase.graphic;

import java.util.Scanner;

public class TowelMaker {
	
	// Unittest
	public static void main (String[] args) {
		TowelMaker towel = new TowelMaker();
		towel.build();
	}
	
	private int getSize() {
		int ans = 0;
		Scanner scanner  = new Scanner(System.in);
		do {
			ans = scanner.nextInt();
			if (ans <= 0) {
				System.out.println();
				System.out.println ("Wrong input. Key number again:");
			}
		} while (ans <= 0);
		
		return ans;
	}

	public void build() {
		//build 4x4
		int height = 4;
		int width = 4;
		
		System.out.print("Enter height:");
		height = getSize();
		System.out.println();
		System.out.print("Enter width:");
		width = getSize();
		//build each column
		for (int i = 0; i < height; i++) {
			//build each row
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
