/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmaster01;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class giaiptvstham {

    public static int nhap() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            System.out.print(" ");
            try {
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so! hay nhap lai...");
                input.nextLine();
            }
        }
        return (n);
    }
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int x1, x2;
        double delta = b * b - 4 * a * c;
        System.out.println("Nhap a :");
        a = nhap();
        System.out.println("Nhap b :");
        b = nhap();
        System.out.println("Nhap c :");
        c = nhap();
        if (delta > 0) {
            System.out.println("Phuong trinh co 2 nghiem :");
            x1 = (int) ((-b - Math.sqrt(delta)) / 2 * a);
            x2 = (int) ((-b + Math.sqrt(delta)) / 2 * a);
            System.out.println("pt co 2 nghiem" + x1 + ";" + x2);
        }
        if (delta == 0) {
            System.out.println("Phuong trinh co 1 nghiem");
            x1 = (int) ((-b) / 2 * a);
            System.out.println("pt co 1 nghiem :" + x1);
        }
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem");
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("******************");
        }
        System.out.println("--------------------------------------");
        
    }
  

}
