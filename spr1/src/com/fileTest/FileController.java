package com.fileTest;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
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
import org.springframework.web.multipart.MultipartFile;

import com.util.FileManager;
import com.util.MyPage;
import com.util.dao.CommonDAO;

@Controller("fileTest.fileController")
public class FileController {
	
	@Resource(name = "dao")
	private CommonDAO dao;
	
	@Resource(name = "myPage")
	private MyPage myPage;
	
	@Resource(name = "fileManager")
	private FileManager fileManager;
	
	@RequestMapping(value = "/file/write.action",
			method = {RequestMethod.GET, RequestMethod.POST})
	public String create(FileCommand command, HttpServletRequest request,
			HttpSession session) throws Exception{
		
		
		if(command.getUpload()==null) {
			return "file/write";
			
		}
		
		MultipartFile file = command.getUpload();
		InputStream is = file.getInputStream();
		
		String root = session.getServletContext().getRealPath("/");
		String savePath = root + "pds" + File.separator + "data";
		
		String originalFileName = command.getUpload().getOriginalFilename();
		
		String newFileName = FileManager.doFileUpload(is, originalFileName, savePath);
		
		int maxNum = dao.getIntValue("file.maxNum");
		
		command.setNum(maxNum + 1);
		command.setOriginalFileName(originalFileName);
		command.setSaveFileName(newFileName);
		
		dao.insertData("file.insertData", command);
		
		return "redirect:/file/list.action";
	}
	
	@RequestMapping(value = "/file/list.action",
			method = {RequestMethod.GET})
	public String list(HttpServletRequest request,
			HttpSession session) throws Exception{
		
		int numPerPage = 5;
		int totalPage = 0;
		int totalDataCount = 0;
		
		String cp = request.getContextPath();
		
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
		
		List<Object> lists = dao.getListData("file.listData",hMap);
		
		int listNum, n=0;
		
		String str;
		Iterator<Object> it = lists.iterator();
		while(it.hasNext()) {
			
			FileCommand vo = (FileCommand)it.next();
			
			listNum = totalDataCount - (start+n-1);
			
			vo.setListNum(listNum);
			
			n++;
			
			str = cp + "/file/download.action?num=" + vo.getNum();
			vo.setUrlFile(str);
		}
		
		String urlList = cp + "/file/list.action";
		
		request.setAttribute("lists", lists);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList", myPage.pageIndexList(currentPage, totalPage, urlList));
		
		return "file/list";

		
	}
	
	@RequestMapping(value = "/file/download.action",
			method = {RequestMethod.GET})
	public String download(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception{
		
		String root = session.getServletContext().getRealPath("/");
		String savePath = root + "pds" + File.separator + "data";
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		FileCommand dto = 
				(FileCommand)dao.getReadData("file.readData", num);
		
		boolean flag =
				FileManager.doFileDownload(response, dto.getSaveFileName(), dto.getOriginalFileName(), savePath);
		
		if(!flag) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('다운로드 에러!');");
			out.print("history.back();");
			out.print("</script>");
		}
		
		return null;
		
	}
	
	
	@RequestMapping(value = "/file/delete.action",
			method = {RequestMethod.GET})
	public String delete(HttpServletRequest request,
			HttpSession session) throws Exception{
		
		String root = session.getServletContext().getRealPath("/");
		String savePath = root + "pds" + File.separator + "data";
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		FileCommand dto = 
				(FileCommand)dao.getReadData("file.readData", num);
		
		FileManager.doFileDelete(dto.getSaveFileName(), savePath);
		
		dao.deleteData("file.deleteData", num);
		
		return "redirect:/file/list.action";
		
		
	}

}
