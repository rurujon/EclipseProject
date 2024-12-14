<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	//JSTL(JSP Standard Tag Library)
	//jsp에는 XML처럼 사용자가 tag를 정의해서 사용이 가능하며
	//이런 사용자정의 tag를 custom tag라고 하는데
	//자주 사용하는 tag를 표준으로 만들어 놓은 것이 바로 JSTL이다.
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="" method="post">

수 : <input type="text" name="su"/><br/>
<input type="submit" value="결과"/><br/>

</form>

<br/>

<c:if test="${!empty param.su}">

	<c:if test="${param.su%2==0 }">
		${param.su }:짝수 <br/>
	</c:if>
	
	<c:if test="${param.su%2==1 }">
		${param.su }:홀수 <br/>
	</c:if>

</c:if>

<br/><br/>

<table border="1" width="500" align="center">
<c:forEach var="i" begin="1" end="9" step="1">
<tr>
	<c:forEach var="j" begin="1" end="9" step="1">
	<td width="50">${i*j }</td>	
	</c:forEach>
</tr>
</c:forEach>
</table>
</body>
</html>