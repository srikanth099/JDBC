package org.krishna.advance.insertClass;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class TestInsert4 {

	public static void main(String[] args) {
		Driver driver;
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fis=new FileInputStream("mydbinfo.properties");
			Properties properties=new Properties();
			properties.load(fis);
			String url="jdbc:mysql://localhost:3306/jdbc_intro";
			Connection connection =DriverManager.getConnection(url,properties);
			System.out.println("connected");
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
	}
}
//resources 1.fileinputstream
//2.connection
