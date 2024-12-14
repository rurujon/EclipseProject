<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	
	String name=request.getParameter("name");
	String memo=request.getParameter("memo");
	String[] hobby=request.getParameterValues("hobby");
	String[] major=request.getParameterValues("major");
	
	String str ="";
	if(hobby!=null){
		for(String temp : hobby){
			str += temp + " ";
		}
	}
	
	String str1 ="";
	if(major!=null){
		for(String temp : major){
			str += temp + " ";
		}
	}
	
	memo=memo.replaceAll("\n", "<br/>");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 : <%=name %><br/>
취미 : <%=str %><br/>
메모 : <%=memo %><br/>
전공 : <%=str1 %><br/>

</body>
</html>