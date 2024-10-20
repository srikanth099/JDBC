package org.krishna.advance.studentAPI;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class StudentRepositoryImp implements StudentRepository{

	@Override
	public Connection getConnectionUtil() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_intro";
			String user="root";
			String password="root";
			Connection connection=DriverManager.getConnection(url,user,password);
			System.out.println("connected");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveStudent(Student student) {
		Connection connection =getConnectionUtil();
		String query="INSERT INTO student"+"(id, name, course, email) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,student.getId());
			ps.setString(2,student.getName());
			ps.setString(3, student.getCourse());
			ps.setString(4,student.getEmail());
			int res=ps.executeUpdate();
			connection.close();
			return "no of rows added="+res;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String updateStudentById(Student student) {
		Connection connection =getConnectionUtil();
		String query="UPDATE student SET name=?,course=?,email=?,WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2,student.getCourse());
			ps.setString(3,student.getEmail());
			ps.setInt(4,student.getId());
			int res=ps.executeUpdate();
			connection.close();
			return "no of rows update="+res;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getStudentById(int id) {
		Connection connection =getConnectionUtil();
		Student student=new Student();
		String query="SELECT * FROM student WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				student.setId(res.getInt(1));
				student.setName(res.getString(2));
				student.setCourse(res.getString(3));
				student.setEmail(res.getString(4));
					
			}
			connection.close();
			
			return student;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return "StudentRepositoryImp [getConnectionUtil()=" + getConnectionUtil() + ", getStudentDetails()="
				+ getStudentDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public List<Student> getStudentDetails() {
		List<Student> list=new ArrayList<>();
		Connection connection =getConnectionUtil();

		String query="SELECT * FORM student";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				Student student=new Student();
				student.setId(res.getInt(1));
				student.setName(res.getString(2));
				student.setCourse(res.getString(3));
				student.setEmail(res.getString(4));
				list.add(student);
				
			}
			connection.close();
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String deleteStudentById(int id) {
		
		Connection connection =getConnectionUtil();
		String query="DELETE FROM student WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			int res=ps.executeUpdate();
			connection.close();
			
			return "no of rows deleted = "+res;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}