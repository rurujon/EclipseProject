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
</head>
<body>

<br/><br/>

<table border="1" width="600" cellpadding="0" cellspacing="0"
align="center">
<tr>
	<td align="right" colspan="4">
	<input type="button" value="파일 올리기" onclick="location='<%=cp%>/fileTest/write.do';"/>
	</td>
</tr>

<tr>
	<td align="center" width="50">번호</td>
	<td align="center" width="150">제목</td>
	<td align="center" width="250">파일명</td>
	<td align="center" width="50">삭제</td>
</tr>

<c:forEach var="dto" items="${lists }">
<tr>
	<td align="center" width="50">${dto.num }</td>
	<td align="left" width="150">${dto.subject }</td>
	<td align="left" width="250">
	
	
	<%-- <a href="${downloadPath}?num=${dto.num}">
	${dto.originalFileName }</a> --%>
	
	<a href="${imagePath }/${dto.saveFileName}">
	<img src="${imagePath }/${dto.saveFileName}" 
	width="180" height="180"/>
	</a>
	
	</td>
	<td align="center" width="50">
	<a href="${deletePath }?num=${dto.num}">삭제</a></td>
</tr>
</c:forEach>

<tr>
	<td colspan="4" align="center">
	<c:if test="${dataCount!=0 }">
		${pageIndexList }
	</c:if>
	<c:if test="${dataCount==0 }">
		등록된 게시물이 없습니다.
	</c:if>
	</td>
</tr>

</table>


</body>
</html>