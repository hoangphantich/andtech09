package Mini_game;
import java.util.Scanner;


public class Pine {
	public void build(){
		int height;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height: ");
		height = sc.nextInt();
		for(int i = 0; i<height;){
			System.out.print("\n*");
			i++;
		}
	}
}
