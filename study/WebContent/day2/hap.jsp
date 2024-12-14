<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 위의 text/html : MIME -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- 
	method post : 넘어가는 값이 주소창에 뜨지 않는다.
	method get : 넘어가는 값이 주소창에 뜬다.
	 -->
<form action="hap_ok.jsp" method="post">

수1: <input type="text" name="su1"/><br/>
수2: <input type="text" name="su2"/><br/>
이름: <input type="text" name="name"><br/>
<input type="submit" value="결과"/><br/>
<!-- submit은 action을 찾아간다. -->

</form>
<!-- get 방식이던 post 방식이던 영어 이외의 언어는 넘어가지 못한다. 
	고로 인코딩 타입의 변경이 필요하다	-->
<a href="hap_ok.jsp?su1=10&su2=20&name=인나">get 방식</a>
</body>
</html>