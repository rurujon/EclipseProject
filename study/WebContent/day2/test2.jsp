<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="test2_ok.jsp" method="post">

이름:<input type="text" name="name"/><br/>
메모:<textarea rows="5" cols="30" name="memo"></textarea><br/>
좋아하는 취미:<br/>
<input type="checkbox" name="hobby" value="캠핑">캠핑<br/>
<input type="checkbox" name="hobby" value="독서">독서<br/>
<input type="checkbox" name="hobby" value="여행">여행<br/>
<input type="checkbox" name="hobby" value="영화">영화<br/>
<input type="checkbox" name="hobby" value="음악">음악<br/>

전공 : 
<select name="major" size="4" multiple="multiple">

	<option value ="수학">수학</option>
	<option value ="영어">영어</option>
	<option value ="국어">국어</option>
	<option value ="컴공">컴공</option>

</select>

<input type="submit" value="전송"/><br/>

</form>

</body>
</html>