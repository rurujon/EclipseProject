package com.bbs;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.util.MyPage;
import com.util.dao.CommonDAO;

@Controller("bbs.boardController")
public class BoardController {

	@Resource(name = "dao")
	private CommonDAO dao;
	//commonDAOImpl이 들어옴
	
	@Resource(name = "myPage")
	private MyPage myPage;
	
	@RequestMapping(value = "/bbs/created.action", method = {RequestMethod.GET,RequestMethod.POST})
	public String created(BoardCommand command, HttpServletRequest req, HttpServletResponse resp) 
			throws Exception{
		
		if(command==null||command.getMode()==null||command.getMode().equals("")) {
			
			req.setAttribute("mode", "insert");
			
			return "board/created"; //입력창
		}
		
		int maxNum = dao.getIntValue("bbs.maxNum"); //board_sqlMap.xml
		
		
		command.setNum(maxNum + 1);
		command.setIpAddr(req.getRemoteAddr());
		
		dao.insertData("bbs.insertData", command);
		
		return "redirect:/bbs/list.action";
	}
	
	@RequestMapping(value = "/bbs/list.action",
			method = {RequestMethod.GET, RequestMethod.POST})
	public String list(BoardCommand command,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		
		String cp = request.getContextPath();
		
		int numPerPage = 5;
		int totalPage = 0;
		int totalDataCount = 0;
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum==null) {
			pageNum = (String)session.getAttribute("pageNum");
		}
		
		session.removeAttribute("pageNum");
		
		int currentPage = 1;
		if(pageNum!=null && !pageNum.equals("")) {
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
		
		totalDataCount = dao.getIntValue("bbs.dataCount", hMap);
		
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
		
		List<Object> lists = dao.getListData("bbs.listData", hMap);
		
		int listNum,n = 0;
		Iterator<Object> it = lists.iterator();
		
		while(it.hasNext()) {
			
			BoardCommand vo = (BoardCommand)it.next();
			
			listNum = totalDataCount - (start + n - 1);
			vo.setListNum(listNum);
			
			n++;
		}
		
		String params = "";
		String urlList = "";
		String urlArticle = "";
		
		if(!searchValue.equals("")) {
			searchValue = URLEncoder.encode(searchValue,"UTF-8");
			params = "searchKey=" + searchKey;
			params+="&searchValue=" + searchValue;
		}
		
		if(params.equals("")) {
			urlList = cp + "/bbs/list.action";
			urlArticle = cp + "/bbs/article.action?pageNum=" + currentPage;
		}else {
			urlList = cp + "/bbs/list.action?" + params;
			urlArticle = cp + "/bbs/article.action?pageNum=" + currentPage + "&" +  params;
		}
		
		request.setAttribute("lists", lists);
		request.setAttribute("urlArticle", urlArticle);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList", myPage.pageIndexList(currentPage, totalPage, urlList));
		
		
		return "board/list";
	}
	
	
	
	
	
	@RequestMapping(value = "/bbs/article.action",
			method = {RequestMethod.GET, RequestMethod.POST})
	public String article(BoardCommand command,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue==null) {
			searchKey = "subject";
			searchValue = "";
		}
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue,"UTF-8");
		}
		
		dao.updateData("bbs.hitCountUpdate", num);
		
		BoardCommand dto = (BoardCommand)dao.getReadData("bbs.readData", num);
		
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		hMap.put("num", num);
		
		BoardCommand preReadData = (BoardCommand)dao.getReadData("bbs.preReadData", hMap);
		
		int preNum = 0;
		
		String preSubject = "";
		if(preReadData!=null) {
			preNum = preReadData.getNum();
			preSubject = preReadData.getSubject();
		}
		
		
		BoardCommand nextReadData = (BoardCommand)dao.getReadData("bbs.nextReadData", hMap);
		
		int nextNum = 0;
		
		String nextSubject = "";
		if(nextReadData!=null) {
			nextNum = nextReadData.getNum();
			nextSubject = nextReadData.getSubject();
		}
		
		String params = "pageNum=" + pageNum;
		if(!searchValue.equals("")) {
			searchValue = URLDecoder.decode(searchValue,"UTF-8");
			params += "&searchKey=" + searchKey +
					"&searchValue=" + searchValue;
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("preNum", preNum);
		request.setAttribute("preSubject", preSubject);
		request.setAttribute("nextNum", nextNum);
		request.setAttribute("nextSubject", nextSubject);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("params", params);
		request.setAttribute("lineSu", lineSu);
		
		return "board/article";
		
		
	}
	
	@RequestMapping(value = "/bbs/updated.action",
			method = {RequestMethod.GET})
	public String updateForm(BoardCommand command,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardCommand dto = (BoardCommand)dao.getReadData("bbs.readData",num);
		
		request.setAttribute("mode", "update");
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
		
		
		return "board/created";
	}
	
	
	
	@RequestMapping(value = "/bbs/updated.action",
			method = {RequestMethod.POST})
	public String updated(BoardCommand command,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		
		dao.updateData("bbs.updateData", command);
		
		//session.setAttribute("pageNum", command.getPageNum());
		
		
		
		return "redirect:/bbs/list.action?pageNum=" + command.getPageNum();
	}
	
	
	@RequestMapping(value = "/bbs/deleted.action",
			method = {RequestMethod.GET})
	public String deleted(BoardCommand command,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		dao.deleteData("bbs.deleteData", num);
		
		return "redirect:/bbs/list.action?pageNum=" + pageNum;
		
	}
	
	
}
