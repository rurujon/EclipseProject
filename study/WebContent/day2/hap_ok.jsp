<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

%>
<%
	String s1 = request.getParameter("su1");
	String s2 = request.getParameter("su2");
	
	int su1=Integer.parseInt(s1);
	int su2=Integer.parseInt(s2);
	
	String name =request.getParameter("name");
	
	int sum=su1+su2;
	
	/*MIME [Multipurpose Internet Mail Extensions]의 종류
메세지의 내용이 어떤 형식인지 알려주기위해 정의한 인터넷 표준

text/plain : 일반 텍스트문서
text/html : HTML 문서 
text/css  :CSS 문서
text/xml : XML 문서
image/jpeg,image/png : JPEG파일, PNG파일 
video/mpeg,audio/mp3 : MPEG 비디오파일, MP3 음악파일
application/zip : zip 압축파일
*/


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

결과 : <%=su1 %>+<%=su2 %>=<%=sum %>
이름 : <%=name %>)
</body>
</html>