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

#resultDiv{
	border:1px dotted #0000ff;
}

div{
	margin: auto;
	width: 600px;
	height: 100%;

}


</style>

<script type="text/javascript">

	function useJson(){
		
		var userArray = [
			
			{
				id:"suzi",
				name:"배수지",
				age:29,
				phone:[
					{home:["031-1111-1111","02-1234-1234"]},
					{office:["02-4567-8765","041-3456-9876"]}
					
				]				
			},
			
			{
				id:"insun",
				name:"정인선",
				age:30,
				phone:[{},{}]
				
			},
			
			{
				id:"somi",
				name:"정소미",
				age:28,
				phone:[{},{}]
				
			}
			
			
			
		];
		
		//한 개의 데이터
		var id = userArray[0].id;
		var name = userArray[0].name;
		var age = userArray[0].age;
		
		var homePhone1 = userArray[0].phone[0].home[0];
		var homePhone2 = userArray[0].phone[0].home[1];
		
		var officePhone1 = userArray[0].phone[1].office[0];
		var officePhone2 = userArray[0].phone[1].office[1];
		
		var printData = id + ", " + name + ", " + age + "<br/>";
		
		printData += homePhone1 + "<br/>";
		printData += homePhone2 + "<br/>";
		printData += officePhone2 + "<br/>";
		printData += officePhone2 + "<br/>";
		
		
		
		//전체 데이터
		for(var i=0; i<userArray.length; i++){
			var userId = userArray[i].id;
			var userName = userArray[i].name;
			var userAge = userArray[i].age;
			
			printData += userId + "," + userName +
					"," + userAge + "<br/>";
			
		}
		
		
		
		
		var resultDiv = document.getElementById("resultDiv");
		resultDiv.innerHTML = printData;
		
		
	}
	
	window.onload = function(){
		useJson();
	}


</script>

</head>
<body>


<h1>JSON(Javascript Object Notation)</h1>
<hr/>
<div id="resultDiv"></div>


</body>
</html>