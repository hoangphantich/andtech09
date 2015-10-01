/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1;

import java.util.Scanner;

/**
 *
 * @author hanhkd
 */
public class ClassDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SV[] arrSV = new SV[1000];
        int dem = 0;
        Scanner input = new Scanner(System.in);
        int chon = 0;
        while (chon != 4) {
            System.out.print("\n1.Nhap sinh vien");
            System.out.print("\n2.Danh sach sinh vien");
            System.out.print("\n3.DS SV theo tong diem tang dan");
            System.out.print("\n4. Thoat");
            System.out.print("\n---------------------------------");
            System.out.print("\nChon: ");
            chon = input.nextInt();
            switch (chon) {
                case 1:
                    SV obj = new SV();
                    obj.nhap();
                    //nem vao mang
                    arrSV[dem] = obj;
                    dem++;
                    break;
                case 2:
                    for(int i=0;i<dem;i++)
                        arrSV[i].hienThi();
                    break;
                case 3:
                    //1. copy sv ra mang tam(de do mat du lieu goc)
                    SV[] arrTam = new SV[1000];
                    for(int i=0;i<dem;i++)
                        arrTam[i] = arrSV[i];
                    //2. Sap xep tren  mang tam
                    for(int i=0;i<dem;i++)
                        for(int j=i+1;j<dem;j++)
                            //neu tong diem cua thang j < tong diem cua thang i
                        
                            if(arrTam[j].tinhTongDiem()<arrTam[i].tinhTongDiem())
                            {
                                SV tam = arrTam[i];
                                arrTam[i] = arrTam[j];
                                arrTam[j] = tam;
                            }
                       
                    //3. In ra mang tam
                    for(int i=0;i<dem;i++)
                        arrTam[i].hienThi();
                    break;
                case 4:
                    System.out.print("Cam on! Thank you");
                    break;
                default:
                    System.out.print("Xin vui long nhap lai ");
                    break;
            }
        }
        
        
    }
}
