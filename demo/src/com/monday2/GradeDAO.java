package com.monday2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;


public class GradeDAO {
	
	//�����̷� �˻�
	public boolean existCheck(LoginDTO logDto, SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();				//����� db ���� ����.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		String productName = null;
		
		boolean exist = false;
		
		try {
			
			//�Է¹��� productno�� ��Ī�Ǵ� productname�� product ���̺��� �˻�.
			//�ƿ� sales���� productno �÷��� �߰��س����� �ξ� ���߰����� �̹� �Է��� �����Ͱ� ���� foreign key�� �Ű����ϴ� �׳� ���� �˻��۾��� ����.
			
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//��ȣ�� ��Ī�Ǵ� productname ����.
			}
			
			
			//userid ��ġ, productname ��ġ, ���� ���� null�� �����Ͱ� sales ���̺� �ִ��� Ȯ��.
			sql = "select * from sales where userid = ? and productname = ? and grade is null";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, logDto.getId());
			pstmt.setString(2, productName);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {					//�ִٸ�, ���翩�δ� true ;
				exist = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return exist;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//sales ���̺� ���� ���
	public int gradeInput(SalesDTO saleDto,LoginDTO logDto) {
		
		Connection conn = DBConn.getConnection();		//����� DB ���� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		String productName = null;
		
		try {
			
			//�Է¹��� productno�� ��Ī�Ǵ� productname�� product ���̺��� �˻�.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			//sales ���̺��� userid�� productname�� ��ġ�ϰ� grade ���� ����ִ� ���� ������ �����͸� �˻��ؼ� ���� ������Ʈ
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
	
	//product ���̺� ������� ���.
	public int avgGradeSet(SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();				//����� DB ���� ����.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		int avgGrade = 0;
		String productName = null;
		
		try {
			
			//�Է¹��� productno�� ��Ī�Ǵ� productname�� product ���̺��� �˻�.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			
			//sales ���̺��� Ư�� ��ǰ�� ������ ����� �˻�.
			sql = "select avg(grade) from sales where productname = ? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				avgGrade=rs.getInt("avg(grade)");	//��� ����.
			}
			
			
			//product ���̺��� grade�� ������ ��� ������ update
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
