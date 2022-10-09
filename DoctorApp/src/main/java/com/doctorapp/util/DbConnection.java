package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	static Connection connection;
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/doctordb";
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
