package org.krishna.advance.connectionTrial;


import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_second","root","root");//accept exception is an sql exception
			System.out.println("CONNECTED");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}

	}

}
