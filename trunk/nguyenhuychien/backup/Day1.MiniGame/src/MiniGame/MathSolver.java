package MiniGame;

import java.util.Scanner;

public class MathSolver {

	public void doMath() {
		Scanner input = new Scanner(System.in);
		System.out.println("Thanks for choose me");
		System.out.println("Enter a");
		double a = input.nextDouble();
		System.out.println("Enter b");
		double b = input.nextDouble();
		System.out.println("Enter c");
		double c = input.nextDouble();
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("pt vo so nghiem");
				} else {
					System.out.println("pt vo nghiem");
				}
			} else {

				System.out.println("pt co nghiem duy nhat x = " + (-c / b));
			}
		}
		else{
			double delta = b*b - 4*a*c;
			if(delta < 0){
				System.out.println("pt vo nghiem");
			}
			else if(delta ==  0){
				System.out.println("pt co nghiem kep x1 = x2 = "+(-b/(2*a)));
			}
			else{
				double x1 = (-b-Math.sqrt(delta))/(2*a);
				double x2 = (-b+Math.sqrt(delta))/(2*a);
				System.out.println("pt co 2 nghiem phan biet la x1 = "+x1+" x2 = "+x2);
			}
		}
	}
}
