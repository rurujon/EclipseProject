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
			//���̵�ã��
			sql = "select userid, username ";
			sql+= "from userinfo where username=? and tel=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			
			rs = pstmt.executeQuery();
			
			//(DB���� ������ ��� ��=)ResultSet�� ���پ� �д´�.
			if(rs.next()) {
				
				//�л� ��ü�� �����
				dto = new SearchDTO();
				
				//dto��ü�� rs������ �ִ´� ->�׸��� rs������(rs.next())�� ���� ������ �ִ´�.
				dto.setId(rs.getString("userid"));
				dto.setName(rs.getString("username"));

			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//����Ʈ�� ��ȯ�ؾ� �� �޼��带 ����ϴ� Score�� �޼��忡�� List�� �ޱ� ����
		return dto;
		
	}
	
	public SearchDTO getSearchPw(String id, String name, String jumin){
		
		SearchDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			//��й�ȣ ã��
			sql = "select userid, username ";
			sql+= "from userinfo where userid=? and username=? and jumin=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, jumin);
			
			rs = pstmt.executeQuery();
			
			//(DB���� ������ ��� ��=)ResultSet�� ���پ� �д´�.
			if(rs.next()) {
				
				//�л� ��ü�� �����
				dto = new SearchDTO();
				
				//dto��ü�� rs������ �ִ´� ->�׸��� rs������(rs.next())�� ���� ������ �ִ´�.
				dto.setId(rs.getString("userid"));
				dto.setName(rs.getString("username"));

			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//����Ʈ�� ��ȯ�ؾ� �� �޼��带 ����ϴ� Score�� �޼��忡�� List�� �ޱ� ����
		return dto;
		
	}
	
	public void getInPw(String id, String pw){
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			//��й�ȣ ã��
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