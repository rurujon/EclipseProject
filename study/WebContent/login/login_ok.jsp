<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 

	String userId = request.getParameter("userId");
	String userPwd =  request.getParameter("userPwd");
	
	if(userId.equals("suzi")&&userPwd.equals("123")){
		
		//"userId" 라는 변수로 지정된 세션 영역 안에 userId 데이터가 들어간다.
		session.setAttribute("userId", userId);
		response.sendRedirect("login.jsp");
	}

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