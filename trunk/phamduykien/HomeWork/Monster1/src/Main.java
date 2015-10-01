import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Menu

		int iInputValue = 0;
		Scanner oScanner = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to Mini game");
			System.out.println("1. Do math ax2+bx+c=0");
			System.out.println("2. Build a magic carpet");
			System.out.println("3. Exit");
			System.out.print("What do you want (1,2,3): ");

			// Đọc thông tin người dùng chọn

			iInputValue = oScanner.nextInt();
			while (!Arrays.asList(1, 2, 3).contains(iInputValue)) {
				System.out.print("Wrong input, please try again: ");
				oScanner.next();
			}

			// Xử lý tương ứng với menu được chọn

			switch (iInputValue) {
			case 1:
				BeginQuadratic(oScanner);
				break;
			case 2:
				BuildMagicCarpet(oScanner);
				break;
			case 3:
				oScanner.close();
				System.exit(1);
				break;
			default:
				break;
			}

		}

	}

	/*
	 * Nhập liệu để tính PT bậc 2 PDKIEN: 13/3/2015 *
	 */
	private static void BeginQuadratic(Scanner oScanner) {
		float a = 0, b = 0, c = 0;
		System.out.println("Doing math ax2+bx+c=0");
		System.out.println("Enter a:");
		a = ReadFloadScanner(oScanner);
		System.out.println("Enter b:");
		b = ReadFloadScanner(oScanner);
		System.out.println("Enter c:");
		c = ReadFloadScanner(oScanner);
		MathSolver oSolver = new MathSolver(a, b, c);
		float[] result = oSolver.Solve();
		if (result == null) {
			System.out.println("Equation no solutions");
		} else {
			System.out.println("This problem has x1=" + result[0] + ", x2="
					+ result[1]);
		}
	}

	/*
	 * Đọc dữ liệu nhập vào đến khi nhập đúng float PDKIEN: 13/3/2015
	 */
	private static float ReadFloadScanner(Scanner oScanner) {
		if (oScanner.hasNextFloat()) {

			return oScanner.nextFloat();
		} else {
			oScanner.next();
			return ReadFloadScanner(oScanner);
		}
	}

	/*
	 * Đọc dữ liệu nhập vào đến khi nhập số int dương PDKIEN: 13/3/2015
	 */

	private static int ReadNaturalIntScanner(Scanner oScanner) {
		if (oScanner.hasNextInt()) {
			int v = oScanner.nextInt();
			if (v > 0) {
				return v;

			}
		}
		oScanner.next();
		return ReadNaturalIntScanner(oScanner);
	}

	/*
	 * Nhập liệu và in thảm PDKIEN: 13/3/2015
	 */
	private static void BuildMagicCarpet(Scanner oScanner) {
		int width = 0, height = 0;
		System.out.println("Building magic carpet");
		System.out.println("Enter Width:");
		width = ReadNaturalIntScanner(oScanner);
		System.out.println("Enter Height:");
		height = ReadNaturalIntScanner(oScanner);
		System.out.println("Start building");
		String sCarpet = CarpetBuilder.BuildCarpetString(height, width);
		System.out.println(sCarpet);
	}
}
