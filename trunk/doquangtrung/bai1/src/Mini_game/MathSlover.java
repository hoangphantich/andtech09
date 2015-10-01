package Mini_game;
import java.util.Scanner;


public class MathSlover {
	public void mathslover(){
		int a, b, c, d;
		float x, y;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a =");
		a = scanner.nextInt();
		System.out.println("Enter b =");
		b = scanner.nextInt();
		System.out.println("Enter c =");
		c = scanner.nextInt();
		d= b*b-4*a*c;
		if(a==0){
			System.out.println("Phuong trinh co nghiem la x=" +(-c/a));
		}
		else if(d>0){
			System.out.println("Phuong trinh co 2 nghiem phan biet x1="+(-Math.sqrt(d)-b/2/a) + "x2=" + (Math.sqrt(d)-b/2/a));
		}
		else if(d==0){
			System.out.println("Phuong trinh co nghiem kep x1 = x2 =" + (-b/2/a));
		}
		else{
			System.out.println("Phuong trinh vo nghiem");
		}
	}
}
