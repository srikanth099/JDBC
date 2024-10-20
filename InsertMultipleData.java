package org.krishna.advance.dynamicCURDOperation;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMultipleData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_intro";
			String user="root";
			String pass="root";
			Connection connection =DriverManager.getConnection(url,user,pass);
			String query="INSERT INTO student VALUES (?,?,?,?)";
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1,105);
			ps.setString(2, "chinni");
			ps.setString(3, "MVC");
			ps.setString(4, "chinni@2gmail.com");
			ps.addBatch();
			ps.setInt(1,106);
			ps.setString(2, "raju");
			ps.setString(3, "MVC");
			ps.setString(4, "raju@2gmail.com");
			ps.addBatch();
			ps.setInt(1,107);
			ps.setString(2, "legin");
			ps.setString(3, "MVC");
			ps.setString(4, "legin@2gmail.com");
			ps.addBatch();
			ps.setInt(1,108);
			ps.setString(2, "anu");
			ps.setString(3, "MVC");
			ps.setString(4, "anu@2gmail.com");
			ps.addBatch();
			int [] res=ps.executeBatch();
			System.out.println(res.length);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	}
