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
	
	function ajaxRequest(){
		
		xmlHttp = new XMLHttpRequest();
		
		xmlHttp.open("GET", "helloAjax_ok.jsp", true);
		xmlHttp.onreadystatechange  = viewMessage;
		xmlHttp.send(null);
	}
	
	function viewMessage(){
		
		var respText = xmlHttp.responseText;
		
		var divE = document.getElementById("printDiv");
		
		divE.innerHTML = respText;
		
	}



</script>
</head>
<body>

<h1>Hello Ajax</h1>
<input type="button" value="클릭" onclick="ajaxRequest();">

<br/><br/>
<div id="printDiv" style="border: 1px solid red; width: 50%"></div>

</body>
</html>