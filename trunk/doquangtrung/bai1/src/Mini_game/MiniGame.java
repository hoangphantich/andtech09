package Mini_game;

import java.util.Scanner;

public class MiniGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 0;
		do {
			System.out.println("\nWelcome to Mini Game");
			System.out.println("1. Do math ax^2 + bx +c =0");
			System.out.println("2. Buid a magic carpet");
			System.out.println("3. Buidl a Pine");
			System.out.println("4. Check");
			System.out.println("5. Exit");

			System.out.println("What do you want: 1, 2, 3, 4");
			Scanner scaner = new Scanner(System.in);
			n = scaner.nextInt();
			switch (n) {
			case 1:
				MathSlover ms = new MathSlover();
				ms.mathslover();
				break;
			case 2:
				Scarpet sc = new Scarpet();
				sc.scarpet();
			case 3:
				Pine pn = new Pine();
				pn.build();
				break;
			case 4:
				N nt = new N();
				nt.kiemtra();
				break;
			case 5:
				System.exit(n);
				break;
			default:
				System.out.println("Wrong input. Key number again:");
				n = scaner.nextInt();
				break;
			}
		} while (n != 4);
		System.out.println(" \n");

	}
}
