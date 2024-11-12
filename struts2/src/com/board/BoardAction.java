package com.board;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.util.MyPage;
import com.util.dao.CommonDAO;
import com.util.dao.CommonDAOImpl;

public class BoardAction extends ActionSupport
	implements Preparable, ModelDriven<BoardDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoardDTO dto;

	public BoardDTO getDto() {
		return dto;
	}

	@Override
	public BoardDTO getModel() {
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		
		dto = new BoardDTO();
	}
	
	
	public String created() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(dto==null||dto.getMode()==null||dto.getMode().equals("")) {
			
			request.setAttribute("mode", "create");
			
			return INPUT;
			
		}
		
		//입력
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		int maxNum = dao.getIntValue("board.maxNum");
		
		dto.setNum(maxNum+1);
		dto.setIpAddr(request.getRemoteAddr());
		dto.setGroupNum(dto.getNum());
		dto.setDepth(0);
		dto.setOrderNo(0);
		dto.setParent(0);
		
		dao.insertData("board.insertData", dto);
		
		return SUCCESS;
		
	}
	
	public String list() throws Exception{
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		MyPage myPage = new MyPage();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cp = request.getContextPath();
		
		int numPerPage = 10;
		int totalPage = 0;
		int totalDataCount = 0;
		
		int currentPage = 1;
		
		if(dto.getPageNum()!=null && !dto.getPageNum().equals("")) {
			currentPage = Integer.parseInt(dto.getPageNum());
		}
		
		if(dto.getSearchValue()==null||dto.getSearchValue().equals("")) {
			dto.setSearchKey("subject");
			dto.setSearchValue("");
		}
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			dto.setSearchValue(URLDecoder.decode(dto.getSearchValue(), "UTF-8"));
		}
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("searchKey", dto.getSearchKey());
		hMap.put("searchValue", dto.getSearchValue());
		
		totalDataCount = dao.getIntValue("board.dataCount", hMap);
		
		if(totalDataCount!=0) {
			
			totalPage = myPage.getPageCount(numPerPage, totalDataCount);
		}
		
		if(currentPage>totalPage) {
			currentPage = totalPage;
		}
		
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		hMap.put("start", start);
		hMap.put("end", end);
		
		List<Object> lists =
				(List<Object>)dao.getListData("board.listData",hMap);
		
		//일련번호
		int listNum, n = 0;
		
		Iterator<Object> it = lists.iterator();
		
		while(it.hasNext()) {
			
			BoardDTO vo = (BoardDTO)it.next();
			
			listNum = totalDataCount - (start + n - 1);
			
			vo.setListNum(listNum);
			n++;
			
		}
		
		String param = "";
		String urlList = "";
		String urlArticle = "";
		
		if(!dto.getSearchValue().equals("")) {
			param = "searchKey=" + dto.getSearchKey();
			param+= "&searchValue=" + 
					URLEncoder.encode(dto.getSearchValue(),"UTF-8");
		}
		
		urlList = cp + "/bbs/list.action";
		urlArticle = cp + "/bbs/article.action?pageNum=" + currentPage;
		
		if(!param.equals("")) {
			
			urlList += "?" + param;
			urlArticle += "&" + param;
		}
		
		request.setAttribute("lists", lists);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList", myPage.pageIndexList(currentPage, totalPage, urlList));
		request.setAttribute("urlArticle", urlArticle);
		
		return SUCCESS;
		
	}
	
	public String article() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		CommonDAO dao = CommonDAOImpl.getInstance();

		String searchKey = dto.getSearchKey();
		String searchValue = dto.getSearchValue();
		String pageNum = dto.getPageNum();
		int num = dto.getNum();
		
		
		
		if(searchValue==null||searchValue.equals("")) {
			searchKey = "subject";
			searchValue = "";
		}
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		dao.updateData("board.hitCountUpdate", num);
		
		
		dto= (BoardDTO)dao.getReadData("board.readData", num);
		
		dto.setSearchKey(searchKey);
		dto.setSearchValue(searchValue);
		dto.setPageNum(pageNum);
		
		
		int lineSu = dto.getContent().split("\n").length;
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		Map<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("searchKey", dto.getSearchKey());
		hMap.put("searchValue", dto.getSearchValue());
		hMap.put("groupNum", dto.getGroupNum());
		hMap.put("orderNo", dto.getOrderNo());
		
		BoardDTO preDTO =
				(BoardDTO)dao.getReadData("board.preReadData", hMap);
		
		int preNum = 0;
		String preSubject = "";
		
		if(preDTO!=null) {
			preNum = preDTO.getNum();
			preSubject = preDTO.getSubject();
		}
		
		BoardDTO nextDTO =
				(BoardDTO)dao.getReadData("board.nextReadData", hMap);
		
		int nextNum = 0;
		String nextSubject = "";
		
		if(nextDTO!=null) {
			nextNum = nextDTO.getNum();
			nextSubject = nextDTO.getSubject();
		}
		
		String param = "pageNum="+pageNum;
		if(!searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + 
					URLEncoder.encode(searchValue, "UTF-8");
		}
		
		request.setAttribute("preNum", preNum);
		request.setAttribute("preSubject", preSubject);
		request.setAttribute("nextNum", nextNum);
		request.setAttribute("nextSubject", nextSubject);
		
		request.setAttribute("params", param);
		request.setAttribute("lineSu", lineSu);
		request.setAttribute("pageNum", pageNum);
		
		
		return SUCCESS;
	}
	
	public String updated() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		if(dto.getMode()==null||dto.getMode().equals("")) {
			
			dto = (BoardDTO)dao.getReadData("board.readData", dto.getNum());
			
			request.setAttribute("mode", "update");
			request.setAttribute("pageNum", dto.getPageNum());
			
			return INPUT;
			
		}
		
		dao.updateData("board.updateData", dto);
		return SUCCESS;
	}
	
	public String reply() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		if(dto==null||dto.getMode()==null||dto.getMode().equals("")) {
			
			//부모의 데이터
			dto = (BoardDTO)dao.getReadData("board.readData", dto.getNum());
			
			String temp = "\r\n----------------------------------\r\n";
			temp += "[답변]\r\n";
			
			//부모의 데이터를 변경해서 내 데이터로 created.jsp에 출력
			dto.setSubject("[답변]" + dto.getSubject());
			dto.setContent(dto.getContent() + temp);
			dto.setName("");
			dto.setEmail("");
			dto.setPwd("");
			
			request.setAttribute("mode", "reply");
			request.setAttribute("pageNum", dto.getPageNum());
			
			return INPUT;
		}
		
		//답변 입력
		Map<String, Object> hMap = new HashMap<String, Object>();
		
		hMap.put("groupNum", dto.getGroupNum());
		hMap.put("orderNo", dto.getOrderNo());
		
		dao.updateData("board.orderNoUpdate", hMap);
		
		int maxNum = dao.getIntValue("board.maxNum");
		dto.setNum(maxNum+1);
		dto.setIpAddr(request.getRemoteAddr());
		dto.setDepth(dto.getDepth()+1);
		dto.setOrderNo(dto.getOrderNo()+1);
		
		dao.insertData("board.insertData", dto);
		
		
		
		
		return SUCCESS;
	}
	
	
	
	//삭제
	public String deleted() throws Exception{
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		dao.deleteData("board.deleteData", dto.getNum());
		
		return SUCCESS;
	}

}
