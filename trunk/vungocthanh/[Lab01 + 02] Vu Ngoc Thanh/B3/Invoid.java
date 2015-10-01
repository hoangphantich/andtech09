package Mua_Hang;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.*;

public class Invoid {
    static ArrayList<Product> hd = new ArrayList<>();
    static List<Integer> hd_sl = new ArrayList<>();
	private static Scanner scan;

    public static void addProduct(Product p, int quantity)
    {
        boolean flag=false;

        for(int i=0;i<hd.size();i++)
        {
                Product p1 = hd.get(i);
                if(p1!=null)
                {
                        if(p1.getId()==p.getId())
                        {
                                hd_sl.set(i,hd_sl.get(i)+quantity);
                                flag=true;
                                break;
                        }
                }	
        }
        if(flag==false)
        {
                hd.add(p);
                hd_sl.add(quantity);
        }
    }
    
    private static void printInvoidToFile(String name,float total)
    {
       	BufferedWriter writer = null;
        DecimalFormat df = new DecimalFormat("0");
        Calendar cal = Calendar.getInstance();
        String fileName=name+"_"+cal.get(Calendar.YEAR)+(cal.get(Calendar.MONTH)+1)+cal.get(Calendar.DATE)+
                        "_"+cal.get(Calendar.HOUR_OF_DAY)+cal.get(Calendar.MINUTE)+
                        cal.get(Calendar.SECOND)+".txt";
		
        try {
                System.out.println(cal.get(Calendar.YEAR));
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
                writer.write("Hear are your invoid");
                for(int i=0;i<Invoid.hd.size();i++)
                {
                    Product p=Invoid.hd.get(i);
                    int sl = Invoid.hd_sl.get(i);
                    writer.write(p.getId()+" "+p.getName()+" "+df.format(p.getPrice())+"$ "+sl+" "+df.format(p.getPrice()*sl)+"$");
                    writer.newLine();
                }
                writer.write("Net "+ df.format(total)+"\n");    
                writer.write("Vat(10%) "+ df.format(total*0.1)+"\n");    
                writer.write("Total "+ df.format(total*1.1)+"\n");

        } catch (IOException e) {
                System.out.println(e.getMessage());
        }
    }

    public static void printInvoid()
    {
        String name="";
        scan = new Scanner(System.in);

            System.out.println("Hear are your invoid");
            System.out.println("ID\tName\t\t\tUnit Price\tQuantity\tPrice");
            float total = 0;
            DecimalFormat df = new DecimalFormat("0");
            
            for(int i=0;i<Invoid.hd.size();i++)
            {
                Product p=Invoid.hd.get(i);
                int sl = Invoid.hd_sl.get(i);
                System.out.println(p.getId()+"       "+p.getName()+"            "+df.format(p.getPrice())+"$             "+sl+"            "+df.format(p.getPrice()*sl)+"$");
                total+=sl*p.getPrice();
            }
            System.out.println("Net " + df.format(total));    
            System.out.println("Vat(10%) " + df.format(total*0.1));    
            System.out.println("Total " + df.format(total*1.1));    
            System.out.print("Your name: ");
            name = scan.nextLine();
            System.out.println("Thank " + name + ". Waiting for our invoice. ... Done.");
            
            printInvoidToFile(name,total);
    }
}
