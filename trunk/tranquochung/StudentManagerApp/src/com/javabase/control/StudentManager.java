package com.javabase.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.javabase.dao.*;

public class StudentManager {
	public static List<Student> lstStudents = new ArrayList<Student>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void newRecord () {
		Student student = new Student ();
		// Enter name
		System.out.println();
		System.out.println("Enter name: ");
		student.setName(scanner.nextLine());
		//scanner.nextLine();
		// Enter id
		System.out.println("Enter identifier:");
		student.setID(scanner.nextLine());
		//scanner.nextLine();
		// Enter class
		System.out.println ("Enter class: ");
		student.setClassName(scanner.nextLine());
		//scanner.nextLine();
		// Build discipline ...
		student.build();
		
		lstStudents.add(student);
	}
	
	public static void printIt() {
		System.out.println();
		System.out.println("List student :");
		// format : 5-10-20-10-10
		System.out.println("+-----+----------+--------------------+----------+----------+");
		System.out.println("| stt |   code   |      name          |  average |   rank   |");
		System.out.println("+-----+----------+--------------------+----------+----------+");
		int stt = 1;
		
		// Sort 
		Collections.sort(lstStudents, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int compare = 0;
				if  (o1.getAverage() >= o2.getAverage()) {
					compare = -1;
				} else {
					compare = 1;
				}
				
				return compare;
			}
		});
		
		Iterator <Student> iterator = lstStudents.iterator();
		while (iterator.hasNext()) {
			Student std = iterator.next();
			System.out.format("|%5s|%10s|%20s|%10s|%10s|", stt++, std.getID(), std.getName(), std.getAverage(), std.getRank());
			System.out.println();
		}
		
		if (lstStudents.size() > 0) {
			System.out.println("+-----+----------+--------------------+----------+----------+");
		}
		
	}
	
	public static void displayById (String id) {
		
	}

	public static void findIt() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Enter a student code: ");
		String code = scanner.nextLine();
		
		for (Student std : lstStudents) {
			if (std.getID().equals(code)) {
				System.out.println("Student Information:");
				// format : 5-10-20-20-10
				System.out.println("+-----+----------+--------------------+--------------------+----------+");
				System.out.println("| stt |   code   |      name          |      discipline    |   point  |");
				System.out.println("+-----+----------+--------------------+--------------------+----------+");
				int stt = 1;
				
				for (String key : std.getMHs().keySet()) {
					Discipline mh = std.getMHs().get(key);
					System.out.format("|%5d|%10s|%20s|%20s|%10s|", stt++, std.getID(), std.getName(), mh.getName(), mh.getPoint());
					System.out.println();
				}
				
				System.out.println("+-----+----------+--------------------+--------------------+----------+");
				break;
			}
		}
	}
}
