package com.pointDB;

import com.monday2.LoginDTO;

public class Point {
	
	//����Ʈ ���ϴ� �޼���
	public void point(LoginDTO logDto) {
		
		PointDAO dao = new PointDAO();
		int allPoint = dao.pointHap(logDto);
		
		System.out.println("���� ����Ʈ : " + allPoint);
		
	}

}
