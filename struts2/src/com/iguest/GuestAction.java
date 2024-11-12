package com.iguest;

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

public class GuestAction extends ActionSupport implements Preparable,ModelDriven<GuestDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GuestDTO dto;
	
//	guest.jsp 에서 AJAX 가 params로 데이터를 넘김.
//	public GuestDTO getDto() {
//		return dto;
//	}
	

	@Override
	public GuestDTO getModel() {
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		dto = new GuestDTO();
		
	}

	public String created() throws Exception{
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int numMax = dao.getIntValue("iguest.numMax");
		
		dto.setNum(numMax + 1);
		dto.setIpAddr(request.getRemoteAddr());
		
		dao.insertData("iguest.insertData", dto);
		
		return list();
		
	}
	
	public String list() throws Exception{
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		MyPage myPage = new MyPage();
		
		int numPerPage = 3;
		int totalPage = 0;
		int totalDataCount = 0;
		
		String pageNum = request.getParameter("pageNum");
		
		int currentPage = 1;
		
		if(pageNum!=null && !pageNum.equals("")) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		totalDataCount = dao.getIntValue("iguest.dataCount");
		
		if(totalDataCount!=0) {
			totalPage = myPage.getPageCount(numPerPage, totalDataCount);
		}
		
		if(currentPage>totalPage) {
			currentPage=totalPage;
		}
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		
		int start = (currentPage-1) * numPerPage + 1;
		int end = currentPage*numPerPage;
		
		hMap.put("start", start);
		hMap.put("end", end);
		
		List<Object> lists = dao.getListData("iguest.listData", hMap);
		
		int listNum, n=0;
		
		Iterator<Object> it = lists.iterator();
		while(it.hasNext()) {
			
			GuestDTO vo = (GuestDTO)it.next();
			
			listNum = totalDataCount - (start + n - 1);
			
			vo.setListNum(listNum);
			
			vo.setContent(vo.getContent().replaceAll("\n", "<br/>"));
			
			n++;
		}
		
		
		String pageIndexList =
				myPage.pageIndexList(currentPage, totalPage);
		
		request.setAttribute("lists", lists);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageNum", currentPage);
		
		return SUCCESS;
		
	}
	
	
	public String deleted() throws Exception{
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(num);
		
		dao.deleteData("iguest.deleteData", num);
		
		return list();
		
		
	}
	

}
