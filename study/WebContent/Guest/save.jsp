<%@page import="com.util.DBConn"%>
<%@page import="com.guest.GuestDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String cp=request.getContextPath();
%>
<jsp:useBean id="dto" class="com.guest.GuestDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	GuestDAO dao = new GuestDAO(DBConn.getConnection());
	
	int maxNum = dao.getMaxNum();
	
	dto.setNum(maxNum+1);
	dto.setIpAddr(request.getRemoteAddr());
	
	dao.insertData(dto);
	
	DBConn.close();
	
	response.sendRedirect(cp + "/Guest/guest.jsp");
%>
