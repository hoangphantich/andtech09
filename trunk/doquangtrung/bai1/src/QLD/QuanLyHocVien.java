package QLD;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class QuanLyHocVien {

	private static ArrayList<HocVien> arrhv = new ArrayList<HocVien>();

	public void nhap() {

		String key = "Y";

		do {
			HocVien hv = new HocVien();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhap ten: ");
			String name = scanner.nextLine();
			hv.setName(name);

			System.out.println("Nhap lop: ");
			String classroom = scanner.nextLine();
			hv.setClassroom(classroom);

			System.out.println("Nhap ID: ");
			int id = scanner.nextInt();
			hv.setId(id);

			System.out.println("Nhap diem Basic Java: ");
			float basicjava = scanner.nextFloat();
			hv.setBasicjava(basicjava);

			System.out.println("Nhap diem Advance Java");
			float advancejava = scanner.nextFloat();
			hv.setAdvancejava(advancejava);

			System.out.println("Nhap diem C#: ");
			float csharp = scanner.nextFloat();
			hv.setCsharp(csharp);

			System.out.println("Nhap diem Advance C#: ");
			float advancecsharp = scanner.nextFloat();
			hv.setAdvancecsharp(advancecsharp);

			System.out.println("Nhap diem RDBMS: ");
			float rdbms = scanner.nextFloat();
			hv.setRdbms(rdbms);

			System.out.println("Nhap diem SQL: ");
			float sql = scanner.nextFloat();
			hv.setSql(sql);

			float average = (basicjava + advancejava + csharp + advancecsharp
					+ rdbms + sql) / 6;
			hv.setAverage(average);
			String rank;
			if (average > 9) {
				rank = "Exelent";
			} else if (average <= 9 && average > 8) {
				rank = "Good";
			} else if (average <= 8 && average > 7) {
				rank = "Fair";
			} else if (average <= 7 && average > 5) {
				rank = "Ok";
			} else {
				rank = "Weak";
			}
			hv.setRank(rank);
			arrhv.add(hv);
			System.out.println(name + " " + "id: " + id + " "
					+ "has average mark of" + " " + average + " " + rank);
			System.out.println("Ban co muon nhap nua ko?(Y/N)");
			key = scanner.next();
		} while (!key.equalsIgnoreCase("N"));
	}

	public void sapxep() {
		Collections.sort(arrhv, new Comparator<HocVien>() {
			public int compare(HocVien hv1, HocVien hv2){
				if(hv1.getAverage() < hv2.getAverage()){
					return 1;
				}else {
					if(hv1.getAverage() == hv2.getAverage()){
						return 0;
					}else {
						return -1;
					}
				}
			}
		});
		System.out.println("Name \tID \tClass \tAverage \tRank");
		System.out.println("==============================================");
		for (int i = 0; i < arrhv.size(); i++) {
			System.out.println(arrhv.get(i).getName()+ "\t" + arrhv.get(i).getId() + "\t" + arrhv.get(i).getClassroom() + "\t" + arrhv.get(i).getAverage() + "   \t    "+ arrhv.get(i).getRank());
		}
	}
}
