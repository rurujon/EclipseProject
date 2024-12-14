<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="vo" class="com.test.Guest" scope="page"/>
<jsp:setProperty property="*" name="vo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

이름: <%=vo.getUserName() %>
제목: <%=vo.getContent() %>
내용: <%=vo.getContent() %>
날짜: <%=vo.getCreated() %>)

</body>
</html>