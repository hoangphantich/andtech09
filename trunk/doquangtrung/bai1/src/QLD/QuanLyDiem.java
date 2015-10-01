package QLD;

import java.util.Scanner;

public class QuanLyDiem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuanLyHocVien qlhv = new QuanLyHocVien();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("Welcome to bkacad mark manager."
					+ "\n==============================");
			System.out.println("1- Record Students Information");
			System.out.println("2 - Display sorted list.");
			System.out.println("3- Exit");
			System.out.println("4- Select your choice: 1, 2, 3");
			n = sc.nextInt();
			switch (n) {
			case 1:
				qlhv.nhap();
				break;
			case 2:
				qlhv.sapxep();
				break;
			case 3:
				System.exit(n);
				break;
			default: System.out.println("Vui long chon lai!");
			}
		} while (n != 3);
		System.out.println("\n");
	}

}
