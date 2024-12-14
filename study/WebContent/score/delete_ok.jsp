<%@page import="com.score.ScoreDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	String hak = request.getParameter("hak");
	
	Connection conn = DBConn.getConnection();
	
	ScoreDAO dao = new ScoreDAO(conn);
	
	int result = dao.deleteData(hak);
	
	DBConn.close();
	
	response.sendRedirect(cp + "/score/list.jsp");
							//같은 공간 안에 있기 때문에 cp를 생략해도 된다.
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
