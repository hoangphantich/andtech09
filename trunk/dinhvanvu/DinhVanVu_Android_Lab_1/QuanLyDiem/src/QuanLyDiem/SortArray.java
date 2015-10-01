package QuanLyDiem;

import java.util.ArrayList;

public class SortArray {
	public static int DISTANCE_SPACE = 15;
	public void ShowArraySort(ArrayList<InfoStudent> _infoSv) {
		System.out
				.println("Name           id             class          average        rank");
		System.out
				.println("-------------------------------------------------------------------");
		for (int i = 0; i < _infoSv.size(); i++) {
			System.out.print("" + _infoSv.get(i).Name + "");
			for (int j = 0; j < (DISTANCE_SPACE - _infoSv.get(i).Name.length()); j++)
				System.out.print(" ");
			System.out.print("" + _infoSv.get(i).idSv + "");
			for (int j = 0; j < (DISTANCE_SPACE - Integer.toString(
					_infoSv.get(i).idSv).length()); j++)
				System.out.print(" ");
			System.out.print("" + _infoSv.get(i).Lop + "");
			for (int j = 0; j < (DISTANCE_SPACE - _infoSv.get(i).Lop.length()); j++)
				System.out.print(" ");
			System.out.printf("%.2f", _infoSv.get(i).average);
			for (int j = 0; j < (DISTANCE_SPACE - 4); j++)
				// vi diem trung binh luon chiem mat 4 ki tu
				System.out.print(" ");
			System.out.println("" + _infoSv.get(i).rank + "");
		}
	}
}
