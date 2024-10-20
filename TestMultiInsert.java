package org.krishna.advance.curdOperation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMultiInsert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_intro";
			String user="root";
			String password="root";
			Connection connection=DriverManager.getConnection(url,user,password);
			Statement s=connection.createStatement();
			s.addBatch("INSERT INTO student VALUES(90,'Lily','a','as20')");
			s.addBatch("INSERT INTO student VALUES(91,'Lily','a','as21')");
			s.addBatch("INSERT INTO student VALUES(92,'Lily','a','as22')");
			s.addBatch("INSERT INTO student VALUES(93,'Lily','a','as23')");
			s.addBatch("INSERT INTO student VALUES(94,'Lily','a','as24')");
			int[] res =s.executeBatch();
			s.clearBatch();
			System.out.println(res.length);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}

}
