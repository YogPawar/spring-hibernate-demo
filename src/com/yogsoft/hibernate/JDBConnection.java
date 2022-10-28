package com.yogsoft.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/udemy?useSSL=false";
		String passwrod = "root";
		String username = "root";
		try {
			Connection con = DriverManager.getConnection(url, username, passwrod);
			System.out.println("Connection successful!!!");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}
