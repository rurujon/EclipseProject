<%@page import="com.naver.NaverDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.naver.NaverDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	Connection conn = DBConn.getConnection();
	NaverDAO dao = new NaverDAO(conn);
	
	List<NaverDTO> lists = dao.getLists();
	
	DBConn.close();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NAVER 회원 리스트</title>
<style type="text/css">

body {
	font-size: 9pt;
}
td {
	font-size: 9pt;
}
.btn {
	font-size: 9pt;
	background: #e6e6e6
}

a {
	text-decoration: nane;
	color: blue;
}

a:hover, a:active {
	font-size: 9pt;
	color: #f28011;
	text-decoration: underline;
}


</style>
</head>
<body>

<br/><br/>

<table width="700" cellpadding="0" cellspacing="3" align="center" bgcolor="#e4e4e4">
<tr height="50">
	<td bgcolor="#ffffff" style="padding-left: 10px;">
	<b>네이버 회원 리스트</b>
	</td>
</tr>

</table>

<br/>
<table width="650" cellpadding="0" cellspacing="3" align="center">
<tr height="35">
	<td align="right">
	<input type="button" class="btn" value="회원가입" onclick="location='<%=cp%>/naver/naver.jsp';"/>
	</td>
</tr>
</table>

<table width="700" cellspacing="1" cellpadding="0" align="center" bgcolor="#cccccc">
<tr height="30">
	<td align="center" bgcolor="#e6e6e6" width="60">아이디</td>
	<td align="center" bgcolor="#e6e6e6" width="60">패스워드</td>
	<td align="center" bgcolor="#e6e6e6" width="100">이메일</td>
	<td align="center" bgcolor="#e6e6e6" width="60">이름</td>
	<td align="center" bgcolor="#e6e6e6" width="60">생년월일</td>
	<td align="center" bgcolor="#e6e6e6" width="60">통신사</td>
	<td align="center" bgcolor="#e6e6e6" width="60">성별</td>
	<td align="center" bgcolor="#e6e6e6" width="60">구분</td>
	<td align="center" bgcolor="#e6e6e6" width="100">전화번호</td>
	<td align="center" bgcolor="#e6e6e6" width="130">수정</td>
</tr>

<%for(NaverDTO dto : lists) {%>
<tr height="30">
	<td align="center" bgcolor="#ffffff"><%=dto.getId() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getPwd() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getEmail() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getName() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getBirth() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getTelecom() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getGender() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getNation() %></td>
	<td align="center" bgcolor="#ffffff"><%=dto.getTel() %></td>
	<td align="center" bgcolor="#ffffff">
	<a href="<%=cp%>/naver/update.jsp?id=<%=dto.getId()%>">수정</a>
	<a href="<%=cp%>/naver/delete_ok.jsp?id=<%=dto.getId()%>">삭제</a>
	</td>
</tr>

<%} %>
</table>
</body>
</html>