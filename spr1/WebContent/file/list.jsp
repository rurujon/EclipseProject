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
<title>파일 리스트</title>

<link rel = "stylesheet" type="text/css" href="<%=cp%>/data/css/style.css">

</head>
<body>

<table width="600" border="2" cellpadding="0" cellspacing="0"
bordercolor="#d6d4a6" align="center">
<tr height="40">
	<td style="padding-left: 20px;">
		<b>파일 리스트</b>
	</td>
</tr>

</table>

<table width="600" border="0" cellpadding="0" cellspacing="0" align="center">

<tr height="30">
	<td align="left" width="80%">
	전체 데이터 수 : ${totalDataCount }, 전체 페이지 수 : ${totalPage }, 현재 페이지 : ${pageNum }
	</td>
	<td align="right">
	<input type="button" value="파일 업로드" class="btn1" onclick="location.href='<%=cp%>/file/write.action';"/>
	</td> 
</tr>
</table>

<br/>

<table width="600" border="0" cellpadding="3" cellspacing="1" bgcolor="#cccccc" align="center">
<tr align="center" bgcolor="#e6e4e6" height="25">
	<td width="40">번호</td>
	<td width="200">제목</td>
	<td width="320">첨부파일</td>
	<td width="40">수정</td>
</tr>

<c:forEach var="dto" items="${lists }">
<tr onmouseover="this.style.backgroundColor='#e4e4e4'" onmouseout="this.style.backgroundColor=''" bgcolor="#ffffff" height="25">
	<td width="40" align="center">${dto.listNum }</td>
	<td width="200" align="left">${dto.subject }</td>
	<td width="320" align="left">
	<a href="${dto.urlFile }">${dto.originalFileName }</a>
	</td>
	<td width="40" align="center">
	<a href="<%=cp %>/file/delete.action?num=${dto.num}&pageNum=${pageNum}">
	삭제</a>
	</td>
</tr>
</c:forEach>

<c:if test="${totalDataCount==0 }">
<tr bgcolor="#ffffff" height="30">
	<td align="center" colspan="4">등록된 파일이 없습니다.</td>
</tr>
</c:if>
</table>

<c:if test="${totalDataCount!=0 }">
<table width="600" border="0" cellpadding="3" cellspacing="0" align="center">
<tr align="center">
	<td align="center" height="30">
	${pageIndexList }
	</td>
</tr>
</table>
</c:if>
</body>
</html>