<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var hello = "함수 밖 전역변수 " + "<br/>";
	function thisFunc(){
		
		var hello = "함수 안 지역변수 hello" + "<br/>";
		
		global = "함수 안 전역변수 global" + "<br/>";
		
		var local = "함수 안 지역변수 local" + "<br/>";
		
		document.write(hello + "<br/>");
		document.write(global + "<br/>");
		document.write(local + "<br/>");
	}
	
	thisFunc();
	document.write(hello + "<br/>");
	document.write(global + "<br/>");
	document.write(local + "<br/>");


</script>






</head>
<body>

</body>
</html>