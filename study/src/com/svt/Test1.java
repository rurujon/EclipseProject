package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//가장 원초적인 서블릿
//고로 한 번 쓰고 쓰지 않는다.
public class Test1 extends GenericServlet{
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
						//주는 것				//받는 것

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("서블릿 예제 프로그램</title></head>");
		out.print("<body style='font-size:13pt;'>");
		out.print("화면 디자인은 서블릿보다 jsp가 편하다");
		out.print("</body>");
		out.print("</html>");
		
		
	}
	
	
	

}
