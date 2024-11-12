<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();

	String greeting = request.getParameter("greeting");
	
	for(int i=0;i<30000;i++){
		System.out.print("기다려..처리중..");
	}
	
%>

<%="server : " + greeting%>