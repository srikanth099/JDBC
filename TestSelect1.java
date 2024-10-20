package org.krishna.advance.curdOperation;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestSelect1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_intro";
			FileInputStream file=new FileInputStream("jdbcinfo.properties");
			Properties properties=new Properties();
			properties.load(file);
			
			Connection connection=DriverManager.getConnection(url,properties);
			Statement statement=connection.createStatement();
			String query="SELECT * FROM student";
			boolean res=statement.execute(query);
			System.out.println(res);
			ResultSet resultSet=statement.getResultSet();
			System.out.println(resultSet);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
			connection.close();
		}
		catch(SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			}
		}
			
	}
