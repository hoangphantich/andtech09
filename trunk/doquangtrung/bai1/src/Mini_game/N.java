package Mini_game;

import java.util.Scanner;

public class N {
	public void kiemtra() {
		int n;
		System.out.println("Nhap so kiem tra: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (i == 1) {
				System.out.println("Khong phai so N.to");
			} else if ((i % 2) == 0) {
				System.out.println("Khong phai so N.to");
			} else if (i == 2) {
				System.out.println(i + "La so nguyen to.");
			} else if ((i % n) != 0) {
				System.out.println(i + "La so nguyen to.");
			}
		}

	}

}
