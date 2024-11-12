package com.file;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.util.FileManager;
import com.util.MyPage;
import com.util.dao.CommonDAO;
import com.util.dao.CommonDAOImpl;

public class FileAction extends DispatchAction{
	
	
	public ActionForward write(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		return mapping.findForward("write");
		
		
	}
	
	public ActionForward write_ok(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		HttpSession session = request.getSession();
		
		String root = session.getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "saveFile";
		
		FileForm f = (FileForm)form;
		
		//파일업로드
		
		String newFileName = FileManager.doFileUpload(f.getUpload(), path);
		
		//DB에 저장
		if(newFileName!=null) {
			
			int maxNum = dao.getIntValue("file.maxNum");
			
			f.setNum(maxNum + 1);
			f.setSaveFileName(newFileName);
			f.setOriginalFileName(f.getUpload().getFileName());
			
			dao.insertData("file.insertData", f);
		}
		
		
		return mapping.findForward("write_ok");
		
		
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		MyPage myPage = new MyPage();
		
		String cp = request.getContextPath();
		
		int numPerPage = 5;
		int totalPage = 0;
		int totalDataCount = 0;
		
		String pageNum = request.getParameter("pageNum");
		
		int currentPage = 1;
		
		if(pageNum!=null && !pageNum.equals("")) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		totalDataCount = dao.getIntValue("file.dataCount");
		
		if(totalDataCount!=0) {
			totalPage = myPage.getPageCount(numPerPage, totalDataCount);
		}
		
		if(currentPage>totalPage) {
			currentPage=totalPage;
		}
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		hMap.put("start", start);
		hMap.put("end", end);
		
		List<Object> lists = (List<Object>)dao.getListData("file.listData", hMap);
		
		//일련번호
		
		Iterator<Object> it = lists.iterator();
		int listNum, n=0;
		String str;
		
		while(it.hasNext()) {
			FileForm dto = (FileForm)it.next();
			
			listNum = totalDataCount - (start + n - 1);
			
			dto.setListNum(listNum);
			
			n++;
			
			//파일 다운로드 경로 설정
			str = cp + "/fileTest.do?method=download&num=" + dto.getNum();
			dto.setUrlFile(str);
			
		}
		
				
		String urlList = cp + "/fileTest.do?method=list";
		request.setAttribute("lists", lists);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList", myPage.pageIndexList(currentPage, totalPage, urlList));
		
		return mapping.findForward("list");
		
		
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		HttpSession session = request.getSession();
		
		String root = session.getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "saveFile";
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		FileForm dto = (FileForm)dao.getReadData("file.readData",num);
		
		//파일 삭제
		FileManager.doFileDelete(dto.getSaveFileName(), path);
		
		//db 삭제
		dao.deleteData("file.deleteData",num);
		return mapping.findForward("delete_ok");
		
	}
	
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		HttpSession session = request.getSession();
		
		String root = session.getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "saveFile";
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		FileForm dto = (FileForm)dao.getReadData("file.readData",num);
		
		boolean flag = 
				FileManager.doFileDownload(response, dto.getSaveFileName(), dto.getOriginalFileName(), path);
		
		if(!flag) {
			
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('download error!');");
			out.print("history.back()");
			out.print("</script>");
		}
		
		return mapping.findForward(null);
	}

}
