package com.example.demo8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-176-34-215-248.eu-west-1.compute.amazonaws.com" +"/delu1t92658u0";
	private static final String DB_USER = "zaiaryvqbpwwcb";	
	private static final String DB_PASSWORD = "731fafeb016f84ea7f87300cbd19a24ba3e96adbaaf92504bc8d945d0302489b";

	public static Connection getConnection() {
		try {
			try {
				//1. Load driver
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//2. Create connection
			//(database name,db username,db password)
			con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD); 
		}catch(SQLException e) {
			System.out.println(e);
		}
		return con;
		
	}

}
