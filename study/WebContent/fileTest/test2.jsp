<%@page import="java.io.DataInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	//String subject = request.getParameter("subject");
	//String upload = request.getParameter("upload");
	
	String contentType = request.getContentType();
	Enumeration e = request.getHeaderNames();	//헤더를 읽어온다.
	
	out.print("전소받은 헤더정보....<br/>");
	
	while(e.hasMoreElements()){
		String key = (String)e.nextElement();
		String value = request.getHeader(key);
		out.print(key + " : " + value + "<br/>");
	}
	
	out.print("<br/>전송받은 데이터<br/>");
	DataInputStream is = new DataInputStream(request.getInputStream());
	
	String str;
	
	while((str=is.readLine())!=null){
		out.print(new String(str.getBytes("ISO-8859-1"),"euc-kr")+"<br/>");
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