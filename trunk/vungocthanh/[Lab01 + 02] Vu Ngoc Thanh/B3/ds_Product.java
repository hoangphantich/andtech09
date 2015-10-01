package Mua_Hang;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ds_Product {
	public static ArrayList<Product> ds = new ArrayList<>();	
	
	public static Product getProductByID(int id)
	{
		for (Product p : ds) 
		{
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	public static void printProduct() {
//		int i;
		System.out.println("Our product: ");
                DecimalFormat df = new DecimalFormat("0");
		for (Product product : ds) { 
			System.out.println(product.getId()+"- "+product.getName()+"\t"+df.format(product.getPrice())+"$");	
		}
//		for( i = 0 ; i < ds.size() ; i++ ) {
//			System.out.printf("%d %.10s %.5s \n",ds.get(i).getId(),ds.get(i).getName(),ds.get(i).getPrice());
//		}
	}
	
}
