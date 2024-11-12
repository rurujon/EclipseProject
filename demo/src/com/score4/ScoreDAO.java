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

public class ScoreDAO {	//�����ͺ��̽��� �����ϴ� ������ ������ Ŭ������ DAO��� ����Ѵ�.
						//Data Access Object(SQL ����)
	
	public int insertData(ScoreDTO dto) {
		
		//DB Insert �޼���
		
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
			
			//�̰ɷ� 5���� �����͸� Ǯ�� ä�� insert �����Ͱ� ���ִ�.
			
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
	
	//��ü ����� list�� dto �����͸� ��´�.
	//list °�� �Ű� Ǯ��� �����Ѵ�.
	
	public List<ScoreDTO> getList(){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call selectAllScore(?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
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
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in �Ķ����
			cstmt.setString(2,hak);
			
			//���ν��� ����
			cstmt.executeQuery();
			
			//out�Ķ������ ���� �޾Ƴ�
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			if(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
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
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.setString(2, name);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
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
