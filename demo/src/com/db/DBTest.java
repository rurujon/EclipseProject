package com.db;

import java.sql.Connection;

import com.util.DBConn;

public class DBTest {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("����Ÿ���̽� ���� ����");
			System.exit(0);
			
		}
		
		System.out.println("����Ÿ���̽� ���� ����");
		System.out.println(conn);
		
		DBConn.close();

	}

}
