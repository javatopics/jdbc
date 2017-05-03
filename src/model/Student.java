package model;

public class Student {

	private int studentId;
	private String studentName;
	private String studentGender;
	private String studentDob;
	private int studentGrade;
	
	public Student(){}
	public Student(int id,String name,String g,String dob,int grade){
		this.studentId=id;
		this.studentName=name;
		this.studentGender=g;
		this.studentDob=dob;
		this.studentGrade=grade;
		
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}
	public int getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	
	
}
