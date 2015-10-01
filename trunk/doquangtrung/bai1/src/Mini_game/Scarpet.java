package Mini_game;
import java.util.Scanner;


public class Scarpet {
	public void scarpet(){
		int height, width;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height: ");
		height = sc.nextInt();
		System.out.println("Enter width: ");
		width = sc.nextInt();
		for(int i = 0; i<height; i++){
			System.out.print("\n*");
			for(int j=1;j<width; j++){
				System.out.print("*");
			}
		}
		
		
		
	}
}
