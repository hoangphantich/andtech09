package quan_ly_diem_sinh_vien;

public class Student {
	private String name;
	private String id;
	private String class_s;
	private double x1;
	private double x2;
	private double x3;
	private double x4;
	private double x5;
	private double x6;
	private double x7;
	private double point;
	
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClass_s() {
		return class_s;
	}
	public void setClass_s(String class_s) {
		this.class_s = class_s;
	}
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public double getX3() {
		return x3;
	}
	public void setX3(double x3) {
		this.x3 = x3;
	}
	public double getX4() {
		return x4;
	}
	public void setX4(double x4) {
		this.x4 = x4;
	}
	public double getX5() {
		return x5;
	}
	public void setX5(double x5) {
		this.x5 = x5;
	}
	public double getX6() {
		return x6;
	}
	public void setX6(double x6) {
		this.x6 = x6;
	}
	public double getX7() {
		return x7;
	}
	public void setX7(double x7) {
		this.x7 = x7;
	}
	public Student() {
		this("","","",0,0,0,0,0,0,0);
	}
	public Student(String name, String id, String class_s, double x1, double x2, double x3,
			double x4, double x5, double x6, double x7) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = id;
		this.class_s = class_s;
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		this.x6 = x6;
		this.x7 = x7;
	}
	
	public String rank(double point) {
		if(point < 11 && point > 9) {
			return "Exelent";
		}
		else if (point <= 9 && point > 8) {
			return "Good";
		}
		else if (point <= 8 && point > 7) {
			return "Fair";
		}	
		else if (point <= 7 && point > 5) {
			return "OK";
		}
		else if (point <= 5 && point >= 0) {
			return "Weak";
		}
		return null;
	}

}
