package com.mondayFinal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;


public class MondayFinalDAO {

	public int joinMemberData(MondayFinalDTO dto) {

		int result = 0;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;

		try {

			//���̵� �̸� ���� �����ּ� �ּ�1 �ּ�2 �ּ�3 ��ȭ��ȣ ����Ʈ �ֹι�ȣ ���Գ�¥
			sql = "{call insertUSERINFO(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, dto.getId());
			cstmt.setString(2, dto.getName());
			cstmt.setString(3, dto.getGender());
			cstmt.setString(4, dto.getZip());
			cstmt.setString(5, dto.getAddr1());
			cstmt.setString(6, dto.getAddr2());
			cstmt.setString(7, dto.getAddr3());
			cstmt.setString(8, dto.getTel());
			cstmt.setInt(9, dto.getPoint());
			cstmt.setString(10, dto.getJumin());
			cstmt.setString(11, dto.getJoindate());
			cstmt.setString(12, dto.getInterest1());
			cstmt.setString(13, dto.getInterest2());
			cstmt.setString(14, dto.getPw());

			result = cstmt.executeUpdate();
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	public boolean idExist(String userid) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from userinfo where userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkId(String id) {
		return id.matches("^[a-zA-Z0-9]{8,15}$");
	}

	public static boolean checkPassword(String password) {
		return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
	}

	public int deleteId(String did) {

		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete sales where userid=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, did);
			
			result = pstmt.executeUpdate();
			
			sql = "delete userinfo where userid=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, did);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;

	}
	
}