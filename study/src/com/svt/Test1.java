package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//���� �������� ����
//��� �� �� ���� ���� �ʴ´�.
public class Test1 extends GenericServlet{
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
						//�ִ� ��				//�޴� ��

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("���� ���� ���α׷�</title></head>");
		out.print("<body style='font-size:13pt;'>");
		out.print("ȭ�� �������� �������� jsp�� ���ϴ�");
		out.print("</body>");
		out.print("</html>");
		
		
	}
	
	
	

}
