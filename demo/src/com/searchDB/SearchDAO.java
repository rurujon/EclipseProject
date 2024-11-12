package com.searchDB;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;

public class SearchDAO {
	
	public SearchDTO getSearchId(String name, String tel){
		
		SearchDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			//아이디찾기
			sql = "select userid, username ";
			sql+= "from userinfo where username=? and tel=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			
			rs = pstmt.executeQuery();
			
			//(DB에서 가져온 모든 행=)ResultSet을 한줄씩 읽는다.
			if(rs.next()) {
				
				//학생 객체를 만들고
				dto = new SearchDTO();
				
				//dto객체에 rs한줄을 넣는다 ->그리고 rs다음줄(rs.next())로 가서 한줄을 넣는다.
				dto.setId(rs.getString("userid"));
				dto.setName(rs.getString("username"));

			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//리스트를 반환해야 이 메서드를 사용하는 Score의 메서드에서 List로 받기 가능
		return dto;
		
	}
	
	public SearchDTO getSearchPw(String id, String name, String jumin){
		
		SearchDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			//비밀번호 찾기
			sql = "select userid, username ";
			sql+= "from userinfo where userid=? and username=? and jumin=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, jumin);
			
			rs = pstmt.executeQuery();
			
			//(DB에서 가져온 모든 행=)ResultSet을 한줄씩 읽는다.
			if(rs.next()) {
				
				//학생 객체를 만들고
				dto = new SearchDTO();
				
				//dto객체에 rs한줄을 넣는다 ->그리고 rs다음줄(rs.next())로 가서 한줄을 넣는다.
				dto.setId(rs.getString("userid"));
				dto.setName(rs.getString("username"));

			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//리스트를 반환해야 이 메서드를 사용하는 Score의 메서드에서 List로 받기 가능
		return dto;
		
	}
	
	public void getInPw(String id, String pw){
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			//비밀번호 찾기
			//UPDATE PERSONNEL SET DNO=30 WHERE PNO=1111;
			sql = "update userinfo set userpw=? where userid=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			
			pstmt.executeQuery();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
}