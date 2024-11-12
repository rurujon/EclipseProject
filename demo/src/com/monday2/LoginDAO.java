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
			
			//sql�� preparedStatement�� �����.
			pstmt = conn.prepareStatement(sql);
			
			//1��° ����ǥ�� hak�� �ִ´�.
			pstmt.setString(1, userid);
			
			//preparedStatement�� executeQuery()�޼ҵ�� DB�� �ִ� ��� ���� ResultSet�� ��´�.
			rs = pstmt.executeQuery();
			
			//(DB���� ������ ��� ��=)ResultSet�� ���پ� �д´�.
			if(rs.next()) {
				
				//�л� ��ü�� �����
				dto = new LoginDTO();
				
				//dto��ü�� rs������ �ִ´� ->�׸��� rs������(rs.next())�� ���� ������ �ִ´�.
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
