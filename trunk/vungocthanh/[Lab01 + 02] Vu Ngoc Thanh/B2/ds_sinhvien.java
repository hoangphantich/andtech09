package quan_ly_diem_sinh_vien;

import java.util.ArrayList;
import java.util.Scanner;

public class ds_sinhvien {
	ArrayList<Student> ds;
	private Scanner input;
	
	public ds_sinhvien() {
		ds = new ArrayList<Student>();
	}
	
	public void them(Student sv) {
		ds.add(sv);
	}
	
	public static boolean checkPoint(double point) throws Exception 
    { 
        try 
        { 
            //kiem tra diem, diem phai tu 0 den 10
            if(point >= 0 && point <= 10) 
            { 
                return true; 
            } 
            else 
            { 
                return false; 
            } 
        } 
        catch(Exception ex) 
        { 
            throw ex; 
        } 
    } 
	
	
	public void themlap() throws Exception
	{
			Student sv = null;
			System.out.println("Student " + (ds.size()+1) +":\n");
			input = new Scanner(System.in);
			String name;
			String id;
			String class_s;
			double x1,x2,x3,x4,x5,x6,x7;
			
			try {
				System.out.print("Name: ");
				name = input.nextLine();
				System.out.print("id: ");
				id = input.nextLine();
				System.out.print("class: ");
				class_s = input.nextLine();
				do {
					System.out.print("basic java (0->10): ");
					x1 = input.nextDouble();
				}
				while(!checkPoint(x1));
				do {
					System.out.print("advance java (0->10): ");
					x2 = input.nextDouble();
				}
				while(!checkPoint(x2));
				do {
					System.out.print("c# (0->10): ");
					x3 = input.nextDouble();
				}
				while(!checkPoint(x3));
				do {
					System.out.print("advance c# (0->10): ");
					x4 = input.nextDouble();
				}
				while(!checkPoint(x4));
				do {
					System.out.print("rdbms (0->10): ");
					x5 = input.nextDouble();
				}
				while(!checkPoint(x5));
				do {
					System.out.print("sql 2008 (0->10): ");
					x6 = input.nextDouble();
				}
				while(!checkPoint(x6));
				
			}
			catch(Exception ex) 
	        { 
	            throw ex; 
	        } 
			
			x7 = (double) (x1+x2+x3+x4+x5+x6)/6;
			sv = new Student(name, id, class_s, x1, x2, x3, x4, x5, x6, x7);
			System.out.println(" -> " + sv.getName() + " ( id = " + sv.getId() + 
					" ) has average mark of " + sv.getX7() + " , " + sv.rank(x7) + "\n");
			them(sv);
	}
	public void print() {
		int i;
		for(i=0;i<ds.size();i++) {
			System.out.println("Name \t ID \t Class \t Average \t\t Rank");
			System.out.printf(ds.get(i).getName() + "  \t" + ds.get(i).getId() + "  \t" + ds.get(i).getClass_s() + "  \t" + ds.get(i).getX7() + "  \t" + ds.get(i).rank(ds.get(i).getX7()));
		}
	}
	
}
