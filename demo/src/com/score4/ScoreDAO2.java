package com.score4;

//백업용

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.util.DBConn;

public class ScoreDAO2 {	//데이터베이스에 연결하는 쿼리를 가지는 클래스를 DAO라고 명명한다.
						//Data Access Object(SQL 쿼리)
	
	public int insertData(ScoreDTO dto) {
		
		//DB Insert 메서드
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into score (hak,name,kor,eng,mat) ";
			sql+="values (?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			//이걸로 5개의 데이터를 풀로 채운 insert 데이터가 들어가있다.
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
	}
	
	public int updateData(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql="update score set kor=?,eng=?,mat=? ";
			sql+="where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int deleteData(String hak) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql="delete score where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hak);
			
			result=pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		return result;
		
	}
	
	//전체 출력은 list에 dto 데이터를 담는다.
	//list 째로 옮겨 풀어내고 조립한다.
	
	public List<ScoreDTO> getList(){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select hak,name,kor,eng,mat, ";
			sql+="(kor+eng+mat) tot, (kor+eng+mat)/3 ave, ";
			sql+="rank() over (order by (kor+eng+mat) desc) rank ";
			sql+="from score";
			
			pstmt = conn.prepareStatement(sql);	//select는 결과를 db값으로 반환한다.
			
			rs = pstmt.executeQuery();  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString(2));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt(4));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt(6));
				dto.setAve(rs.getInt("ave"));
				dto.setRank(rs.getInt(8));
				
				lists.add(dto);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public ScoreDTO getSearchHak(String hak){
		
		ScoreDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select hak,name,kor,eng,mat, ";
			sql+="(kor+eng+mat) tot, (kor+eng+mat)/3 ave ";
			sql+="from score where hak=?";
			
			pstmt = conn.prepareStatement(sql);	//select는 결과를 db값으로 반환한다.
			
			pstmt.setString(1, hak);
			
			rs = pstmt.executeQuery();  		//그렇기에 ResultSet을 사용한다.
			
			if(rs.next()) { 		//rs에 데이터가 있는 동안
				
				dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	public List<ScoreDTO> getSearchName(String name){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select hak,name,kor,eng,mat, ";
			sql+="(kor+eng+mat) tot, (kor+eng+mat)/3 ave ";
			sql+="from score where name like ?";
			
			pstmt = conn.prepareStatement(sql);	//select는 결과를 db값으로 반환한다.
			
			pstmt.setString(1, name+"%");
			
			rs = pstmt.executeQuery();  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				
				lists.add(dto);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}

}
