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
	width: 50%;
}


</style>

<script type="text/javascript" src="<%=cp%>/data/js/ajaxUtil.js"></script>

<script type="text/javascript">

	function newsTitle(){
		
		sendRequest("newTitleJSON1_ok.jsp", null, displayNewsTitle, "GET");
		setTimeout("newsTitle()",3000);
		
		
	}
	
	function displayNewsTitle() {
		
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				
				var jsonStr = xmlHttp.responseText;
				//alert(jsonStr);
				
				//eval은 변수의 내용을 객체화(클래스화)시킨다.
				var jsonObject = window.eval('(' + jsonStr + ')');
				
				
				//alert(jsonObject.count);
				//alert(jsonObject.title[2].publisher);
				
				var count = jsonObject.count;
				
				if(count>0){
					var html = "<ol>";
					
					for(var i=0; i<jsonObject.title.length; i++){
						
						var publisherStr =
							jsonObject.title[i].publisher;
						
						var headlineStr =
							jsonObject.title[i].headline;
						
						html+= "<li>" + headlineStr +
							" [" + publisherStr + "]</li>";
					}
					
					html +="</ol>";
					
					
					var newsDiv = document.getElementById("newsDiv");
					newsDiv.innerHTML = html;
					
				}
				
				
				
			}
			
		}
		
		
	}
	
	window.onload = function(){
		newsTitle();
	}


</script>


</head>
<body>

<h1>NewsTitleJSON</h1>
<hr/>
<br/>
<div style="width: 50%; margin: 0 auto;">뉴스보기</div>
<div id="newsDiv" class="news"></div>


</body>
</html>