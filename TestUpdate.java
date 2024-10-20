package org.krishna.advance.dynamicCURDOperation;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_intro";
			String user="root";
			String pass="root";
			Connection connection =DriverManager.getConnection(url,user,pass);
			String query="UPDATE  student SET name=? WHERE id=?";
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, "Raman gupta");
			ps.setInt(2,101);
			int res=ps.executeUpdate();
			System.out.println(res);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	}
