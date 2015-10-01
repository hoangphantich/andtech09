import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class sinhvien {
	public int ID;
	public String ten;
	public String lop;
	public String khong;
	public float java;
	public float android;
	
	
	public void nhap()
	{
		
		Scanner input=new Scanner(System.in);
		 System.out.print("nhap ID:");
		 ID=input.nextInt();
		 System.out.print("nhap ten:");
		 ten=input.next();
		 System.out.print("nhap lop:");
		 lop=input.next();
		 System.out.print("nhap diem java:");
		 java=input.nextFloat();
		 System.out.print("nhap diem android:");
		 android=input.nextFloat();	 
	}
	public String xeploai()
	{
		if(tb()>8)
	{
		return "exelent";
	}
		else if(tb()>7)
		{
			return"good";
		}
		else if(tb()<7 &&tb()>5)
		{
			return"ok";
		}
		else if( tb()<5)
		{
			return"weak";
		}
		return khong;
		
		
	}
	public double tb()
	{
		return(java+android)/2;
		
	}
	

	 public void XuatThongTin(){
	    	System.out.println("id: "+ID);
	    	System.out.println("Ten: "+ten);
	    	System.out.println("lop: "+lop);
	    	System.out.println("Diem java: "+java);
	    	System.out.println("Diem android: "+android);
	    	System.out.println("Diem tb: "+tb());
	    	System.out.println("Xep Loai: "+xeploai());
	    }
	public static ArrayList<sinhvien> arrhv = new ArrayList<sinhvien>();

	 public static void them() {
			String key = "Y";
			do {
				sinhvien hv = new sinhvien();
				hv.nhap();
				arrhv.add(hv);
				System.out.println("Ban co muon nhap nua ko(Y/N)?");
				Scanner sc = new Scanner(System.in);
				key = sc.next();
			} while (!key.equalsIgnoreCase("N"));
		}

		public void hien() {
			for (int i = 0; i < arrhv.size(); i++) {
				arrhv.get(i).XuatThongTin();
			}
		}
		public void danhsach() {
			
			
			if (tb() > 8) {
				System.out.println("name\t:" + ten + " id\t: "  + ID + "lop\t "+lop+"diemtrung binh\t:"+tb()+"xep loai\t:" +xeploai());
						
		
			}else
				if (tb()<8 && tb() > 7) {
					System.out.println("name\t:" + ten + " id\t: "  + ID + "lop\t "+lop+"diemtrung binh\t:"+tb()+"xep loai\t:" +xeploai());
							
			
				}else
					if (tb()<7 && tb() < 5) {
						System.out.println("name\t:" + ten + " id\t: "  + ID + "lop\t "+lop+"diemtrung binh\t:"+tb()+"xep loai\t:" +xeploai());
								
				
					}
			if (tb()>5) {
				System.out.println("name\t:" + ten + " id\t: "  + ID + "lop\t "+lop+"diemtrung binh\t:"+tb()+"xep loai\t:" +xeploai());
						
		
			}
		}
		
		public void hiensapxep() {
			for (int i = 0; i < arrhv.size(); i++) {
				arrhv.get(i).danhsach();
			}
		}
}
