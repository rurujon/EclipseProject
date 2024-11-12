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

<script type="text/javascript">

	var xmlHttp = new XMLHttpRequest();
	
	function requestGet(){
		
		var f = document.myForm;
		
		var params = "?userId=" + f.userId.value;
		
		xmlHttp.open("GET","ajaxId_ok.jsp" + params, true);
		xmlHttp.onreadystatechange = viewMessage;
		xmlHttp.send(null);
		
		
	}
	
	function viewMessage(){
		
		if(xmlHttp.readyState==4){
			
			
			if(xmlHttp.status==200){
				
				var str = xmlHttp.responseText;
				
				var divE = document.getElementById("resultDiv");
				
				divE.innerHTML = str;
				
				
			}
		}
	}


</script>


</head>
<body>

<h1>Ajax ID 확인</h1>
<hr/>
<form action="" name="myForm">

아이디 : <input type="text" name="userId" onkeyup="requestGet();"/>

</form>

<div id="resultDiv" style="color: red; border: 1px solid #000000; width: 50%"></div>





</body>
</html>