package com.javabase.ui;

import java.util.Scanner;

import com.javabase.control.StudentManager;

public class UIMain {
	
	private static int chooseIt () {
		Scanner scanner  = new Scanner(System.in);
		int ans = 0;
		do {
			ans = scanner.nextInt();
			if (ans != 1 && ans != 2 && ans != 3  && ans != 4) {
				System.out.println();
				System.out.print("Wrong input. Select your choice <1,2,3,4>: ");
			}
 		} while (ans != 1 && ans != 2 && ans !=3 && ans != 4);
		
		return ans;
	}
	
	public static void main (String[] args) {
		int ans = 0;
		do {
			System.out.println("Student manager application");
			System.out.println("1. Enter a new student");
			System.out.println("2. Print sorted list");
			System.out.println("3. Find student");
			System.out.println("4. Exit");
			System.out.print("Select your choice <1,2,3,4>:");
			ans = chooseIt();
			
			switch (ans) {
			case 1:
				StudentManager.newRecord();
				break;
			case 2: 
				StudentManager.printIt();
				break;
			case 3:
				StudentManager.findIt();
			case 4: 
				System.out.println();
				System.out.println("Goodbye!");
				break;
			default:
				break;
			}
		} while (ans != 4);
		
		
	}

}
