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
.news{
	font-size: 9pt;
	display: block;
	margin: 0 auto;
	background: yellow;
	color: blue;
	border: 1px dashed black;
	width: 50%
}


</style>

<script type="text/javascript" src="<%=cp%>/data/js/ajaxUtil.js"></script>

<script type="text/javascript">

	function newsTitle(){
		
		sendRequest("newTitleCSV_ok.jsp",null,displayNewsTitle,"GET");
		
		setTimeout("newsTitle()",3000);
		
	}
	
	function displayNewsTitle(){
		
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				
				var csvStr = xmlHttp.responseText;
				//alert(csvStr);
				
				var csvArray = csvStr.split("|");
				
				var countStr = csvArray[0];
				//alert(countStr);
				
				if(countStr==0){
					alert("뉴스가 없다");
					return;
				}
				
				var csvData = csvArray[1];
				//alert(csvData);
				
				var newsTitleArray = csvData.split("*");
				//alert(newsTitleArray.length);
				
				var html = "";
				
				html +="<ol>";
				
				for(var i=0; i<newsTitleArray.length; i++){
					
					var newsTitle = newsTitleArray[i];
					
					html +="<li>" + newsTitle + "</li>";
				}
				
				html +="</ol>";
				//alert(html);
				
				var divE = document.getElementById("newsDiv");
				
				divE.innerHTML = html;
				
			}
		}
		
	}
	
	window.onload = function(){
		
		newsTitle();
	}




</script>
</head>
<body>

<h2>헤드라인 뉴스</h2>
<br/>
<hr/>

<div style="display: block; border: 30x solid; width: 50%;">
뉴스보기
</div>

<div id="newsDiv" class="news"></div>


</body>
</html>