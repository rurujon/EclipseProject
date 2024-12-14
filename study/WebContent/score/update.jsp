<%@page import="com.score.ScoreDTO"%>
<%@page import="com.score.ScoreDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 

	request.setCharacterEncoding("UTF-8"); 

	//study 까지의 주소를 가져온다
	String cp=request.getContextPath();
	
	String hak = request.getParameter("hak");
	
	Connection conn = DBConn.getConnection();
	ScoreDAO dao = new ScoreDAO(conn);
	
	ScoreDTO dto = dao.getReadData(hak);
	
	DBConn.close();
	
	if(dto==null){
		
		response.sendRedirect("list.jsp");
	}


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적 처리 수정</title>

<script type="text/javascript">

	function sendIt(){
		
		var f = document.myForm;
		
		if(!f.hak.value){
			
			alert("학번을 입력하세요");
			f.hak.focus();
			return;
		}
		
		f.action = "<%=cp%>/score/update_ok.jsp";
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
	<b>성적 처리 수정</b>
	</td>
</tr>
</table>

<br/>
<form action="" method="post" name="myForm">
<table width="500" cellpadding="0" cellspacing="0" align="center">

<tr height="3"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">학번</td>
	<td style="padding-left: 5px;">
	<%=dto.getHak() %>
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
	<td align="center" width="100" bgcolor="#e6e6e6">국어</td>
	<td style="padding-left: 5px;">
	<input type="text" name="kor" value="<%=dto.getKor() %>" size="20" maxlength="3" class="txtField">
	</td>
</tr>

<tr height="2"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">영어</td>
	<td style="padding-left: 5px;">
	<input type="text" name="eng" value="<%=dto.getEng() %>" size="20" maxlength="3" class="txtField">
	</td>
</tr>

<tr height="2"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="30">
	<td align="center" width="100" bgcolor="#e6e6e6">수학</td>
	<td style="padding-left: 5px;">
	<input type="text" name="mat" value="<%=dto.getMat() %>" size="20" maxlength="3" class="txtField">
	</td>
</tr>

<tr height="3"><td colspan="2" bgcolor="#cccccc"></td></tr>

<tr height="35">
	<td align="center" colspan="2">
	
	<input type="hidden" name="hak" value="<%=dto.getHak()%>"/>
	<input type="button" class="btn" value="수정완료" onclick="sendIt();"/>
	<input type="button" class="btn" value="수정취소" onclick="javascript:location.href='<%=cp%>/score/list.jsp';"/>
															<!-- location = ~~ 바로 써도 된다. -->
	</td>
</tr>
</table>


</form>
</body>
</html>