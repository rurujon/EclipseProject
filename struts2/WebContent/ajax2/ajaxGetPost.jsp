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

	var xmlHttp;
	
	function getXMLHttpRequest(){
		
		if(window.ActiveXObject){	//IE인 경우
			
			try {//IE5.0 이후
				
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				
			} catch (e) {	//IE5.0 이전
				// TODO: handle exception
				
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
		}else{						//Non-IE인 경우
			xmlHttp = new XMLHttpRequest();	//readystate 0
		}
	}
	
	function ajaxRequestGet(){
		

		
		var f = document.myForm;
		
		var data = f.greeting.value;
		
		if(data==""){
			alert("데이터 입력!");
			f.greeting.focus();
			
			return;
		}
		
		xmlHttp.open("GET","ajaxGetPost_ok.jsp?greeting=" + data, true);		//readystate 2
		xmlHttp.onreadystatechange = viewMessage;								//readystate 3
		xmlHttp.send(null);		//post 방식에서만 쓰는 것		
		
	}
	//-----------------------------------
	function ajaxRequestPost(){
		
		var f = document.myForm;
		
		var data = f.greeting.value;
		
		if(data==""){
			alert("데이터 입력!");
			f.greeting.focus();
			
			return;
		}
		
		xmlHttp.open("POST","ajaxGetPost_ok.jsp", true);		//readystate 2
		xmlHttp.setRequestHeader("content-type",
				"application/x-www-form-urlencoded");
		
		
		xmlHttp.onreadystatechange = viewMessage;								//readystate 3
		xmlHttp.send("greeting=" + data);		//post 방식에서만 쓰는 것	
		
	}
	//-----------------------------------------
	function viewMessage(){
		
		var divE = document.getElementById("printDiv");
		
		if(xmlHttp.readyState==1||				//요청페이지 정보설정
				xmlHttp.readyState==2||			//요청을 보내기 시작
				xmlHttp.readyState==3){			//서버에서 응답이 오기 시작
			
			divE.innerHTML =
				"<img src='./image/processing.gif' width='50' height='50'/>";
			
		}else if(xmlHttp.readyState==4) {	//서버 응답 완료
			
			divE.innerHTML = xmlHttp.responseText;
		}	
		
		
	}
	
	//-------------------------
	window.onload = function(){
		
		getXMLHttpRequest();
		
	}

</script>
</head>
<body>

<h1>AjaxGetPost</h1>
<hr/>
<form action="" name="myForm">

<input type="text" name="greeting"/>
<input type="button" value="GET전송" onclick="ajaxRequestGet();"/>
<input type="button" value="Post전송" onclick="ajaxRequestPost();"/>

</form>


<div id="printDiv" style="border: 1px solid blue; width: 50%"></div>

</body>
</html>