package Eshop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Payment {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager mn = new Manager();
		System.out.println("Welcome to media mart shop");
		System.out.println("--------------------------------");
		System.out.println("1 - Buy products.");
		System.out.println("2 - Checkout.");
		System.out.println("3 - Exit.");
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select your choice: 1, 2, 3.");
		n = sc.nextInt();
		switch (n) {
		case 1:
			mn.buyProducts();
			break;
		case 2:
			try {
				mn.epBill();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mn.hien();
			break;
		default:
		}
		
	}
}
