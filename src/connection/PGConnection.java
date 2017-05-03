package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class PGConnection {

	
	private final String URL="jdbc:postgresql://localhost:5000/SCHOOL_MGT_DB";
	
	public Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(URL,"postgres","123");
			System.out.println("connection is success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public boolean CreateStudent(List stu){
		
		Statement stm=null;
		Connection conn=null;
		int row=0;
		String sql="insert into tbl_student(student_name,student_gender,student_dob,student_grade)"
				+"VALUES (\'"+stu.get(0)+"\',\'"+stu.get(1)+"\',\'"+stu.get(2)+"\',\'"+stu.get(3)+"\');";
		try {
			conn=this.getConnection();
			stm=conn.createStatement();
			row=stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if(row>0) return true;
		else return false;
	}
	
	public boolean editStudent(int id,List list){
		Connection conn=null;
		Statement stm=null;
		int row=0;
		String sql="UPDATE tbl_student SET student_name= \'"+list.get(0)+"\' , "
				+ "student_gender= \'"+list.get(1)+"\', "
				+ "student_dob=\'"+list.get(2)+"\',"
				+ "student_grade=\'"+list.get(3)+"\'  "
				+ "WHERE student_id=\'"+id +"\';";
		
		try{
			conn=this.getConnection();
			stm=conn.createStatement();
			row=stm.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(row>0) return true;
		else return false;
	}
	
	public void getStudents(){
		Connection conn=null;
		Statement stm=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM tbl_student";
		
		try{
			conn=this.getConnection();
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("student Name: "+rs.getString("student_name")+
						" Student Gender : " +rs.getString("student_gender")+
						" Student dob :" +rs.getString("student_dob")+
						" Student grade :"+rs.getInt("student_grade"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Student> getStudentLists(){
		Connection conn=null;
		Statement stm=null;
		ResultSet rs=null;
		List<Student> list=new ArrayList<Student>();
		String sql="SELECT * FROM tbl_student";
		
		try{
			conn=this.getConnection();
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			
			while(rs.next()){
				list.add(new Student(rs.getInt("student_id"),
						rs.getString("student_name"),
						rs.getString("student_gender"),
						rs.getString("student_dob"),
						rs.getInt("student_grade")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
