package quan_ly_diem_sinh_vien;

import java.util.Scanner;


public class menu {

	private static Scanner input;

	public static void main( String[] args ) throws Exception {
		int choice;
		// print menu 1,2,3,4
		System.out.println("Welcome to bkacad mark manager:");
		System.out.println("1 - Record Students information");
		System.out.println("2 - Display sorted list");
		System.out.println("3 - Exit");
		ds_sinhvien ds = new ds_sinhvien();
		
		do {
			System.out.println("\n What do you want (1,2,3):");
			input = new Scanner(System.in);
			choice = input.nextInt();
			if ( choice < 1 || choice > 3 ) {
				System.out.println("Error!!! Enter 1,2,3,4");
			}
			else {
				switch( choice ) {
				case 1: {
					ds.themlap();
					break;
				}
				case 2: {
					ds.print();
					break;
				}
				case 3: {
					System.exit(0);
				}
				}
				
			}	
		}
		while(choice != 3);
	}		
}

	