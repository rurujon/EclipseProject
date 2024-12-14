package com.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.join.CustomInfo;
import com.util.DBConn;
import com.util.MyPage;

//controller
public class BoardServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		String cp=req.getContextPath();	//	/study
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		MyPage myPage = new MyPage();
		
		String uri = req.getRequestURI();	//	/study/bbs/created.do
		String url;
		
		//	/bbs/created.do
		if(uri.indexOf("created.do")!=-1) {
			
			HttpSession session = req.getSession();
			
			CustomInfo info=(CustomInfo) session.getAttribute("customInfo");
			
			if(info==null) {
				
				url="/member/login.jsp";
				forward(req, resp, url);
				return;
				
			}
			
			url="/boardTest/created.jsp";
			
			forward(req, resp, url);
			
			//RequestDispatcher rd = req.getRequestDispatcher("/boardTest/created.jsp");
			//rd.forward(req, resp);
			
		}else if(uri.indexOf("created_ok.do")!=-1) {
			
			BoardDTO dto = new BoardDTO();
			
			int maxNum= dao.getMaxNum();
			
			dto.setNum(maxNum+1);
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			dto.setIpAddr(req.getRemoteAddr());
			
			dao.insertData(dto);
			
			url=cp+"/bbs/list.do";
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			//넘어온 페이지 번호(Mypage,update,delete)
			String pageNum = req.getParameter("pageNum");
			
			int currentPage = 1;
			
			if(pageNum!=null){
				
				currentPage = Integer.parseInt(pageNum);
				
			}
			
			//검색--------------------------------------
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null){
				
				//넘어온 방식이 GET 방식일때
				if(req.getMethod().equalsIgnoreCase("GET")){
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
			String listUrl = cp + "/bbs/list.do";
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			
			//article 주소 정리
			
			String articleUrl = cp + "/bbs/article.do";
			
			if(param.equals("")){
				articleUrl += "?pageNum=" + currentPage;
			}else{
				articleUrl += param+"&pageNum="+currentPage;
			}
			
			//포워딩 페이지에 넘길 데이터
			req.setAttribute("lists", lists);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("articleUrl", articleUrl);

			
			url="/boardTest/list.jsp";
			forward(req, resp, url);
			
			//RequestDispatcher rd = req.getRequestDispatcher("/boardTest/list.jsp");
			//rd.forward(req, resp);
			
		}else if(uri.indexOf("article.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			//검색--------------------------------------
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
				
			if(searchValue!=null){
				
				//넘어온 방식이 GET 방식일때
				if(req.getMethod().equalsIgnoreCase("GET")){
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}else{
				searchKey="subject";
				searchValue="";
			}
				
				
				
			//검색--------------------------------------
			
			
			//조회수 증가
			dao.updateHitCount(num);
			
			//글 가져오기
			BoardDTO dto = dao.getReadData(num);
			
			if(dto==null){
				url=cp+"/bbs/list.do";
				resp.sendRedirect(url);
			}
			
			//글 라인수
			int lineSu = dto.getContent().split("\n").length;
			
			//글 내용의 엔터를 <br/>로 변경
			dto.setContent(dto.getContent().replace("\n", "<br/>"));
			
			//검색--------------------------------
			String param = "pageNum=" + pageNum;
			if(!searchValue.equals("")){
					
				param+="&searchKey=" + searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");	
			}
			//검색-----------------------------------
			
			req.setAttribute("dto", dto);
			req.setAttribute("params", param);
			req.setAttribute("lineSu", lineSu);
			req.setAttribute("pageNum", pageNum);
			
			url="/boardTest/article.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("updated.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			//검색--------------------------------------
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
				
			if(searchValue!=null){
					
				//넘어온 방식이 GET 방식일때
				if(req.getMethod().equalsIgnoreCase("GET")){
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}else{
				searchKey="subject";
				searchValue="";
			}
				
			
			//검색--------------------------------------
			
			
			BoardDTO dto = dao.getReadData(num);
			
			//검색--------------------------------
			String param = "pageNum=" + pageNum;
			if(!searchValue.equals("")){
				
				param+="&searchKey=" + searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");	
			}
			//검색-----------------------------------
			
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("params", param);
			req.setAttribute("searchKey", searchKey);
			req.setAttribute("searchValue", searchValue);
			
			url = "/boardTest/updated.jsp";
			forward(req, resp, url);
			
			
			
		}else if(uri.indexOf("updated_ok.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			//검색--------------------------------------
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null){
				
				//넘어온 방식이 GET 방식일때
				if(req.getMethod().equalsIgnoreCase("GET")){
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}else{
				searchKey="subject";
				searchValue="";
			}
				
				
				
			//검색--------------------------------------
			
			
		
			
			
			BoardDTO dto = new BoardDTO();
			
			dto.setNum(Integer.parseInt(req.getParameter("num")));
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			
			dao.updateData(dto);
			
			//검색--------------------------------
			String param = "pageNum=" + pageNum;
			if(!searchValue.equals("")){
				
				param="&searchKey=" + searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");	
			}
			//검색-----------------------------------

			
			url=cp+"/bbs/list.do?" + param;
			resp.sendRedirect(url);			
			
			
			
		}else if(uri.indexOf("deleted_ok.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			//검색--------------------------------------
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null){
				
				//넘어온 방식이 GET 방식일때
				if(req.getMethod().equalsIgnoreCase("GET")){
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}else{
				searchKey="subject";
				searchValue="";
			}		
			//검색--------------------------------------
			
			
			
			dao.deleteData(num);
			
			//검색--------------------------------
			String param = "pageNum=" + pageNum;
			if(!searchValue.equals("")){
				
				param="&searchKey=" + searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");	
			}
			//검색-----------------------------------

			
			url=cp+"/bbs/list.do?" + param;
			resp.sendRedirect(url);
			
		}
	}

}