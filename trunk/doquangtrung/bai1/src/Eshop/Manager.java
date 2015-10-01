package Eshop;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	Scanner sc = new Scanner(System.in);
	String pd1 = "Plasma TV 32 inches";
	String pd2 = "Macbook Pro 18";
	String pd3 = "Misumi mouse";
	String pd4 = "Elead PC";
	String pd5 = "Bkav antivirus";

	int q1 = 1000;
	int q2 = 1500;
	int q3 = 5;
	int q4 = 500;
	int q5 = 30;

	public void buyProducts() {
		String key = "Y";
		do {
			Products pd = new Products();
			System.out.println("Out products:");
			System.out.println("1 - " + pd1 + " 1000$");
			System.out.println("2 - " + pd2 + " 1500$");
			System.out.println("3 - " + pd3 + " 5$");
			System.out.println("4 - " + pd4 + " 500$");
			System.out.println("5 - " + pd5 + " 30$");
			System.out.println("\tDo you want to buy? <1, 2, 3, 4, 5>");
			addProducts();
			key = sc.next();
		} while (!key.equalsIgnoreCase("N"));
		Payment pm = new Payment();
		pm.main(null);

	}

	static ArrayList<Products> listProducts = new ArrayList<Products>();

	public void addProducts() {
		int n;
		n = sc.nextInt();
		Products pd = new Products();
		int quantity = 0;
		int price = 0;
		pd.setPrice(price);
		String nameProducts = null;
		if (n == 1) {
			pd.setId(1);
			pd.setNameProducts(pd1);
			pd.setPrice(q1);
		} else if (n == 2) {
			pd.setId(2);
			pd.setNameProducts(pd2);
			pd.setPrice(q2);
		} else if (n == 3) {
			pd.setId(3);
			pd.setNameProducts(pd3);
			pd.setPrice(q3);
		} else if (n == 4) {
			pd.setId(4);
			pd.setNameProducts(pd4);
			pd.setPrice(q4);
		} else if (n == 5) {
			pd.setId(5);
			pd.setNameProducts(pd5);
			pd.setPrice(q5);
		} else {
			System.out.println("Ma hang sai: ");
		}
		System.out.println("You by " + pd.getNameProducts()
				+ ", how many item:");
		quantity = sc.nextInt();
		pd.setQuantity(quantity);
		listProducts.add(pd);
		System.out.println("\tDo you want by more!(Y/N)");
		int total = pd.getPrice() * pd.getPrice();
		pd.setTotal(total);

	}

	public void hien() {
		System.out.println("Name" + "\t" + "id" + "\t" + "price"
				+ "\t" + "quantity" + "\t" + "total");
		System.out
				.println("----------------------------------------------------------------------");
		for (int i = 0; i < listProducts.size(); i++) {
			System.out.println(listProducts.get(i).getNameProducts()
					+ "\t" + listProducts.get(i).getId() + "\t"
					+ listProducts.get(i).getPrice() + "\t"
					+ listProducts.get(i).getQuantity() + "\t"
					+ listProducts.get(i).getTotal() + "$");
		}

	}

	public void epBill() throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("bill.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos);
		BufferedWriter bf = new BufferedWriter(oos);
		bf.write("Name" + "\t" + "id" + "\t" + "price" + "\t"
				+ "quantity" + "\t" + "total");
		bf.write("\n");
		bf.write("----------------------------------------------------------------------");
		for (int i = 0; i < listProducts.size(); i++) {
			bf.write(listProducts.get(i).getNameProducts() + "\t"
					+ listProducts.get(i).getId() + "\t"
					+ listProducts.get(i).getPrice() + "\t"
					+ listProducts.get(i).getQuantity() + "\t"
					+ listProducts.get(i).getTotal() + "$");
		}
		fos.close();
		oos.close();
	}

}
