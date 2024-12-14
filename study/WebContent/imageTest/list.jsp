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
<title>이미지 게시판</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/imageTest/data/style.css"/>


</head>
<body>

<table width="600" border="2" cellpadding="0" cellspacing="0" bordercolor="#d6d4a6" style="margin: auto;">
<tr height="40">
	<td style="padding-left: 20px;"><b>이미지 게시판</b></td>
</tr>
</table>
<br/>

<table border="0" width="600" cellpadding="0" cellspacing="0"
align="center">
<tr>
	<td align="left" colspan="2">
	전체 데이터 수:${dataCount }, 전체 페이지 수:${totalPage }, 현재 페이지:${currentPage }
	</td>
	<td align="right" colspan="1">
	<input type="button" value=" 게시물 등록 " onclick="location='<%=cp%>/image/write.do';">
	</td>
</tr>

</table>
<br/>

<table width="600" border="0" cellspacing="1" cellpadding="1"
align="center">
<tr><td colspan="3" height="3" bgcolor="#dbdbdb" align="center"></td></tr>

<tr>
<c:forEach var="dto" items="${lists }" varStatus="status">
	<td align="left" width="200">
	<img src="${imagePath }/${dto.saveFileName}" width="180" height="180">
	<br/>
	<div style="text-align: center;">
		${dto.subject }&nbsp;
		<a href="${deletePath }?num=${dto.num}">삭제</a>
	</div>
	</td>
	<c:if test="${status.index%3 == 2 }">
	</tr><tr>
	</c:if>
</c:forEach>

<c:if test="${lists.size()%3 !=0 }">
	<c:set var="emptyCells" value="${3-lists.size()%3}"/>
	<c:forEach var="i" begin="1" end="${emptyCells}">
		<td width="200"></td>
	</c:forEach>

</c:if>

</tr>

<tr><td colspan="3" height="3" bgcolor="#dbdbdb" align="center"></td></tr>
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










</form>

</body>
</html>