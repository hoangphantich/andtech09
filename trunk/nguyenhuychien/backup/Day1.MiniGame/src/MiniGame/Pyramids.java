package MiniGame;

import java.util.Scanner;

public class Pyramids {

	public void building() {
		Scanner input = new Scanner(System.in);
		System.out.println("Thanks for choose me");
		System.out.println("Enter floor");
		int floor = input.nextInt();

		for (int i = 1; i <= floor; i++) {

			for (int k = 1; k <= floor - i; k++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
