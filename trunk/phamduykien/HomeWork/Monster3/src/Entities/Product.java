package Entities;

import java.util.ArrayList;

/**
 * @author MrSoul2
 *
 */
public class Product {

	/**
	 * Constructor
	 * 
	 * @param productID
	 * @param productName
	 * @param unitPrice
	 */
	public Product(int productID, String productName, int unitPrice) {
		this.ProductID = productID;
		this.ProductName = productName;
		this.UnitPrice = unitPrice;
	}

	public Product() {

	}

	/*
	 * Property
	 */
	public int ProductID;
	public String ProductName;
	public int UnitPrice;

	/**
	 * Sinh data Sample sản phẩm
	 * 
	 * @return Danh sách dataSample sản phẩm PDKIEN 16/3/2015
	 */
	public static ArrayList<Product> GenerateSampleData() {
		ArrayList<Product> result = new ArrayList<Product>();
		result.add(new Product(1, "Plasma TV 32 inches", 1000));
		result.add(new Product(2, "Macbook Pro 18", 1500));
		result.add(new Product(3, "Mitsumi mouse", 5));
		result.add(new Product(4, "Elead PC", 500));
		result.add(new Product(5, "BKAV antivirus", 30));
		return result;
	}
}
