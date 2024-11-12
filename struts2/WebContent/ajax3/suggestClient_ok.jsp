<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
%>

<%!

	String[] keywords = {
			
			"ajax","Ajax","Ajax 실전 프로그래밍","AZA","AZERA","자수","자전거","자라","자바프로그래밍","자바서버페이지",
			"자바스터디","astra","about","자바 서비스","자바캔","ABC마트","Apple"
			
	};

	public List<String> search(String userKeyword){
		
		if(userKeyword==null || userKeyword.equals("")){
			
			return Collections.EMPTY_LIST;
			
			//return null;
		}
		
		//userKeyword = userKeyword.toUpperCase();		//대문자로 바꾸기
		
		List<String> lists = new ArrayList<String>();
		
		for(int i=0; i<keywords.length;i++){
			
			if(keywords[i].startsWith(userKeyword)){
				lists.add(keywords[i]);
				
			}
		}
		
		return lists;
		
	}


%>

<%

	String userKeyword = request.getParameter("userKeyword");

	List<String> keywordList = search(userKeyword);
	
	out.print(keywordList.size());
	
	out.print("|");
	
	Iterator<String> it = keywordList.iterator();
	
	while(it.hasNext()){
		
		String value = it.next();
		
		out.print(value);
		
		if(keywordList.size() - 1 > 0){
			out.print(",");
		}
		
		
	}


%>