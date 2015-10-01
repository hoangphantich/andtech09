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
class SV {

	String ten;
	int id;
	int diemtb;
	String Class;
	int javabasic;
	int javaadvance;
	int c;
	int advancec;
	int rdbms;
	int sql2008;

	int tinhTongDiem()// method
	{
		diemtb = (javabasic + javaadvance + c + advancec + rdbms + sql2008)/6;
		return diemtb;
	}
	String rank()
	{
		String a = "exelent";
		String b = "good";
		String c = "fair";
		String d = "weak";
		if (tinhTongDiem() >9) {
			return a;
		} else if (tinhTongDiem() >8) {
			return b;
		} else if (tinhTongDiem() > 7) {
			return c;
		}else {
			return d;
		}
		
	}

	void nhap() {
		Scanner input = new Scanner(System.in);
		System.out.print("ten: ");
		ten = input.nextLine();
		System.out.print("Class: ");
		Class = input.nextLine();
		System.out.print("Nhap id: ");
		id = input.nextInt();
		System.out.print("Diem Java Basic: ");
		javabasic = input.nextInt();
		System.out.print("Diem Java Advance: ");
		javaadvance = input.nextInt();
		System.out.print("Diem C: ");
		c = input.nextInt();
		System.out.print("Diem Advance C: ");
		advancec = input.nextInt();
		System.out.print("Diem Rdbms: ");
		rdbms = input.nextInt();
		System.out.print("Diem SQL 2008: ");
		sql2008 = input.nextInt();
	}

	void hienThi() {
		System.out.print("Tên" + "\t" + "ID" + "\t" + "Lớp" + "\t" + "Điểm Trung Bình" + "\n");
		System.out.println("----------------------------------------");
		System.out.print(ten + "\t" + id + "\t" + Class + "\t" + tinhTongDiem() + "\n");
	}
}
