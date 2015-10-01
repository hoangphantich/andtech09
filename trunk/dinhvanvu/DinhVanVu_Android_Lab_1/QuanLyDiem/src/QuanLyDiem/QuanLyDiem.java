package QuanLyDiem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyDiem {
	public static String EXELENT = "Exelent";
	public static String GOOD = "Good";
	public static String FAIR = "Fair";
	public static String OK = "OK";
	public static String WEAK = "Weak";
	private static Scanner scanner;
/*
 ** Create by Vudv - 2015-3-16
 ** Chương trình lưu thông tin sinh viên 
 ** và sắp xếp thông tin sinh viên theo tự từ cao xuống thấp 
 */
	public static void main(String[] args) {
		ArrayList<InfoStudent> _students = new ArrayList<>();
		System.out.printf("1- Record Students information\n");
		System.out.printf("2- Display sorted list.\n");
		System.out.printf("3- Exit");
		do {
			System.out.printf("\nSelect your choice <1,2,3>:");
			try {
				scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: // Nhập thông tin sinh viên
					InfoStudent _info = new InfoStudent();
					System.out.printf("Student 1:\n");
					System.out.printf("--- name: ");
					_info.Name = scanner.next();
					System.out.printf("--- id: ");
					_info.idSv = scanner.nextInt();
					for (int i = 0; i < _students.size(); i++) {
						if (_students.get(i).idSv == _info.idSv) {
							System.out
									.printf("ID cua sinh vien nay da ton tai\n");
							break;
						}
					}
					System.out.printf("--- class: ");
					_info.Lop = scanner.next();
					System.out.printf("--- basic java: ");
					_info.basicJava = scanner.nextInt();
					System.out.printf("--- advance java: ");
					_info.advanceJava = scanner.nextInt();
					System.out.printf("--- c#: ");
					_info.cSharp = scanner.nextInt();
					System.out.printf("--- advance c#: ");
					_info.advancecSharp = scanner.nextInt();
					System.out.printf("--- rdbms: ");
					_info.rdBms = scanner.nextInt();
					System.out.printf("--- sql 2008: ");
					_info.sql2008 = scanner.nextInt();
					_info.average = (float)(_info.basicJava + _info.advanceJava
							+ _info.cSharp + _info.advancecSharp + _info.rdBms + _info.sql2008) / 6;
					if (_info.average > 9) {
						_info.rank = EXELENT;
					} else if (_info.average > 8) {
						_info.rank = GOOD;
					} else if (_info.average > 7) {
						_info.rank = FAIR;
					} else if (_info.average > 5) {
						_info.rank = OK;
					} else {
						_info.rank = WEAK;
					}
					_students.add(_info);
					System.out.printf("- > " + _info.Name + " (id="
							+ _info.idSv + ")" + " has average mark of "
							+ "%.2f,rank " + "'" + _info.rank + "'.\n",
							_info.average);
					break;
				case 2: { // Sắp xếp danh sách sinh viên
					do {
						System.out.printf("1- Show Array:\n");
						System.out.printf("2- Bubble Sort:\n");
						System.out.printf("3- Insertion Sort:\n");
						System.out.printf("4- Util Collections Sort:\n");
						System.out.printf("5- Exit:\n");
						System.out
								.printf("Select your choice sort <1,2,3,4,5>:");
						int choseSort = scanner.nextInt();
						Boolean exits = false;
						switch (choseSort) {
						case 1://Mảng thông tin sinh viên ban đầu
							SortArray sortArray = new SortArray();
							sortArray.ShowArraySort(_students);
							break;
						case 2://Mảng thông tin sinh viên được sắp xếp với giải thuật sắp xếp nổi bọt
							BubbleSort bubbleSort = new BubbleSort(_students);
							bubbleSort.ShowArraySort(bubbleSort._InfoStudents);
							break;
						case 3://Mảng thông tin sinh viên được sắp xếp với giải thuật sắp xếp chèn
							InsertionSort insertionSort = new InsertionSort(
									_students);
							insertionSort
									.ShowArraySort(insertionSort._InfoStudents);
							break;
						case 4: // Mảng thông tin được sắp xếp với collection sort trong java
							ArrayList<InfoStudent> infoStudents = new ArrayList<InfoStudent>();
							infoStudents.addAll(_students);
							Collections.sort(infoStudents,new CollectionSort());
							SortArray sortArray2 = new SortArray();
							sortArray2.ShowArraySort(infoStudents);
							break;
						case 5: //Exit
							exits = true;
							break;
						default:
							exits = true;
							break;
						}
						if (exits)
							break;
					} while (true);
					break;
				}
				case 3: // Exit
					System.out.printf("Bye bye,see you later.\n");
					System.exit(0);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception

			}
		} while (true);
	}
}
