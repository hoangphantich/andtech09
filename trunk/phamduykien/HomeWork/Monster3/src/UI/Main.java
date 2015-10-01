package UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Entities.Invoice;
import Entities.Product;

/**
 * @author MrSoul2
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Menu
		Scanner scanner = new Scanner(System.in);
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		while (true) {

			System.out.println("Welcome to Tran Anh eshop");
			System.out.println("----------------------------------------");
			System.out.println("1- Buy products");
			System.out.println("2- Checkout");
			System.out.println("3- Exit");
			System.out.println("Select your choice <1,2,3>:");
			int selectedMenu = ReadIntScanner(scanner, Arrays.asList(1, 2, 3));
			switch (selectedMenu) {
			case 1:
				invoices.addAll(BuyProduct(scanner));
				break;
			case 2:
				CheckOut(scanner, invoices);
				break;
			case 3:
				System.out.println("Bye bye, see you later!");
				System.exit(1);
				break;
			}
		}

	}

	private static void CheckOut(Scanner scanner, ArrayList<Invoice> invoices) {
		int netAmount = 0;
		float totalAmount = 0;
		System.out.println("Here your invoice");
		String leftAlignFormat = "%-30s %-4d %-20d %-4d %-20d %n";
		String leftAlignFormat2 = "%-30s %-4s %-20s %-4s %-20s %n";
		System.out.format(leftAlignFormat2, "Name", "ID", "UnitPrice",
				"Quantity", "Total");
		System.out
				.format("--------------------------------------------------------------------%n");
		for (Invoice invoice : invoices) {
			netAmount += invoice.Amount;
			System.out.format(leftAlignFormat, invoice.ProductName,
					invoice.ProductID, invoice.UnitPrice, invoice.Quantity,
					invoice.Amount);
		}

		System.out
				.format("--------------------------------------------------------------------%n");
		totalAmount = netAmount * Invoice.VATRate / 100;

	}

	/**
	 * Lập danh sách hàng hóa mua
	 * 
	 * @param scanner
	 * @return PDKIEN 16/3/2015
	 */
	private static ArrayList<Invoice> BuyProduct(Scanner scanner) {
		System.out.println("Our products:");
		int idToBuy = 0;
		ArrayList<Product> lst = Product.GenerateSampleData();
		List<Integer> lstID = new ArrayList<Integer>();
		List<String> lstIDString = new ArrayList<String>();
		Map<Integer, Product> maps = new HashMap<Integer, Product>();
		for (Product product : lst) {
			maps.put(product.ProductID, product);
			lstID.add(product.ProductID);
			lstIDString.add(String.valueOf(product.ProductID));
			System.out.format("%1d- %-30s $%-30s%n", product.ProductID,
					product.ProductName, product.UnitPrice);
		}
		ArrayList<Invoice> result = new ArrayList<Invoice>();
		boolean flag = true;
		while (flag) {
			System.out.println("-> Do you want to buy? " + "<"
					+ String.join(",", lstIDString) + ">");
			idToBuy = ReadIntScanner(scanner, lstID);
			Product itemToBuy = maps.get(idToBuy);
			System.out.println("You buy '" + itemToBuy.ProductName
					+ "', how many item: ");
			int numberToBuy = ReadIntScanner(scanner, null);

			Invoice inv = new Invoice();
			inv.ProductID = itemToBuy.ProductID;
			inv.ProductName = itemToBuy.ProductName;
			inv.Quantity = numberToBuy;
			inv.UnitPrice = itemToBuy.UnitPrice;
			inv.CanculateAmount();
			result.add(inv);
			System.out.println("Do you want to buy more? <y/n>");
			String answer = scanner.next();
			if (answer.equals("n")) {
				flag = false;
			}
		}

		return result;
	}

	/**
	 * Đệ quy đọc value int, performance tồi
	 * 
	 * @param scanner
	 * @param arrCondition
	 * @return
	 */
	private static int ReadIntScanner(Scanner scanner,
			List<Integer> arrCondition) {

		if (scanner.hasNextInt()) {
			int v = scanner.nextInt();
			if (arrCondition == null || arrCondition.contains(v)) {
				return v;
			}
		}
		scanner.next();
		return ReadIntScanner(scanner, arrCondition);
	}

}
