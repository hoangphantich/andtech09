package com.javabase.maths;

import java.util.Scanner;

public class MathSolver {


	public void solve() {
		//read a,b,c
		Scanner scanner = new Scanner (System.in);
		System.out.print("Insert value for a = ");
		float a = scanner.nextFloat();
		System.out.print("Insert value for b = ");
		float b = scanner.nextFloat();
		System.out.print("Insert value for c = ");
		float c = scanner.nextFloat();
		System.out.println("Result: ");
		if (a == 0 && b ==0 && c ==0) {
			System.out.println("x is anything");
		} else if (a == 0 && b ==0 && c !=0) {
			System.out.println("The equation has no real root");
		} else if (a == 0 && b != 0) {
			System.out.println("x = "+ (-c/b) );
		} else {
			double delta =  (Math.pow(b, 2) - 4*a*c);
			if (delta <0) {
				System.out.println("The equation has no real root");
			} else if (delta == 0) {
				System.out.println(" x1 = x2 = " + (-b/(2.0*a)));
			} else {
				double x1 = (-b + Math.sqrt(delta))/2.0*a;
				double x2 = (-b - Math.sqrt(delta))/2.0*a;
				System.out.println("x1 = " + x1 + ", x2 = " + x2);
			}

		}
		//calculate Delta
		
		
		//if Delta < 0->vo nghiem
		
		
		//Delta > 0->2 nghie
		
	}

}
