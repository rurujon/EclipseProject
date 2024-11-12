package com.pointDB;

import com.monday2.LoginDTO;

public class Point {
	
	//포인트 구하는 메서드
	public void point(LoginDTO logDto) {
		
		PointDAO dao = new PointDAO();
		int allPoint = dao.pointHap(logDto);
		
		System.out.println("현재 포인트 : " + allPoint);
		
	}

}
