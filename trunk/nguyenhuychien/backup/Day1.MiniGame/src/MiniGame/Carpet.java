package MiniGame;

import java.util.Scanner;

public class Carpet {

	public void building() {
		Scanner input = new Scanner(System.in);
		System.out.println("Thanks for choose me");
		System.out.println("Enter hight");
		int hight = input.nextInt();
		System.out.println("Enter width");
		int width = input.nextInt();
		for(int i=0;i<hight;i++){
			for(int j=0;j<width;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
