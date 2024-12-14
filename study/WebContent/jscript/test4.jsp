<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function changeColor(color){
		document.bgColor=color;
		
	}

</script>


</head>
<body>

<h3>배경색 선택하기</h3>

<input type="radio" name="r1" checked="checked" onclick="changeColor('white');"/>white<br/>
<input type="radio" name="r1" onclick="changeColor('red');"/>red<br/>
<input type="radio" name="r1" onclick="changeColor('blue');"/>blue<br/>
<input type="radio" name="r1" onclick="changeColor('yellow');"/>yellow<br/>

</body>
</html>