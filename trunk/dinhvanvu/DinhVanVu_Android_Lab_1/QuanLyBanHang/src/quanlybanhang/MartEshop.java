package quanlybanhang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

public class MartEshop {
	private static Scanner scanner;
	public static int DISTANCE_SPACE = 40;
	public static int DISTANCE_NAME = 25;
	public static int DISTANCE_SPACE_INVOICE = 15;

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<>();
		AddListProduct(products);
		System.out.printf("1- Buy products\n");
		System.out.printf("2- Checkout.\n");
		System.out.printf("3- Exit");
		do {
			System.out.printf("\nSelect your choice <1,2,3>:");
			try {
				scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Our product:");
					ShowProduct(products);
					do {
						try {
							System.out
									.printf("-> Do you want to buy? <1,2,3,4,5,6>:");
							int chooseProduct = scanner.nextInt();
							if (chooseProduct < 1 || chooseProduct > 5) {
								break;
							} else {
								System.out
										.printf("you buy '"
												+ products.get(
														chooseProduct - 1)
														.getName()
												+ "',how many item:");
								int number = scanner.nextInt();
								System.out
										.printf("Do you want to buy more<y/n>");
								String yesno = scanner.next();
								if (yesno.equals("y")) {
									products.get(chooseProduct - 1).setAmount(
											number);
								} else {
									break;
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
							break;
						}
					} while (true);
					System.out.printf("\n");
					System.out.printf("Welcome to media mart eshop\n");
					System.out
							.printf("---------------------------------------");
					break;
				case 2: {
					System.out.println("Here are your invoice");
					ShowInvoice(products);
					for (int i = 0; i < products.size(); i++) {
						products.get(i).setAmount(0);
					}
					break;
				}
				case 3:
					System.out.printf("Bye bye,see you later.\n");
					System.exit(0);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception

			}
		} while (true);
	}

	public static void AddListProduct(ArrayList<Product> _Products) {
		_Products.add(new Product(1, "Plasma TV 32 inches", 1000, 0));
		_Products.add(new Product(2, "Macbook Pro 18", 1500, 0));
		_Products.add(new Product(3, "Mitsumi mouse", 5, 0));
		_Products.add(new Product(4, "Elead PC", 500, 0));
		_Products.add(new Product(5, "Bkav antivirus", 30, 0));
	}

	public static void ShowProduct(ArrayList<Product> products) {
		for (int i = 0; i < products.size(); i++) {
			System.out.print("" + products.get(i).getID() + "- "
					+ products.get(i).getName() + "");
			for (int j = 0; j < (DISTANCE_SPACE
					- products.get(i).getName().length() - 3); j++)
				System.out.print(" ");
			System.out.print("" + products.get(i).getMoney() + "");
			System.out.println("$");
		}
		System.out.print("" + 6 + "- Exit");
		for (int j = 0; j < (DISTANCE_SPACE - 7); j++)
			System.out.print(" ");
		System.out.println("\n");
	}

	public static void ShowInvoice(ArrayList<Product> products) {
		String contentBill = "";
		contentBill += "Name                     id             unit price     quantity       total\n";
		contentBill += "-----------------------------------------------------------------------------------------------\n";
		int totalProduct = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getAmount() == 0)
				continue;
			contentBill += "" + products.get(i).getName() + "";
			for (int j = 0; j < (DISTANCE_NAME - products.get(i).getName()
					.length()); j++)
				contentBill += " ";
			contentBill += "" + products.get(i).getID() + "";
			for (int j = 0; j < (DISTANCE_SPACE_INVOICE - Integer.toString(
					products.get(i).getID()).length()); j++)
				contentBill += " ";
			contentBill += "" + products.get(i).getMoney() + "";
			for (int j = 0; j < (DISTANCE_SPACE_INVOICE - Integer.toString(
					products.get(i).getMoney()).length()); j++)
				contentBill += " ";
			contentBill += "" + products.get(i).getAmount() + "";
			for (int j = 0; j < (DISTANCE_SPACE_INVOICE - Integer.toString(
					products.get(i).getAmount()).length()); j++)
				contentBill += " ";
			int total = products.get(i).getAmount()
					* products.get(i).getMoney();
			contentBill += "" + total + "";
			for (int j = 0; j < (DISTANCE_SPACE_INVOICE - Integer.toString(
					total).length()); j++)
				contentBill += " ";
			contentBill += "\n";
			totalProduct += total;
		}
		if (totalProduct == 0)
			return;
		contentBill += "-----------------------------------------------------------------------------------------------\n";
		contentBill += "Net                                                                   "
				+ totalProduct + "\n";
		contentBill += "VAT(10%)                                                              "
				+ totalProduct * 0.1 + "\n";
		contentBill += "Total                                                                 "
				+ (totalProduct + totalProduct * 0.1) + "\n";
		System.out.println("Your name:");
		contentBill += "Your name:";
		String name = scanner.next();
		contentBill += "Thank " + name + ".Waiting for our invoice. ... Done.";
		System.out.println(contentBill);
		PrintBill(name, contentBill);
	}

	public static void PrintBill(String customer, String contentBill) {
		BufferedWriter writer = null;
		try {
			// create a temporary file
			String timeLog = customer
					+ "_"
					+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar
							.getInstance().getTime()) + ".txt";
			File logFile = new File(timeLog);

			// This will output the full path where the file will be written
			// to...
			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write(contentBill);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}
	}
}
