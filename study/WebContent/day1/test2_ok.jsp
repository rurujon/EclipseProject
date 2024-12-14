<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String[] major = request.getParameterValues("major");
	String agree=request.getParameter("agree");
	String memo = request.getParameter("memo");
	
	if(agree==null){
		agree="N";
	}
	
	
	memo=memo.replaceAll("\n","<br/>");
	
	String str="";
	if(major!=null){
		
		for(String temp:major){
			str += temp+" ";
			
			
		}
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

아이디 : <%=id %><br/>
패스워드 : <%=pwd %><br/>
이름 : <%=name %><br/>
성별 : <%=gender %><br/>
전화번호 : <%=tel1 %> - <%=tel2 %> - <%=tel3 %><br/>
전공 : <%=str %><br/>
동의여부 : <%=agree %><br/>
메모 : <%=memo %><br/>

</body>
</html>