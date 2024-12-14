package com.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
	private Connection conn = null;
	
	
	public GuestDAO (Connection conn) {
		this.conn=conn;
	}
	
	//삭제, getList, 페이징을 위한 getReadData
	
	public int getMaxNum() {
		int maxNum=0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select nvl(max(num), 0) from guest";
			
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		}
			return maxNum;
	}
	
	public int insertData(GuestDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql;
		
		try {
			sql = "insert into guest ";
			sql+= "(num, name, email, homepage, content, ipaddr, created) ";
			sql+="values(?,?,?,?,?,?,sysdate)";
			
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHomepage());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getIpAddr());
			//pstmt.setString(7, dto.getCreated());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		}
		
		return result;
	}
	
	public int getDataCount() {
		int totalDataCount =0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql="select nvl(count(*), 0 ) from guest ";
			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				totalDataCount=rs.getInt(1);
			}
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		}
		return totalDataCount;
	}
	
	public List<GuestDTO> getLists(){
		List<GuestDTO> lists = new ArrayList<GuestDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			//sql="select * from( ";
			//sql+="select rownum rnum, data.* from( ";
			//sql+="select num,email,homepage, content ";
			//sql+="to_char(created, 'YYYY-MM-DD') created ";
			//sql+="from guest order by num desc) data) " ;
			//sql+="where rnum>=? and rnum<=? ";
			
			sql="select num,name, email, homepage, content, ipaddr, ";
			sql+="to_char(created, 'YYYY-MM-DD') created from guest ";
			sql+="order by num desc";
			
			pstmt=conn.prepareStatement(sql);
			
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO dto = new GuestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setContent(rs.getString("content"));
				dto.setIpAddr(rs.getString("ipaddr"));
				dto.setCreated(rs.getNString("created"));
				
				lists.add(dto);
			}
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public int deleteData(int num) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql="delete from guest where num=?";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		}
		return result;
	}
}
