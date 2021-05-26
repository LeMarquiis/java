package com.muc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBconnector {
		
	private static String URL="jdbc:mysql://82.65.149.227:3306/java";
	private static String USER_NAME="axel";
	private static String PASSWORD="Boudeau123";
	private Connection con;
	
	public DBconnector() {
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkLogin(String login, String password) {
		
		String sql = "Select * from users where username='" + login + "'" + " and password='" + password +"'"; 
   
        try {
			return con.prepareStatement(sql).executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
        return false;
	}
	
}
