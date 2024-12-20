<%@page import="com.guest.GuestDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DBConn"%>
<%@page import="com.guest.GuestDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//list+create역할
	request.setCharacterEncoding("UTF-8");
	
	String cp=request.getContextPath();
%>
<%
	GuestDAO dao = new GuestDAO(DBConn.getConnection());
	
	List<GuestDTO> lists = dao.getLists();
	
	DBConn.close();
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/Guest/data/style.css"/>

<script type="text/javascript" src="<%=cp%>/Guest/data/guest.js"></script>

<script type="text/javascript">
	function isDelete(num){
		
		if(confirm("위 자료를 삭제하시겠습니까?")){
			location.href="<%=cp%>/Guest/delete.jsp?num=" + num;
		}
	}

</script>

</head>
<body>
<table width="560" border="2" cellpadding="0" cellspacing="0" bordercolor="#d6d4a6" style="margin: auto;">
<tr height="40">
	<td style="padding-left: 20px;"><b>방 명 록</b></td>
</tr>
</table>
<form action="" method="post" name="myForm">
<table width="560" border="0" cellpadding="0" cellspacing="3" style="margin: auto;">
<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>
</tr>

<tr>
	<td width="20%" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">작성자</td>
	<td width="80%" style="padding-left: 10px;">
	<input type="text" name="name" size="35" maxlength="20" class="boxTF"/>
	</td>
</tr>

<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>

<tr>
	<td width="20%" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">E-Mail</td>
	<td width="80%" style="padding-left: 10px;">
	<input type="text" name="email" size="35" maxlength="50" class="boxTF"/>
	</td>
</tr>

<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>

<tr>
	<td width="20%" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">홈페이지</td>
	<td width="80%" style="padding-left: 10px;">
	<input type="text" name="homepage" size="35" maxlength="50" class="boxTF" value="http://"/>
	</td>
</tr>

<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>

<tr>
	<td width="20%" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
	<td width="80%" style="padding-left: 10px;">
	<textarea rows="7" cols="60" name="content" class="boxTA" style="resize: none; background-color: #ffffff;"></textarea>
	</td>
</tr>

</table>

<table width="560" border="0" cellpadding="0" cellspacing="3" style="margin: auto;">
<tr align="center">
	<td height="40">
	<input type="button" value="등록하기" class="btn1" onclick="sendIt();"/>
	<input type="reset" value="다시입력" class="btn1" onclick="document.myForm.name.focus();"/>
	</td>
</tr>
</table>

 </form>

<table width="560" border="0" cellpadding="0" cellspacing="0" style="margin: auto;">
<tr><td height="3" bgcolor="#dbdbdb" align="center"/></tr>
</table>

<%for(GuestDTO dto : lists){ %>
<table width="560" border="0" cellpadding="0" cellspacing="0" bgcolor="#eeeeee" style="margin: auto;">
<tr height="20" >
	<td width="50%" style="padding-left: 5px;">
	<%if(dto.getEmail()==null){ %>
		<b>No <%=dto.getNum() %>. <%=dto.getName() %></b>
	<%}else{ %>
		<b>No <%=dto.getNum() %>. <%=dto.getName() %>
		<a href="mailto:<%=dto.getEmail() %>")>(<%=dto.getEmail() %>)</a></b>
		<%} %>
	</td>
		
	<td align="right" style="padding: 5px;">
		<%if(!dto.getHomepage().equals("")) {%>
		홈페이지 : <a href="<%=dto.getHomepage() %>" target="_blank">
		<%=dto.getHomepage() %></a>
		<%} else{ 
		out.print("&nbsp;");  } %>
	</td>
	
	</tr>
	
	<tr height=" 5px;">
		<td style="padding: 5px;">
		작성일: <%=dto.getCreated() %>(<%=dto.getIpAddr() %>) 
		</td>
		<td align="right" style="padding: 5px">
		<a href="javascript:isDelete('<%=dto.getNum()%>');">삭제</a>
		</td>
	</tr> 
	
	<tr><td colspan="2" bgcolor="#dbdbdb" height="1"></td></tr>
	
	<tr>
		<td bgcolor="#ffffff" colspan="2" height="20" valign="top" style="padding: 5px">
		<%=dto.getContent().replaceAll("\n", "<br/>") %>
		</td>	
	</tr>
	
	<tr><td colspan="2" bgcolor="#dbdbdb" height="1"></td></tr>
	
</table>

<%} %>


</body>
</html>