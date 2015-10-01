import java.util.Scanner;


public class GPT {
	public float a,b,c;
	double x1,x2;
	double deta;
	Scanner in = new Scanner(System.in);
	public void nhap()
	{
		System.out.print("Moi ban nhap phuong trinh bac \n");
		
		System.out.print("nhap a:");
		a =in.nextFloat();
		System.out.print("nhap b:");
		b =in.nextFloat();
		System.out.print("nhap c:");
		c =in.nextFloat();
		
	}
	  public double tinhdelta()
	    {
	        deta=((Math.pow(b, 2))-4*a*c);
	        return deta;
	    }

	  public double motnghiem()
	    {
	        x1=-c/b;
	        return x1;
	    }
	  public double nghiemkep()
	    {
		  x1=-b/(2*a);
	        return x1;
	    }
	  public void hainghiem()
	    {
	        x1=((-b+Math.sqrt(deta))/(2*a));
	        x2=((-b-Math.sqrt(deta))/(2*a));
	        System.out.println("x1= "+x1);
	        System.out.println("x2= "+x2);     
	    }
	  
}
class dieukien
{
	GPT gt=new GPT();
	
	public void nhap()
	{
		gt.nhap();
	}
	public void dieukien()
	{
		if(gt.a==0)
		{
			  if(gt.b==0)
	            {              
	                    System.out.print("phuong trinh vo so nghiem");
	            }
	            else
	            {
	               
	                System.out.print("phuong trinh co nghiem duy nhat: "+gt.motnghiem());          
	            }
		}else
		{
			if(gt.tinhdelta()<0)
			{
				System.out.print("Phuong trinh vo nghiem");
			}
			else{
				if(gt.tinhdelta()==0)
				{
					System.out.print("phuong trinh co 1 nghiem kep:"+gt.nghiemkep());
				}
				else
				{
					System.out.print("Phuong trinh co 2 nghiem:" );
					gt.hainghiem();
				}
			}
		}
		
	}
	
	
	 /* public static void main(String[] args)
		    {
		        dieukien dk=new dieukien();
		        dk.nhap();
		        dk.dieukien();
		    }
	*/
}
