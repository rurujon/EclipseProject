<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.util.MyPage"%>
<%@page import="com.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>


<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
	
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	MyPage myPage = new MyPage();
	
	//넘어온 페이지 번호(Mypage,update,delete)
	String pageNum = request.getParameter("pageNum");
	
	int currentPage = 1;
	
	if(pageNum!=null){
		
		currentPage = Integer.parseInt(pageNum);
		
	}
	
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
	
	
	//전체 데이터 갯수
	int dataCount =  dao.getDataCount(searchKey,searchValue);
	
	//한페이지에 출력할 데이터의 갯수
	int numPerPage = 3;
	
	int totalPage = myPage.getPageCount(numPerPage, dataCount);
	
	//System.out.print(totalPage); <-페이지 개수 중간에 확인
	
	//전체페이지 수보다 표시할 페이지가 큰 경우
	//표시할 페이지를 전체 페이지로 만들기 위한 코딩
	if(currentPage>totalPage){
		currentPage = totalPage;
	}
	
	//데이터베이스에서 가져올 rownum의 시작과 끝위치
	int start = (currentPage-1)*numPerPage+1;
	int end = currentPage*numPerPage;
	//=int end = start + numPerPage - 1;
	

	
	List<BoardDTO> lists = dao.getLists(start,end,searchKey,searchValue);
	
	//검색--------------------------------
	String param = "";
	if(!searchValue.equals("")){
		
		param="?searchKey=" + searchKey;
		param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");	
	}
	//검색-----------------------------------
	
	//페이징 처리
	String listUrl = "list.jsp";
	String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
	
	//article 주소 정리
	
	String articleUrl = cp + "/board/article.jsp";
	
	if(param.equals("")){
		articleUrl += "?pageNum=" + currentPage;
	}else{
		articleUrl += param+"&pageNum="+currentPage;
	}
	
	DBConn.close();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<link rel="stylesheet" type="text/css" href="<%=cp %>/board/css/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp %>/board/css/list.css"/>

<script type = "text/javascript">

	function sendIt(){
		
		var f=document.searchForm;
		
		f.action = "<%=cp%>/board/list.jsp"
		f.submit();
	}

</script>

</head>
<body>

<div id="bbsList">
	<div id="bbsList_title">
	게시판
	</div>
	
	<div id="bbsList_header">
		<div id="leftHeader">
			<form action="" method="post" name="searchForm">
				<select name="searchKey" class="selectFiled"> 
					<option value="subject">제목</option>
					<option value="name">작성자</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="searchValue" class="textFiled"/>
				<input type="button" value=" 검 색 " class="btn2"
				onclick="sendIt();"/>
			</form>
		</div>
		<div id="rightHeader">
			<input type="button" value=" 글올리기 " class="btn2" 
			onclick="javascript:location.href='<%=cp %>/board/created.jsp';">
		</div>
	</div>
	
	<div id="bbsList_list">
		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">제목</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">조회수</dt>
			</dl>
		</div>

	
	
		<div id="lists">
		<%for(BoardDTO dto : lists){ %>
			<dl>
				<dd class="num"><%=dto.getNum() %></dd>
				<dd class="subject">
				<a href="<%=articleUrl %>&num=<%=dto.getNum()%>"><%=dto.getSubject() %></a>
				</dd>
				<dd class="name"><%=dto.getName() %></dd>
				<dd class="created"><%=dto.getCreated() %></dd>
				<dd class="hitCount"><%=dto.getHitCount() %></dd>
			</dl>
		<%} %>
		</div>
		
		<div id="footer">
			<p>
			<%if(dataCount!=0){ %>
				<%=pageIndexList %>
			<%}else { %>
				등록된 게시물이 없습니다.
			<%} %>
			</p>
		</div>
		
		
	</div>

</div>


</body>
</html>