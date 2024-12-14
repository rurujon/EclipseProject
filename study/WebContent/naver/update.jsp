<%@page import="com.naver.NaverDTO"%>
<%@page import="com.naver.NaverDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	String id = request.getParameter("id");
	
	Connection conn = DBConn.getConnection();
	NaverDAO dao = new NaverDAO(conn);
	
	NaverDTO dto = dao.getReadData(id);
	
	DBConn.close();
	
	if(dto==null){
		
		response.sendRedirect("list.jsp");
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function sendIt(){
		
		var f = document.myForm;
		
		if(!f.pwd.value){
			
			alert("빈 데이터를 입력하세요");
			f.pwd.focus();
			return;
		}
		
		if(!f.email.value){
			
			alert("빈 데이터를 입력하세요");
			f.email.focus();
			return;
		}
		if(!f.tel.value){
			
			alert("빈 데이터를 입력하세요");
			f.tel.focus();
			return;
		}
		
		f.action = "<%=cp%>/naver/update_ok.jsp";
		f.submit();
	}
	
</script>

<style type="text/css">

body {
	font-size: 9pt;
}

td {
	font-size: 9pt;
}

.txtField{
	font-size: 9pt;
	border: 1px solid;
}

.btn{
	font-size: 9pt;
	background: #e6e6e6
		
}
</style>
</head>
<body>

<br/><br/>
<table width="500" cellpadding="0" cellspacing="3" align="center" bgcolor="#e4e4e4">
<tr height="50">
	<td bgcolor="#ffffff" style="padding-left: 10px;">
	<b>회원 정보 수정</b>
	</td>
</tr>
</table>

<br/>
<form action="" method="post" name="myForm">
<table width="500" cellpadding="0" cellspacing="0" align="center">

<tr height="3"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">아이디</td>
	<td style="padding-left: 5px;">
	<%=dto.getId() %>
	</td>
</tr>

<tr height="2"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">이름</td>
	<td style="padding-left: 5px;">
	<%=dto.getName() %>
	</td>
</tr>

<tr height="2"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">비밀번호</td>
	<td style="padding-left: 5px;">
	<input type="text" name="pwd" value="<%=dto.getPwd() %>" size="20" class="txtField">
	</td>
</tr>

<tr height="2"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">이메일</td>
	<td style="padding-left: 5px;">
	<input type="text" name="email" value="<%=dto.getEmail() %>" size="20" class="txtField">
	</td>
</tr>

<tr height="2"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">전화번호</td>
	<td style="padding-left: 5px;">
	<input type="text" name="tel" value="<%=dto.getTel() %>" size="20" class="txtField">
	</td>
</tr>

<tr height="35">
	<td align="center" colspan="2">
	
	<input type="hidden" name="id" value="<%=dto.getId()%>"/>
	<input type="button" class="btn" value="수정완료" onclick="sendIt();"/>
	<input type="button" class="btn" value="수정취소" onclick="javascript:location.href='<%=cp%>/naver/list.jsp';"/>
															<!-- location = ~~ 바로 써도 된다. -->
	</td>
</tr>
</table>
</form>


</body>
</html>