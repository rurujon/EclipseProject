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

<style type="text/css">

div {
	margin: auto;
	border: 1px solid #0000ff;
	width: 600px;
	height: 70%;
	padding: 10px;
}



</style>

<script type="text/javascript" src="<%=cp%>/data/js/ajaxUtil.js"></script>

<script type="text/javascript">

	function newsTitle(){
		
		sendRequest("newsTitleXML_ok.jsp",null,displayNewsTitle,"GET");
		
		setTimeout("newsTitle()", 3000);
		
	}
	
	
	function displayNewsTitle(){
		
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				
				var doc = xmlHttp.responseXML;
				//alert(doc)
				
				var count = 
					doc.getElementsByTagName("count")
					.item(0)
					.firstChild
					.nodeValue;
				
				//alert(count);
				
				if(count>0){
					
					var titleNL = doc.getElementsByTagName("title");
					
					var html = "<ol>";
					
					for(var i=0; i<titleNL.length; i++){
						html += "<li>"
							+ titleNL.item(i).firstChild.nodeValue
							+"</li>";
						
					}
					
					html +="</ol>";
					
					
				}
				
				//alert(html);
				
				var newsDiv = document.getElementById("newsDiv");
				newsDiv.innerHTML = html;
				
				
			}
		}
		
		
	}
	
	window.onload = function(){
		
		newsTitle();
		
	}




</script>



</head>
<body>

<h1>실시간 뉴스</h1>
<hr/>
<div id="newsDiv"></div>

</body>
</html>