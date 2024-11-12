package com.db;

import java.sql.Connection;

import com.util.DBConn;

public class DBTest {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("데이타베이스 연결 실패");
			System.exit(0);
			
		}
		
		System.out.println("데이타베이스 연결 성공");
		System.out.println(conn);
		
		DBConn.close();

	}

}
