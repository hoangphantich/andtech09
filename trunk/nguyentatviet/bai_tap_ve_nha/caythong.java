package buoi1;

import java.util.Scanner;

public class caythong {
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);// onject OOP
		// int ans = scanner.nextInt(); // primitive long, char, byte
		// qui luat 1-3-5-7
		// j là hàng, i là cột
		int height = 20;
		for (int i = 0; i < height; i++) {
			for (int j = height; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < height; j++) {
				if (j == 1 + 2 * i) {
					for (int j2 = 0; j2 < j; j2++) {
						System.out.print("*");
					}
				}
			}
			System.out.println("");
		}
	}
}
