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
<title>파일 업로드</title>
</head>
<body>

<table width="600" border="2" cellpadding="0" cellspacing="0" bordercolor="#d6d4a6" style="margin: auto;">
<tr height="40">
	<td style="padding-left: 20px;"><b>이미지 게시판</b></td>
</tr>
</table>

<form action="<%=cp%>/image/write_ok.do" method="post"
enctype="multipart/form-data">
<table width="600" border="0" cellpadding="0" cellspacing="3" style="margin: auto;">
<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>
</tr>

<tr>
	<td width="20%" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">제목</td>
	<td width="80%" style="padding-left: 10px;">
	<input type="text" name="subject" size="35" maxlength="20" class="boxTF"/>
	</td>
</tr>

<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>

<tr>
	<td width="20%" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">파일</td>
	<td width="80%" style="padding-left: 10px;">
	<input type="file" name="upload" size="35" maxlength="50" class="boxTF"/>
	</td>
</tr>

<tr><td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>


</table>

<table width="600" border="0" cellpadding="0" cellspacing="3" style="margin: auto;">
<tr align="center">
	<td height="40">
	<input type="submit" value="등록하기" class="btn1"/>
	<input type="reset" value="다시입력" class="btn1" onclick="document.myForm.subject.focus();"/>
	<input type="button" value="작성취소" onclick="location='<%=cp%>/image/list.do';">
	</td>
</tr>
</table>

</form>



</body>
</html>