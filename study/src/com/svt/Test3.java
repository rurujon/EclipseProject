package com.svt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

public class Test3 extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");	//받아온 값을 utf-8로 변경
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		String str=name+"의 나이는 " + age + "살 입니다.";
		
		//포워딩하는 페이지에 데이터 넘김 = 포워딩하는 데이터
		req.setAttribute("result", str);
		
		//포워딩할 페이지
		RequestDispatcher rd = req.getRequestDispatcher("/servlet/result.jsp");
		
		rd.forward(req, resp);
		
	}

}
