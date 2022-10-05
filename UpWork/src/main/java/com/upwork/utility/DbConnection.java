package com.upwork.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	static Connection connection;
	Statement statement;
	public static Connection openConnection() {
		
		String url="jdbc:mysql://localhost:3306/upworkdb";
		String username="root";
		String password="baba";
		try {
			connection=DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
