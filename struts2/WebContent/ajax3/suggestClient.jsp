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
.suggest{	
	display: none;
	position: absolute;
	left: 11px;
	top: 141px;
}

</style>

<script type="text/javascript" src="<%=cp%>/data/js/ajaxUtil.js"></script>

<script type="text/javascript">

	function sendKeyword(){
		
		var userKeyword = document.myForm.userKeyword.value;
		
		if(userKeyword==""){
			hide();
			return;
			
		}
		
		var params = "userKeyword=" + userKeyword;
		
		sendRequest("suggestClient_ok.jsp", params, displaySuggest, "POST");
		
	}
	
	function displaySuggest(){
		
		
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				
				var resultText = xmlHttp.responseText;
				//4|ajax,---
				
				//alert(resultText);
				
				var resultArray = resultText.split("|");
				
				var count = parseInt(resultArray[0]);
				
				var keywordList = null;
				
				if(count>0){
					
					keywordList = resultArray[1].split(",");
					
					var html = "";
					
					for(var i=0;i<keywordList.length;i++){
						
						html += "<a href =\"javascript:select('"
								+ keywordList[i] + "');\">"
								+ keywordList[i] + "</a><br/>";
								
						//<a href="javascript:select('ajax');">ajax</a>
					}
					
					var suggestListDiv =
						document.getElementById("suggestListDiv");
					
					suggestListDiv.innerHTML = html;
					
					show();
				}else{	//count==0
					
					hide();
				}
				
				
			}else{	//status!=200
				hide();
			
			}
		}else{		//readystate!=4
			hide();
		}
		
	}
	
	//사용자가 제시어에서 클릭한 키워드
	function select(selectKeyword){
		
		document.myForm.userKeyword.value = selectKeyword;
		hide();
		
	}
	
	function show(){		//화면을 보이기
		
		var suggestDiv = document.getElementById("suggestDiv");
		suggestDiv.style.display = "block";
		
	}
	
	function hide(){		//화면을 숨기기
		
		var suggestDiv = document.getElementById("suggestDiv");
		suggestDiv.style.display = "none";
		
	}
	
	window.onload = function(){
		
		hide();
	}


</script>

</head>
<body>

<h1>제시어</h1>
<hr/>
<br/>

<form action="" name="myForm">

<input type="text" name="userKeyword" onkeyup="sendKeyword();"/>
<input type="button" value="검색"/>

<div id="suggestDiv" class="suggest">
	<div id="suggestListDiv"></div>
</div>

</form>


</body>
</html>