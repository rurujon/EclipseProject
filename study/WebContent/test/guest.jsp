<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 

	Calendar now=Calendar.getInstance();
	
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH)+1;
	int day = now.get(Calendar.DAY_OF_MONTH);
	
	


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function sendIt(){
		
		var f=document.myForm;
		
		if(!f.userName.value){
			alert("이름을 입력하세요!");
			f.userName.focus();
			return;
		}
		
		f.submit();
	}



</script>
</head>
<body>

<form action="guest_ok.jsp" method="post" name="myForm">

이름:<input type="text" name="userName"/>
제목:<input type="text" name="subject"/>
내용:<input type="text" name="content"/>
<input type="hidden" name="created" value="<%=year%>년 <%=month%>월 <%=day%>일"/>

<input type="button" value="글 올리기" onclick="sendIt();"/>

</form>

</body>
</html>