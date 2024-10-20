package org.krishna.advance.CURDoperation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection =DriverManager.getConnection
				("jdbc:mysql://localhost:3306/jdbc_intro"
		+ "?user=root&password=root");){
			System.out.println("connected");
			Statement statement=connection.createStatement();
			String query="UPDATE student SET name='poojitha' WHERE "
			+"name='madhavi'";
			int res=statement.executeUpdate(query);
			System.out.println("no of rows update="+res);
//			Driver driver=new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

//try with resource block
