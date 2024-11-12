package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection dbConn;
	
	public static Connection getConnection() {
		try {
			
			if(dbConn==null) {
				
				String url = "jdbc:oracle:thin:@192.168.16.24:1521:xe";			//thin : ���� �ּ����� ������� db�� �����ϴ� �ڵ�
																				//��Ʈ���� ���ٸ� ip�� localhost�� ���� �ȴ�.
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
		
		dbConn=null;  //�ݵ�� �ʱ�ȭ�� ���ش�. �� �׷� ������ ���� �����.
	}

}
