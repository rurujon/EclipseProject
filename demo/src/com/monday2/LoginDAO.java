package com.monday2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;

public class LoginDAO {
	
	public LoginDTO getLogin(String userid, String userpw) {
		
		LoginDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select userid, userpw ";
			sql+= "from userinfo where userid = ?";
			
			//sql을 preparedStatement로 만든다.
			pstmt = conn.prepareStatement(sql);
			
			//1번째 물음표에 hak을 넣는다.
			pstmt.setString(1, userid);
			
			//preparedStatement를 executeQuery()메소드로 DB에 있는 모든 행을 ResultSet에 담는다.
			rs = pstmt.executeQuery();
			
			//(DB에서 가져온 모든 행=)ResultSet을 한줄씩 읽는다.
			if(rs.next()) {
				
				//학생 객체를 만들고
				dto = new LoginDTO();
				
				//dto객체에 rs한줄을 넣는다 ->그리고 rs다음줄(rs.next())로 가서 한줄을 넣는다.
				dto.setId(rs.getString("userid"));
				dto.setPw(rs.getString("userpw"));
	
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;

		
	}

}
