<%@ page contentType="text/html; charset=UTF-8"%>
<% 

	request.setCharacterEncoding("UTF-8"); 
	
	String name=request.getParameter("name");
	
	//서버가 클라이언트에게 명령을 주는 것 : response
	
	response.sendRedirect("result.jsp");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 : <%=name%>

</body>
</html>