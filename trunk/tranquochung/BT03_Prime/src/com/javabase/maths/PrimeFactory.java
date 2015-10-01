package com.javabase.maths;

import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author hungtq
 * @date 15/03/2015
 *
 */
public class PrimeFactory {
	
	
	private void print(int n, PrimeStrategy strategy) {
		List<Integer> lstPrime = strategy.algorithm (n);
		System.out.println();
		System.out.format("Ket qua tim cac so nguyen to nho hon %d theo phuong phap %s :", n, strategy.getName());
		System.out.println();
		for (int i = 0; i < lstPrime.size(); i++) {	
			if (i %5 == 0 && i >0) {
				System.out.println();
			}
			System.out.format("%4d",lstPrime.get(i));
		}
		
	}
	
	public void build () {
		int n = 0;
		Scanner scr = new Scanner (System.in);
		do {
			System.out.println("Nhap mot so nguyen duong: ");
			n = scr.nextInt();
			if (n <0) {
				System.out.println("So vua nhap khong hop le. Vui long nhap lai!");
			}
		} while (n < 0);
		
		print(n, new EratosPrimeStrategy());
		print(n, new CommonPrimeStrategy());
		
	}
}
