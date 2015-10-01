package QuanLyDiem;

import java.util.Scanner;

public class MenuQuanLyDiem {
	static StudentManager sm = null;
	static Scanner input = new Scanner(System.in);
	private static String answer = "y";
public static void main(String args[]){
	sm = new StudentManager();
	boolean loop = true;
	do{
		System.out.println("Well come to Techmaster Manager");
		System.out.println("---------------------------------------");
		System.out.println("1. Record Student information");
		System.out.println("2. Display sorted list");
		System.out.println("3. Exit");
		System.out.println("Select your choice <1,2,3>");
		int choose = input.nextInt();
		switch(choose){
		case 1:
			do{
				displayStudent();
			}while(answer.compareTo("y")==0);
			break;
		case 2:
			sm.display();
			break;
		case 3:
			System.out.println("Bye bye.See you later");
			loop = false;
			break;
		}
}while(loop);
}
private static String displayStudent() {
sm.addRecord();
input.nextLine();
System.out.print("Do you want to add a new record?(y/n)");
answer = input.nextLine();
	return answer;
	
}
}