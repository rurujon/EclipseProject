package com.monday2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;


public class GradeDAO {
	
	//구매이력 검색
	public boolean existCheck(LoginDTO logDto, SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();				//평범한 db 연결 과정.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		String productName = null;
		
		boolean exist = false;
		
		try {
			
			//입력받은 productno로 매칭되는 productname을 product 테이블에서 검색.
			//아예 sales에도 productno 컬럼을 추가해놨으면 훨씬 편했겠지만 이미 입력한 데이터가 많고 foreign key도 신경써야하니 그냥 따로 검색작업을 수행.
			
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//번호에 매칭되는 productname 지정.
			}
			
			
			//userid 일치, productname 일치, 평점 란이 null인 데이터가 sales 테이블에 있는지 확인.
			sql = "select * from sales where userid = ? and productname = ? and grade is null";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, logDto.getId());
			pstmt.setString(2, productName);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {					//있다면, 존재여부는 true ;
				exist = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return exist;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//sales 테이블에 평점 등록
	public int gradeInput(SalesDTO saleDto,LoginDTO logDto) {
		
		Connection conn = DBConn.getConnection();		//평범한 DB 연결 과정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		String productName = null;
		
		try {
			
			//입력받은 productno로 매칭되는 productname을 product 테이블에서 검색.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			//sales 테이블의 userid와 productname이 일치하고 grade 값이 비어있는 가장 오래된 데이터를 검색해서 평점 업데이트
			sql = "update sales set grade = ? where userid = ? and productname = ? and ";
			sql+= "buydate = (select min(buydate) from sales where userid = ? and productname = ? and grade is null )";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, saleDto.getGrade());
			pstmt.setString(2, logDto.getId());
			pstmt.setString(3, productName);
			pstmt.setString(4, logDto.getId());
			pstmt.setString(5, productName);
			
			result=pstmt.executeUpdate();		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//product 테이블에 평균평점 등록.
	public int avgGradeSet(SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();				//평범한 DB 연결 과정.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		int avgGrade = 0;
		String productName = null;
		
		try {
			
			//입력받은 productno로 매칭되는 productname을 product 테이블에서 검색.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			
			//sales 테이블의 특정 제품의 평점의 평균을 검색.
			sql = "select avg(grade) from sales where productname = ? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				avgGrade=rs.getInt("avg(grade)");	//평균 추출.
			}
			
			
			//product 테이블의 grade에 추출한 평균 평점을 update
			sql = "update product set grade = ? where productname = ? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, avgGrade);
			pstmt.setString(2, productName);
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
		
		
	}

}
