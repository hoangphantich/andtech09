

import java.util.Scanner;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args)
	
	
	{int chon =0 ;
	
		
	 do {
		 System.out.print("1. nhap \n");
		 System.out.print("2. danh sach\n");
		 System.out.print("3. thoats\n");
		 
		 Scanner in =new Scanner(System.in);
		 System.out.print("Hay chon cac so sau \n");
		 chon=in.nextInt();
		 sinhvien sv=new sinhvien();
		
		  switch(chon)
		     {
		  case 1:sv.them();
		  		sv.hien();
		  		
		  			
			 
		  case 2:
			  sv.hiensapxep();
              break;
		   
		     
		  case 3:
			  System.exit(0);
			  break;
		     }
	} while (chon!=4);
	}

	
}

