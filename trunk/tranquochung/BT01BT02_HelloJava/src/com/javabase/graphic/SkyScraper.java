package com.javabase.graphic;

import java.util.Scanner;

public class SkyScraper {
	
	public static void main(String[] args) {
		SkyScraper sky = new SkyScraper();
		sky.build();
	}

	public void build() {
		//  *
		// ***
		//*****
		int ans = 0;
		Scanner scanner  = new Scanner(System.in);
		System.out.print(" Enter lenth of tree:");
		do {
			ans = scanner.nextInt();
			if (ans <= 0) {
				System.out.println();
				System.out.println ("Wrong input. Key number again:");
			}
		} while (ans <= 0);
		
		for (int i = 0; i < ans; i++) {
			// Print space
			for (int j = 0; j <= ans -i; j++) {
				System.out.format("%1s", " ");
			}
			
			// Print *
			for (int k = 0; k < (i*2 +1); k++) {
				System.out.format("%1s", "*");
			}
			// New line
			System.out.println();
				
		}
	}

}
