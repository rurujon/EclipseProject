<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 


	String id = session.getId();
	int sTime = session.getMaxInactiveInterval();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h3>일정관리</h3>

세션 아이디 : <%=id %><br/>
세션 유효시간 : <%=sTime %>초
</body>
</html>