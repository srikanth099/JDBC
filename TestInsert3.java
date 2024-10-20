package org.krishna.advance.insertClass;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert3 {

   public static void main(String[] args) {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/jdbc_intro"+"?user=root&password=root";
			Connection connection=DriverManager.getConnection(url);
			System.out.println("CONNECTED");
			Statement statement=connection.createStatement();
			String sql="INSERT INTO student (id, name, course, email)"
					+"VALUES"
					+"(2,'teja','animation','lee61@gmail.com')";
			int res=statement.executeUpdate(sql);
			System.out.println("no.of rows got updated="+res);
			connection.close();                                                                  
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
   	}
}
