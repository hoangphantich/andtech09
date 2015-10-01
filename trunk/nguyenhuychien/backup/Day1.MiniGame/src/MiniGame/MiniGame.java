package MiniGame;

import java.util.Scanner;

public class MiniGame {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		int choose = 0;
		System.out.println("Well come to mini game");
		System.out.println("1. Do math ax2 + bx + c =0");
		System.out.println("2. Build a magic carpet");
		System.out.println("3. Build a pyramids");
		System.out.println("4. List prime < 100");
		System.out.println("5. Exit");
		
		while (loop) {
			System.out.println("what do you want <1,2,3,4,5> ?");
			choose = input.nextInt();
			switch (choose) {
			case 1:
				MathSolver math = new MathSolver();
				math.doMath();
				break;
			case 2:
				Carpet magic = new Carpet();
				magic.building();
				break;
			case 3:
				Pyramids pyramids = new Pyramids();
				pyramids.building();
				break;
			case 4:
				Prime prime = new Prime();
				prime.list();
				break;
			case 5:
				System.out.println("Bye bye !");
				loop = false;
				break;
			default:
				System.out.println("Enter Wrong ^^");

				break;
			}

		}
	}
}
