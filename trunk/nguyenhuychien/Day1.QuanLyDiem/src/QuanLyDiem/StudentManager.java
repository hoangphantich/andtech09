package QuanLyDiem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManager {
private static ArrayList<Student> ListStudent = new ArrayList<Student>();
	public void addRecord() {
		Scanner input = new Scanner(System.in);
		Student student = new Student();
		
		System.out.println("Enter name");
		String name = input.nextLine();
		student.setName(name);
		
		System.out.println("Enter Id");
		int id = input.nextInt();
		student.setId(id);
		input.nextLine();
		
		System.out.println("Enter class");
		String classroom = input.nextLine();
		student.setClassroom(classroom);
		
		System.out.println("Enter basic java");
		int basicjava = input.nextInt();
		student.setBasicjava(basicjava);
		
		System.out.println("Enter Advance java");
		int advancejava = input.nextInt();
		student.setAdvancejava(advancejava);
		
		System.out.println("Enter Cshape");
		int cshape = input.nextInt();
		student.setCshape(cshape);
		
		System.out.println("Advane cshape");
		int advancecshape = input.nextInt();
		student.setAdvancecshape(advancecshape);
		
		System.out.println("Enter Rdbms");
		int rdbms = input.nextInt();
		student.setRdbms(rdbms);
		
		System.out.println("Enter Sql 2008");
		int sql = input.nextInt();
		student.setSql(sql);
		
		double average = (basicjava+advancejava+cshape+advancecshape+rdbms+sql)/6;
		student.setAverage(average);
		String rank = null;
		if(average >=9){
			rank = "excelent";
		}
		else if(8<=average&&average<9){
			rank = "good";
		}else if (7<=average&&average<8){
			rank = "fair";
		}else if(5<=average&&average<7){
			rank = "ok";
		}
			else{
				rank = "weak";
			}
		student.setRank(rank);	
		ListStudent.add(student);
System.out.println("->"+name +"(id"+id+") has average mark of "+average + ",rank \'"+rank+"\'");
	}
	
		
	

	public void display() {
Iterator <Student> iterator = ListStudent.iterator();
System.out.println("name\t\tid\t\tclass\t\taverage\t\trank");
System.out.println("---------------------------------------------------------------------------------------");
while(iterator.hasNext()){
	Student student = iterator.next();
	System.out.println(student.getName()+"\t\t"+student.getId()+"\t\t"+student.getClassroom()+"\t\t"+student.getAverage()+"\t\t"+student.getRank());
}
}
	}


