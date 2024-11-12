package com.mondayFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConn;


public class InfoUpdateDAO {
	
	public int updateInfo(InfoUpdateDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update userinfo set addr1=?,addr2=?,addr3=?,zip=?,tel=?,interest1=?,interest2=? where userid=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAddr1());
			pstmt.setString(2, dto.getAddr2());
			pstmt.setString(3, dto.getAddr3());
			pstmt.setString(4, dto.getZip());
			pstmt.setString(5, dto.getTel());
			pstmt.setString(6, dto.getInterest1());
			pstmt.setString(7, dto.getInterest2());
			pstmt.setString(8, dto.getId());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}

}
