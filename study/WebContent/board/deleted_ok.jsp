<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	//검색--------------------------------------
	
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	
	if(searchValue!=null){
		
		//넘어온 방식이 GET 방식일때
		if(request.getMethod().equalsIgnoreCase("GET")){
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
	}else{
		searchKey="subject";
		searchValue="";
	}
		
		
		
	//검색--------------------------------------
	
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	dao.deleteData(num);
	
	//검색--------------------------------
	String param = "";
	if(!searchValue.equals("")){
		
		param="&searchKey=" + searchKey;
		param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");	
	}
	//검색-----------------------------------
	
	DBConn.close();
	
	response.sendRedirect(cp+"/board/list.jsp?pageNum="+pageNum+param);
%>
