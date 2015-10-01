import java.util.Scanner;
public class menu {

	private static Scanner input;

	public static void main( String[] args ) {
		int choice;
		// print menu 1,2,3,4
		System.out.println("Welcome to Mini game:");
		System.out.println("1. Do math ax2+bx+c=0");
		System.out.println("2. Build a magic carpet");
		System.out.println("3. Build a SkyScraper");
		System.out.println("4. Exit");
		
		do {
			System.out.println("\n What do you want (1,2,3,4):");
			input = new Scanner(System.in);
			choice = input.nextInt();
			if ( choice < 1 || choice > 4 ) {
				System.out.println("Error!!! Enter 1,2,3,4");
			}
			else {
				switch( choice ) {
				case 1: {
					input = new Scanner(System.in);
					double a, b, c;
					System.out.print( "Enter a: " );
					a = input.nextDouble();
					System.out.print( "Enter b: " );
					b = input.nextDouble();
					System.out.print( "Enter c: " );
					c = input.nextDouble();
					MathSolved cal = new MathSolved(a, b, c);
					cal.tinh();
					break;
				}
				case 2: {
					input = new Scanner(System.in);
					int x,y;
					System.out.print("Enter width:");
					x = input.nextInt();
					System.out.print("Enter heigh:");
					y = input.nextInt();
					System.out.println("Start building: ");
					aladin tham = new aladin(x, y);
					tham.print();
					break;
				}
				case 3: {
					input = new Scanner(System.in);
					int k;
					System.out.print("Enter heigh SkyScraper: ");
					k = input.nextInt();
					SkyScraper cay = new SkyScraper(k);
					cay.build();
					break;
				}
				}
				
			}	
		}
		while(choice != 4);
	}		
}

	