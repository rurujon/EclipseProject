<%@page import="com.util.DBConn"%>
<%@page import="com.guest.GuestDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	int num=Integer.parseInt(request.getParameter("num"));
	
	GuestDAO dao = new GuestDAO(DBConn.getConnection());
	
	int result = dao.deleteData(num);
	DBConn.close();
	
	
	response.sendRedirect(cp + "/Guest/guest.jsp");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>