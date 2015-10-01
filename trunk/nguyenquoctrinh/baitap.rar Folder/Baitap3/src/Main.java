import java.util.Scanner;


public class Main {

	
	/**
	 * @param agrs
	 */
	public static void main(String[] agrs){
		
		
		
		int chon =0;
		do{
			System.out.print("1-Mua san pham\n");
			System.out.print("2-Check san pham\n");
			System.out.print("3-thoát\n");
			 Scanner in =new Scanner(System.in);
			 System.out.print("Hay chon cac so sau <1,2,3> \n");
			 chon=in.nextInt();
			 switch(chon){
			 case 1:

				Hang h=new Hang();
				h.sanpham();
				 h.chon();
				
				 break;
			 case 2:
				 Hang h1=new Hang();
				 
				 break;
			 case 3:
				 System.exit(0);
				 break;
				 
			 }
	
			
			
			
		}while(chon!=6);
		
	}
	
	
	
}
