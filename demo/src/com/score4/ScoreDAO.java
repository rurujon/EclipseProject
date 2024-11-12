package com.score4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.util.DBConn;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class ScoreDAO {	//데이터베이스에 연결하는 쿼리를 가지는 클래스를 DAO라고 명명한다.
						//Data Access Object(SQL 쿼리)
	
	public int insertData(ScoreDTO dto) {
		
		//DB Insert 메서드
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			sql = "{call insertscore(?,?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getHak());
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());
			
			//이걸로 5개의 데이터를 풀로 채운 insert 데이터가 들어가있다.
			
			result = cstmt.executeUpdate();
			
			cstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
	}
	
	public int updateData(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			sql="{call updateScore(?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			
			
			result = cstmt.executeUpdate();
			
			cstmt.close();
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int deleteData(String hak) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			sql="delete score where hak=?";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, hak);
			
			result=cstmt.executeUpdate();
			
			cstmt.close();
			
			
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
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call selectAllScore(?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
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
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public ScoreDTO getSearchHak(String hak){
		
		ScoreDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call selectHakScore(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in 파라미터
			cstmt.setString(2,hak);
			
			//프로시저 실행
			cstmt.executeQuery();
			
			//out파라미터의 값을 받아냄
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
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
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	public List<ScoreDTO> getSearchName(String name){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call salectNameScore(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.setString(2, name);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
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
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}

}
