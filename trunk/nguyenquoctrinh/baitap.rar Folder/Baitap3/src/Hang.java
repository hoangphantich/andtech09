import java.util.ArrayList;
import java.util.Scanner;


public class Hang {
	public String Ttv,Tm,Tc,Tp,Tb;
	public static int Ftv=1000,Fm=1500,Fc=5,Fp=500,Fb=30;
	public int Itv=1,Im=2,Ic=3,Ip=4,Ib=5;
	public void sanpham()
	{
		System.out.print("Danh sach san pham\n");
		System.out.print("1. TiVi 32:   1000$\n");
		System.out.print("2. Mac:   1500$\n");
		System.out.print("3. Chuot:  5$\n");
		System.out.print("4. Pc:   500$\n");
		System.out.print("5. BA:   30$\n");
		
		
	}
	
	public static ArrayList<Hang> a=new ArrayList<Hang>();
	
	 public static void chon() {
			String key = "Y";
			do {
				Hang hv = new Hang();
				hv.chonsanpham();
			
				a.add(hv);
				System.out.println("Ban co muon mua  nua ko (Y/N)?");
				Scanner sc = new Scanner(System.in);
				key = sc.next();
			} while (!key.equalsIgnoreCase("N"));
		}
	 
	 public static void chonsanpham()
	 {
		 
		 int chon =0;
		 int dem=0;
			do{
			
				 Scanner ins =new Scanner(System.in);
				 System.out.print("Hay chon ban muon muacac so sau <1,2,3,4,5> Không mua chon chon 6 \n");
				 
				
				 chon=ins.nextInt();
				 switch(chon){
				 case 1:
					 System.out.print("TiVi\t"+Ftv+"\n");
					
				
					 break;
				 case 2:
					 System.out.print("Mac pc\t"+Fm+"\n");
					 
					 break;
				 case 3:
					 System.out.print("mm\t "+ Fc+"\n");
					 
					 break;
				 case 4:
					 System.out.print("pc\t"+Fp +"\n");
					 
					 break;
				 case 5:
					 System.out.print("BK"+Fb+"\n");
					 
					 break;
					 
				 }
			} while (chon!=6);;
		 
		 
	 }
	 
	 public static void danhsach(){
		 
		 
	 }
	 
	
}
