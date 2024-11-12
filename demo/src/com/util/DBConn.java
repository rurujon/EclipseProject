package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection dbConn;
	
	public static Connection getConnection() {
		try {
			
			if(dbConn==null) {
				
				String url = "jdbc:oracle:thin:@192.168.16.24:1521:xe";			//thin : 가장 최소한의 방식으로 db에 연결하는 코딩
																				//노트북을 쓴다면 ip를 localhost로 쓰면 된다.
				String user = "monday";
				String pwd = "joa";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbConn = DriverManager.getConnection(url,user,pwd);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dbConn;
	}
	
	public static void close() {
		
		try {
			
			if(dbConn!=null) {
				
				if(!dbConn.isClosed()) {
					dbConn.close();
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		dbConn=null;  //반드시 초기화를 해준다. 안 그럼 재실행시 오류 생긴다.
	}

}
