package MiniGame;

import java.util.Scanner;

public class Prime {

	public void list() {
		Scanner input = new Scanner(System.in);
		System.out.println("Thanks for choose me");
		int dem , n, i, j;
		System.out.println("Enter n:");
		n = input.nextInt();
		System.out.printf("cac so nguyen to < %d la:\n", n);
		for (i = 2; i < n; i++) {
			dem = 0;
			for (j = 2; j <= i; j++) {
				if (i % j == 0) {
					dem++;
				}
				
			}
			if (dem == 1) {
				System.out.println(i);
			}
		}
	}
}
