package com.board;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.util.MyPage;
import com.util.dao.CommonDAO;
import com.util.dao.CommonDAOImpl;

public class BoardAction extends DispatchAction{
	
	
	public ActionForward created(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String mode = request.getParameter("mode");
		
		if(mode==null) {
			
			request.setAttribute("mode","insert");
			
			
		}else {	//mode='update'
			
			CommonDAO dao = CommonDAOImpl.getInstance();
			
			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
					
			
			BoardForm dto = (BoardForm)dao.getReadData("board.readData", num);
			
			if(dto==null) {
				return mapping.findForward("list");
			}
			
			
			
			request.setAttribute("mode","updateOK");
			request.setAttribute("dto",dto);
			request.setAttribute("pageNum",pageNum);
			
			
		}
		
		return mapping.findForward("created");
	}
	
	public ActionForward created_ok(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();	//객체 생성
		
		
		BoardForm f = (BoardForm)form;
		
		String mode = request.getParameter("mode");
		
		if(mode.equals("insert")) {
			
			int maxNum = dao.getIntValue("board.maxNum");
			
			f.setNum(maxNum+1);
			f.setIpAddr(request.getRemoteAddr());
			
			dao.insertData("board.insertData", f);
			
			
		}else {
			
			
			String pageNum = request.getParameter("pageNum");
			
			dao.updateData("board.updateData", f);
			
			//pageNum 넘기는 방법
			
			HttpSession session = request.getSession();
			session.setAttribute("pageNum", pageNum);
			
		}
		
		
		
		return mapping.findForward("created_ok");
	}
	
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		String cp = request.getContextPath();
		
		MyPage myPage = new MyPage();
		
		int numPerPage = 5;
		int totalPage = 0;
		int totalDataCount = 0;
		
		String pageNum = request.getParameter("pageNum");
		
		int currentPage = 1;
		
		//update, delete 후 세션의 pageNum 받기
		HttpSession session = request.getSession();
		
		if(pageNum==null) {
			pageNum = (String)session.getAttribute("pageNum");
			
		}
		
		session.removeAttribute("pageNum");
		
		if(pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue==null) {
			searchKey = "subject";
			searchValue = "";
			
		}
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		
		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		
		totalDataCount = dao.getIntValue("board.dataCount", hMap);
		
		if(totalDataCount!=0) {
			totalPage = myPage.getPageCount(numPerPage, totalDataCount);
		}
		
		if(currentPage>totalPage) {
			currentPage=totalPage;
		}
		
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		hMap.put("start", start);
		hMap.put("end", end);
		
		List<Object> lists = dao.getListData("board.listData", hMap);
	
		String param = "";
		String urlArticle = "";
		String urlList = "";
		
		if(!searchValue.equals("")) {
			
			searchValue = URLEncoder.encode(searchValue,"UTF-8");
			
			param = "&searchKey = " + searchKey;
			param+= "&searchValue = " + searchValue;
		}
		
		urlList = cp + "/boardTest.do?method=list" + param;
		urlArticle = cp + "/boardTest.do?method=article&pageNum=" + currentPage;
		urlArticle+= param;
		
		request.setAttribute("lists", lists);
		request.setAttribute("urlArticle", urlArticle);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("pageIndexList", myPage.pageIndexList(currentPage, totalPage, urlList));
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalDataCount", totalDataCount);


		
		return mapping.findForward("list");
		
	}
	
	public ActionForward article(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		String cp = request.getContextPath();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue==null) {
			searchKey = "subject";
			searchValue = "";
		}
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		dao.updateData("board.hitCountUpdate", num);
		
		BoardForm dto = (BoardForm)dao.getReadData("board.readData", num);
		
		if(dto==null) {
			return mapping.findForward("list");
		}
		
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("num", num);
		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		
		String preUrl = "";
		String preSubject = "";
		BoardForm preDTO = (BoardForm)dao.getReadData("board.preReadData", hMap);
		
		if(preDTO!=null) {
			preUrl = cp + "/boardTest.do?method=article&pageNum=" + pageNum;
			preUrl+="&num="+preDTO.getNum();
			preSubject = preDTO.getSubject();
		}
		
		String nextUrl = "";
		String nextSubject = "";
		BoardForm nextDTO = (BoardForm)dao.getReadData("board.nextReadData", hMap);
		
		if(nextDTO!=null) {
			nextUrl = cp + "/boardTest.do?method=article&pageNum=" + pageNum;
			nextUrl+="&num="+nextDTO.getNum();
			nextSubject = nextDTO.getSubject();
		}
		
		String urlList = cp + "/boardTest.do?method=list&paguNum=" + pageNum;
		
		if(!searchValue.equals("")) {
			
			searchValue = URLEncoder.encode(searchValue, "UTF-8");
			
			urlList += "&searchKey=" + searchKey + "&searchValue=" + searchValue;
			
			if(!preUrl.equals("")) {
				preUrl += "&searchKey=" + searchKey + "&searchValue=" + searchValue;
			}
			if(!nextUrl.equals("")) {
				nextUrl += "&searchKey=" + searchKey + "&searchValue=" + searchValue;
			}
		}
		
		//수정 삭제 링크
		
		String paramArticle = "num=" + num + "&pageNum=" + pageNum;
		
		request.setAttribute("dto", dto);
		request.setAttribute("preSubject", preSubject);
		request.setAttribute("preUrl", preUrl);
		request.setAttribute("nextSubject", nextSubject);
		request.setAttribute("nextUrl", nextUrl);
		request.setAttribute("lineSu", lineSu);
		request.setAttribute("paramArticle", paramArticle);
		request.setAttribute("urlList", urlList);
		
		return mapping.findForward("article");
		
		
	}
	
	public ActionForward deleted(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		String pageNum = request.getParameter("pageNum");
		
		dao.deleteData("board.deleteData", num);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("pageNum", pageNum);
		
		//return mapping.findForward("deleted");
		
		ActionForward af = new ActionForward();
		af.setRedirect(true);
		af.setPath("/boardTest.do?method=list&pageNum=" + pageNum);
		
		return af;
		
		
	}

}
