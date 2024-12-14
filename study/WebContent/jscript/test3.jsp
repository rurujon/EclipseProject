<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var num1=20,num2=3;
	
	document.write("num1+num2=" + (num1+num2) + "<br/>");
	document.write("num1-num2=" + (num1-num2) + "<br/>");
	document.write("num1*num2=" + (num1*num2) + "<br/>");
	document.write("num1/num2=" + (num1/num2) + "<br/>");
	document.write("num1%num2=" + (num1%num2) + "<br/>");
	document.write("num1==num2=" + (num1==num2) + "<br/>");
	document.write("num1!=num2=" + (num1!=num2) + "<br/>");

	document.write("------------------------------------------<br/>");
		
	
	var answer;
	answer = 0;
	
	if(answer>0){
		document.write("양수입니다");
	}
	else if(answer<0){
		document.write("음수입니다");
	}
	else{
		document.write("0입니다.")
	}
	
	document.write("------------------------------<br/>");
	
	for(var i=1;i<=10;i++){
		document.write(i+"<br/>");
		
	}
	document.write("<br/>------------------------------<br/>");
	
	var j=1;
	while(j<=10){
		document.write(j+"\t");
		j++;
	}
	document.write("<br/>------------------------------<br/>");
	
	function test1(){
		
		alert("자바스크립트 함수...");
	}
	
	
	

</script>
</head>
<body onload="test1();">

여기는 HTML body...

</body>
</html>