package com.javabase.dao;

import java.util.HashMap;
import java.util.Scanner;

public class Student {
	/** Ten sv	*/
	private String name = null;
	/** Mssv	*/
	private String id	= null;
	/** Ds mon hoc	*/
	private HashMap<String, Discipline> mapMH = null;
	/** Ten lop 	*/
	private String className = null;
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setClassName (String className) {
		this.className = className;
	}
	
	public String getClassName () {
		return this.className;
	}
	
	public void setID (String id) {
		this.id = id;
	}
	
	public String getID () {
		return this.id;
	}
	
	public void addDiscipline (Discipline mh) {
		if (this.mapMH == null) {
			mapMH = new HashMap<String, Discipline>();
		}
		System.out.println("Code = " + mh.getCode());
		mapMH.put(mh.getCode(), mh);
	}
	
	public HashMap<String, Discipline> getMHs () {
		return mapMH;
	}
	
	
	public float getPoint (String code) {
		if (mapMH == null || !mapMH.containsKey(code)) {
			return 0;
		}
		
		return mapMH.get(code).getPoint();
	}
	
	public void setPoint (String code, float point) {
		if (mapMH == null || !mapMH.containsKey(code)) {
			return;
		}
		
		mapMH.get(code).setPoint(point);
	}
	
	public void build () {
		System.out.print ("Enter discipline number: ");
		int ans = 0;
		Scanner scanner = new Scanner (System.in);
		do {
			ans = scanner.nextInt();
			if (ans <= 0) {
				System.out.println();
				System.out.print("Wrong input. Key number again:");
			}
		} while (ans <= 0);
		
		// New line
		System.out.println();	
		scanner.nextLine();
		for (int i = 1; i <= ans; i++) {
			Discipline mh = new Discipline();
			System.out.format("-Enter discipline code %d :", i);
			mh.setCode(scanner.nextLine());scanner.nextLine();
			System.out.println();
			System.out.format("-Enter discipline name %d :", i);
			mh.setName(scanner.next());scanner.nextLine();
			System.out.println();
			System.out.format("-Enter discipline point[0-10] %d :", i);
			mh.setPoint(enterPoin());
			// Add a discipline
			addDiscipline(mh);
		}
	}
	
	private float enterPoin() {
		float ans = 0;
		
		Scanner scanner = new Scanner(System.in);
		do {
			ans = scanner.nextFloat();
			if (ans < 0 || ans >10) {
				System.out.print("Wrong input. Key number again [0=10]: ");
			}
		} while (ans <0 || ans >10);
		
		scanner.nextLine();
		return ans;
	}
	
	public double getAverage () {
		if (mapMH == null) {
			return 0;
		}
		
		double ret_val = 0;
		
		for (String key : mapMH.keySet()) {
			Discipline mh = mapMH.get(key);
			ret_val += mh.getPoint();
		}
		ret_val = (ret_val*1.0) /mapMH.size();
		
		return ret_val;
	}
	
	public String getRank() {
		double average = getAverage();
		String rank = "";
		if (average >=9) {
			rank = "excelent";
		} else if (average >= 8) {
			rank = "good";
		} else if (average >= 7) {
			rank = "fair";
		} else {
			rank = "weak";
		}
		
		return rank;
	}
}
