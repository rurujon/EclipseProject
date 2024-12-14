<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	//포워드 방식으로 한글을 넘길 때는 이 방법이 통하지 않는다.
	//get 방식, post 방식에서만 통용된다.
	request.setCharacterEncoding("UTF-8"); 

	String eng=request.getParameter("eng");
	String han=request.getParameter("kor");
	
	String kor = URLDecoder.decode(han,"UTF-8");



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

포워딩된 데이터 <br/>
영어 <%=eng %><br/>
국어 <%=kor %><br/>

</body>
</html>