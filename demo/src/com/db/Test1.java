package com.db;


import java.sql.Connection;
import java.sql.Statement;

import com.util.DBConn;

//DB ���� ����
//1. Drivermanager�� Connection�� ����
//2. Connection�� Statement�� ����
//3. Statement�� Query�� ����


//Statement : sql ������ �����ϴ� �������̽�
//Statement, PreparedStatement, CallableStatement
public class Test1 {

	public static void main(String[] args) {
		try {
			//1.
			Connection conn = DBConn.getConnection();
			
			if(conn==null) {
				System.out.println("����Ÿ���̽� ���� ����");
				System.exit(0);
			}		
			
			//2.
			Statement stmt = conn.createStatement(); //sql�� ����     
			int result;
			String sql;
			
			/* INSERT
			sql = "insert into score(hak,name,kor,eng,mat) ";   //�� ĭ�� ������ ����ش�. �׷��� ������ ���� ������ ó���Ѵ�.
			sql+= "values ('222','���ҹ�',40,80,90)";     //+�� �ݵ�� �� �ش�.
			
			//System.out.println(sql);
			
			//3. Statement�� query�� ����
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("�߰� ����!");
			}
			*/
			/* update
			sql = "update score set name='�����',kor=100,eng=100,";
			sql+= "mat=100 where hak=111";
			
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("���� ����!");
			}
			*/
			
			sql = "delete score where hak=111";
			
			result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("���� ����!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		DBConn.close();

	}

}
