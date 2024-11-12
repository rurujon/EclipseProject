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

	function sendIt(){

		// XMLHttpRequest 객체 생성
		//xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //MS IE5.0이상일 때
		//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //MS IE5.0이하일 때
		
		//readyState == 0
		xmlHttp = new XMLHttpRequest(); //Mon-MS IE(Internet Explorer) // 0
		
		var query = "";
		var su1 = document.getElementById("su1").value;
		var su2 = document.getElementById("su2").value;
		var oper = document.getElementById("oper").value;
		
		//Get방식 데이터 전송(readyState == 1)
		query = "test1_ok.jsp?su1=" + su1 + "&su2=" + su2 + "&oper=" + oper;
		
		xmlHttp.onreadystatechange = callback; //callback : 메소드 이름(사용자 정의)
		
		//(readyState == 1)
		xmlHttp.open("GET",query,true); //true : 비동기 방식으로 데이터를 넘기겠다
		
		//(readyState == 2)
		xmlHttp.send(null); //post방식일 때 사용함 (readyState == 2)
	
	}
	
	function callback(){
		
		if(xmlHttp.readyState==4){ //서버에서 작업 완료했다면
			
			if(xmlHttp.status==200){ //status : 정상이라면 200 페이지가 없으면 404 오류면 500
				
				printData(); //함수를 따로 만들어서 호출해줘도 됨
				
			}
			
		}
		
	}
	
	function printData(){
		
		//html로 받으면 response html
		var result = xmlHttp.responseXML.getElementsByTagName("root")[0]; //응답받은 XML파일 (0번째거다)
		
		var out = document.getElementById("resultDiv");
		
		out.innerHTML = "";
		out.style.display = "";
		
		var value = result.firstChild.nodeValue; //xml 파싱 result의 첫번째 자식의 데이터
		
		out.innerHTML = value;
		
	}

</script>
</head>
<body>

<input type="text" id="su1"/>

<select id="oper">
	<option value="hap">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>

<input type="text" id="su2"/>

<input type="button" value=" = " onclick="sendIt();"/><br/>

<div id="resultDiv" style="display: none;"></div>

</body>
</html>