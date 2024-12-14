<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	//String root = request.getRealPath("/");   : 옛날 방식
	String root = pageContext.getServletContext().getRealPath("/");
	
	//String path = "c:\\pds\\saveData";
	String path = root + "pds" + File.separator + "saveData";
	
	File f = new File(path);
	
	if(!f.exists()){
		f.mkdirs();
	}
	
	String encType = "UTF-8";
	int maxFileSize = 10*1024*1024;	//10mb
	
	try{
		
		//파일 전송 코딩
		MultipartRequest mr = 
			new MultipartRequest(request,path,maxFileSize,encType,
					new DefaultFileRenamePolicy());
		//이걸로 파일 업로드는 끝이고, 이제 mr에서 파일 정보를 추출해야 한다.
		
		
		//db에 데이터를 저장하기 위해 파일 정보를 추출
		out.print("제목 : " + mr.getParameter("subject") + "<br/>");
		out.print("서버에 저장된 파일명 : " + mr.getFilesystemName("upload")+ "<br/>");
		out.print("업로드한 파일명 : " + mr.getOriginalFileName("upload")+ "<br/>");
		out.print("파일 타입 : " + mr.getContentType("upload") + "<br/>");
		
		File file = mr.getFile("upload");
		
		if(file!=null){
			out.print("파일 사이즈 : " + file.length() + "<br/>");
		}
		
	}catch(Exception e){
		System.out.print(e.toString());
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



</body>
</html>