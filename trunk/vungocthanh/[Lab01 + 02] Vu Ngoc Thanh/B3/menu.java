package Mua_Hang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class menu {	
    private static Scanner input;

    private void readProductList()
    {
        BufferedReader reader=null;
        try {
                reader=new BufferedReader(new InputStreamReader(new FileInputStream("List_SP.txt")));
                String str;
                do
                {
                        str = reader.readLine();
                        if(str!=null)
                        {
                                String[] list = str.split("-");
                                int id = Integer.parseInt(list[0].trim());
                                String pname = list[1].trim();
                                float price = Float.parseFloat(list[2].trim());
                                Product p = new Product(id,pname,price);
                                ds_Product.ds.add(p);						
                        }
                }
                while(str!=null);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally
        {
                try 
                {
                    if(reader!=null)
                        reader.close();
                }
                catch(Exception e)
                {
                       System.out.println(e.getMessage());
                }

        }
    }

    private static void choiceProduct()
    {
            int choose = 0;
            int sl=0;
            String str = "";
            int n=ds_Product.ds.size();
            for(Product p:ds_Product.ds)
                    str = str+p.getId()+",";
            str = str.substring(0,str.length()-1);
            str = "-> Do you want to buy? <"+str+">:";

            do {
//     
                    System.out.print(str);
                    choose = input.nextInt();
                    if( choose < 1 || choose > n ) {
                            System.out.println("Error!!! Enter 1->"+n);
                    }
                    else {
                            Product p = ds_Product.getProductByID(choose);
                            System.out.print("You buy '" + p.getName() + "', how many item: " );
//                            System.out.print(" How many items: ");
                            sl = input.nextInt();
                            Invoid.addProduct(p,sl);

                            System.out.print("Do you want to buy more<y/n>: ");
                            String c = input.next();
                            if(c.matches("n"))
                                    break;
                    }
            }
            while( choose > 0 && choose < n);
    }

    public static void main(String[] args) {
        int choice = 0;
        new menu().readProductList();
        
        do 
        {
            System.out.println("\nWelcome to media mart eshop:");
            System.out.println("--------------------------------");
            System.out.println("1. Buy products");
            System.out.println("2. Checkout");
            System.out.println("3. Exit");


            System.out.print("Select your choice <1,2,3>:");
            input = new Scanner(System.in);
            choice = input.nextInt();
            
            switch( choice ) 
            {
                case 1: 
                {
//                          
                    ds_Product.printProduct();
                    choiceProduct();
//  
                    break;
                }
                case 2: 
                {
                    Invoid.printInvoid();
                    break;
                }
                case 3: 
                {
                    System.out.print("Bye bye, see you later.");
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println("Error!!! Enter 1,2,3 ");
                }
            }
        }
        while(choice != 3);
    }
}