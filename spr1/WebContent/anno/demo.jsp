<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>demo</h1>

<form action="<%=cp%>/demo/demo.action" method="post">

아이디 : <input type="text" name="userId"/><br/>
패스워드 : <input type="password" name="userPwd"/><br/>

<input type="hidden" name="mode" value="insert"/>
<input type="submit" value="로그인"/>

</form>

</body>
</html>