import java.util.ArrayList;
import java.util.List;

import connection.PGConnection;
import model.Student;

public class JDBCDemo {

	public static void main(String[] args) {
		PGConnection conn=new PGConnection();
		//conn.getConnection();
		
		//insert data
		/*List list=new ArrayList<>();
		list.add("mey mey");
		list.add("female");
		list.add("12/12/1995");
		list.add(11);
		conn.CreateStudent(list);*/
		
		//update data
		/*List list=new ArrayList<>();
		list.add("yung yung");
		list.add("female");
		list.add("12/12/1995");
		list.add(12);
		conn.editStudent(8, list);*/
		
		
		//get all students
		//conn.getStudents();
		
		List<Student> list =conn.getStudentLists();
		
		
		//System.out.println();
		list.forEach((Student stu)->{
			System.out.print(stu.getStudentId()+"\t");
			System.out.print(stu.getStudentName()+"\t");
			System.out.print(stu.getStudentGender()+"\t");
			System.out.print(stu.getStudentDob()+"\t");
			System.out.print(stu.getStudentGrade()+"\t");
			System.out.println();
		});
		
		/*for(Student stu : list){
			System.out.print(stu.getStudentId()+"\t");
			System.out.print(stu.getStudentName()+"\t");
			System.out.print(stu.getStudentGender()+"\t");
			System.out.print(stu.getStudentDob()+"\t");
			System.out.print(stu.getStudentGrade()+"\t");
			System.out.println();
		}*/
	}
}
