package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			
			String url = "jdbc:oracle:thin:@192.168.16.24:1521:xe";
			String user = "suzi";
			String pwd = "a123";
			
			if(conn==null) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conn = DriverManager.getConnection(url, user, pwd);
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		return conn;
		
	}
	
	public static void close() {
		
		if(conn==null) {
			return;
		}
		
		try {
			
			if(!conn.isClosed()) {
				conn.close();
				
			}
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		conn=null;
		
		
	}

}
