
<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
%>

<%!		//느낌표를 해주지 않으면 service 메소드 안에 들어간다.
		//service 또한 일종의 메소드로, 메소드 안에 메소드는 들어가지 못하므로 에러가 뜬다.
		//!를 쓰면 service 바깥에 저장이 되므로(일종의 전역변수) 오류가 뜨지 않는다.

	String[] newsTitle = {
			
			"사업다각화 성공한 NHN, '티메프' 사태 불똥",
			"삼성전기, 고수익 기업에서 평범한 기업 됐다",
			"주요 건설사, 원가부담 상승에 수익성 하락 못 피해",
			"무엇이 티몬과 위메프를 위기로 몰았나?",
			"이호성 대표 체제 하나카드, '빅5' 진입 노린다",
			"임종룡 우리금융 회장, 비은행 부문 새판 본격화",
			"8번째 데이터"
			
			
			
	};


%>

<%

//6|사업다각화 성공한 NHN, '티메프' 사태 불똥[2024.08.13 오후 01:57]*
//삼성전기, 고수익 기업에서 평범한 기업 됐다[2024.08.13 오후 01:57]*
//...
//임종룡 우리금융 회장, 비은행 부문 새판 본격화[2024.08.13 오후 01:57]
			
			
			
	out.print(newsTitle.length + "|");
	for(int i=0; i<newsTitle.length; i++){
		
		out.print(newsTitle[i] + " [" + new Date() + "]");
		
		if(i!=(newsTitle.length-1)){
			out.print("*");
		}
	}

%>