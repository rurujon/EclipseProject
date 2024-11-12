package com.pointDB;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monday2.LoginDTO;
import com.util.DBConn;

public class PointDAO {
	
	public int pointHap(LoginDTO logDto){
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		int point = 0;
		
		try {
			//���̵�ã�Ƽ� ����Ʈ���� ������
			sql = "select point ";
			sql+= "from userinfo where userid=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, logDto.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				point = rs.getInt("point");
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return point;
		
	}

}
