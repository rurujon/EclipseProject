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
	
	function printClientTime(){
		
		var clientTime = document.getElementById("clientTime");
		
		var now = new Date;
		
		var timeStr = now.getFullYear()+"년 "
					+ (now.getMonth()+1) + "월 "
					+ now.getDate() + "일 "
					+ now.getHours() + "시 "
					+ now.getMinutes()+ "분 "
					+ now.getSeconds() + "초";
		
		clientTime.innerHTML = timeStr;
		
		setTimeout("printClientTime()",1000);
		
	}
	
	function requestTime(){
		
		xmlHttp.open("GET","clock_ok.jsp",true);
		xmlHttp.onreadystatechange = printServerTime;
		xmlHttp.send(null);
		
		setTimeout("requestTime()",1000);
		
		
	}
	
	function printServerTime(){
		
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				
				var serverTime = document.getElementById("serverTime");
				
				
				serverTime.innerHTML = xmlHttp.responseText;
				
			}
		}
		
		
	}

	
	window.onload = function(){
		printClientTime();
		requestTime();
	}


</script>
</head>
<body>

<h1>clock</h1>
<br/>
<hr/>

1. 현재 클라이언트 시간은 <b><span id="clientTime"></span></b> 입니다.<br/>
2. 현재 서버 시간은 <b><span id="serverTime"></span></b> 입니다.

</body>
</html>