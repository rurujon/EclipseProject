<%@page import="com.score.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.score.ScoreDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적처리 리스트</title>

<style type="text/css">

*{
padding: 0px;
margin: 0px;
}

body{
font-size: 9pt;
}

td{
font-size: 9pt;
}

.btn{
font-size: 9pt; background: #e6e6e6;
}


</style>

</head>
<body>
<br/>&nbsp;<br/>

<table width="650" cellpadding="0" cellspacing="3" style="margin: auto;"
	bgcolor="#e4e4e4">
	
<tr height="50">
	<td bgcolor="#ffffff" style="padding-left: 10px;">
		<b>성적처리 리스트</b>
	</td>
</tr>

</table>
<br/>

<table width="650" cellpadding="0" cellspacing="3" style="margin: auto;">
<tr height="35">
	<td align="right">
	<input type="button" class="btn" value="등록하기"
	onclick="javascript:location.href='<%=cp%>/jumsu/write.do';"/>
	</td>
</tr>
</table>

<table width="650" cellpadding="0" cellspacing="1" style="margin: auto"
	bgcolor="#cccccc">
<tr height="30">
	<td align="center" bgcolor="#e6e6e6" width="80">학번</td>
	<td align="center" bgcolor="#e6e6e6" width="80">이름</td>
	<td align="center" bgcolor="#e6e6e6" width="60">국어</td>
	<td align="center" bgcolor="#e6e6e6" width="60">영어</td>
	<td align="center" bgcolor="#e6e6e6" width="60">수학</td>
	<td align="center" bgcolor="#e6e6e6" width="60">총점</td>
	<td align="center" bgcolor="#e6e6e6" width="60">평균</td>
	<td align="center" bgcolor="#e6e6e6" width="60">석차</td>
	<td align="center" bgcolor="#e6e6e6" width="130">수정</td>
</tr>

<c:forEach var="dto" items="${lists}">
<tr height="30">
	<td align="center" bgcolor="#ffffff">${dto.hak}</td>
	<td align="center" bgcolor="#ffffff">${dto.name}</td>
	<td align="center" bgcolor="#ffffff">${dto.kor}</td>
	<td align="center" bgcolor="#ffffff">${dto.eng}</td>
	<td align="center" bgcolor="#ffffff">${dto.mat}</td>
	<td align="center" bgcolor="#ffffff">${dto.tot}</td>
	<td align="center" bgcolor="#ffffff">${dto.ave}</td>
	<td align="center" bgcolor="#ffffff">${dto.rank}</td>
	<td align="center" bgcolor="#ffffff">
	<a href="<%=cp%>/jumsu/update.do?hak=${dto.hak}">수정</a>
	<a href="<%=cp%>/jumsu/delete_ok.do?hak=${dto.hak}">삭제</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>






































