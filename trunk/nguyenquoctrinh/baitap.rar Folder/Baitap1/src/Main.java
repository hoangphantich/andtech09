import java.util.Scanner;


public class Main {
	Det det=new Det();
	GPT gpt=new GPT();
	
	public static void main(String[] args)
	
	
	{int chon =0 ;
	
		
	 do {
		 System.out.print("1. Chon 1 giai pt b2 \n");
		 System.out.print("2. Chon det vai\n");
		 System.out.print("3. thoats\n");
		 
		 Scanner in =new Scanner(System.in);
		 System.out.print("Hay chon cac so sau \n");
		 chon=in.nextInt();
		
		  switch(chon)
		     {
		  case 1:
			  GPT gt=new GPT();
                 dieukien dk=new dieukien();
 		        dk.nhap();
 		        dk.dieukien();
                 break;
		  case 2:
			Det dt= new Det();
			dt.Vai();
		      
              break;
		   
		     
		  case 3:
			  System.exit(0);
			  break;
		     }
	} while (chon!=4);
	}

	
}

