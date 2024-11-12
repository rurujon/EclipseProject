package com.db;


import java.sql.Connection;
import java.sql.Statement;

import com.util.DBConn;

//DB 연결 실행
//1. Drivermanager가 Connection을 생성
//2. Connection이 Statement를 생성
//3. Statement가 Query를 실행


//Statement : sql 구문을 실행하는 인터페이스
//Statement, PreparedStatement, CallableStatement
public class Test1 {

	public static void main(String[] args) {
		try {
			//1.
			Connection conn = DBConn.getConnection();
			
			if(conn==null) {
				System.out.println("데이타베이스 연결 실패");
				System.exit(0);
			}		
			
			//2.
			Statement stmt = conn.createStatement(); //sql이 없다     
			int result;
			String sql;
			
			/* INSERT
			sql = "insert into score(hak,name,kor,eng,mat) ";   //한 칸을 무조건 띄워준다. 그렇지 않으면 붙은 것으로 처리한다.
			sql+= "values ('222','전소민',40,80,90)";     //+를 반드시 써 준다.
			
			//System.out.println(sql);
			
			//3. Statement가 query를 실행
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("추가 성공!");
			}
			*/
			/* update
			sql = "update score set name='배수지',kor=100,eng=100,";
			sql+= "mat=100 where hak=111";
			
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("수정 성공!");
			}
			*/
			
			sql = "delete score where hak=111";
			
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("삭제 성공!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		DBConn.close();

	}

}
