package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.score.ScoreDTO;



public class NaverDAO {
	
	private Connection conn;
	
	public NaverDAO(Connection conn) {
		
		this.conn=conn;
	}
	
	
	public int insertData(NaverDTO dto) {
		
		int result=0;
		
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			
			sql="insert into naver (id,pwd,email,name,birth,telecom,gender,nation,tel) ";
			sql+="values(?,?,?,?,?,?,?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getTelecom());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getNation());
			pstmt.setString(9, dto.getTel());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public List<NaverDTO> getLists(){
		
		List<NaverDTO> lists = new ArrayList<NaverDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select id,pwd,email,name,birth,telecom,gender,nation,tel from naver";
			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				NaverDTO dto = new NaverDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setTelecom(rs.getString("telecom"));
				dto.setGender(rs.getString("gender"));
				dto.setNation(rs.getString("nation"));
				dto.setTel(rs.getString("tel"));
				
				lists.add(dto);
				
				
			}
			
			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public NaverDTO getReadData(String id) {
		
		NaverDTO dto = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select id,pwd,email,name,birth,telecom,gender,nation,tel from naver ";
			sql+="where id=?";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new NaverDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setTelecom(rs.getString("telecom"));
				dto.setGender(rs.getString("gender"));
				dto.setNation(rs.getString("nation"));
				dto.setTel(rs.getString("tel"));
			}
			
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	public int updateData(NaverDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			
			sql="update naver set pwd=?,email=?,tel=? ";
			sql+="where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getId());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.toString());
			
		}
		
		return result;
	}
	
	public int deleteData(String id) {
		
		int result = 0;
		
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			
			sql="delete naver where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.toString());
		}
		
		return result;
	}

}