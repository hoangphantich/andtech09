package com.javabase.ui;

import java.util.Scanner;

import com.javabase.graphic.SkyScraper;
import com.javabase.graphic.TowelMaker;
import com.javabase.maths.MathSolver;


/**
 * 
 * @author hungtq
 * @date 15/03/2015
 *
 */
public class UIMain {

	private static int chooseIt() {
		int ans = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			ans = scanner.nextInt();
			if (ans <1 || ans >4) {
				System.out.println();
				System.out.print("Wrong input. Key number again:");
			}
		} while (ans <1 || ans >4);
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//do loop
		int ans = 0;
		
		do {
			//print menu: 1,2,3
			System.out.println("1. Solver ax2+bx+c=0");
			System.out.println("2. Towel Maker");
			System.out.println("3. Skyscrapper");
			System.out.println("4. Exit");
			
			//print question?
			System.out.print("Choose 1,2,3,4:");
			ans = chooseIt();
			
			//question=1 -->MathSolver
			switch (ans) {
			case 1:
				MathSolver solver = new MathSolver();
				solver.solve();
				break;
			case 2:
				TowelMaker maker = new TowelMaker();
				maker.build();
				break;
			case 3:
				new SkyScraper().build();
				break;
			default:
				break;
			}			
		} while (ans !=4);
		System.out.println("Goodbye!");
	
	}

}
