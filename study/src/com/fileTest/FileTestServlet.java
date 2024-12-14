package com.fileTest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

public class FileTestServlet extends HttpServlet{
	
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
		
		req.setCharacterEncoding("UTF-8");
		String cp = req.getContextPath();
		
		Connection conn = DBConn.getConnection();
		FileTestDAO dao = new FileTestDAO(conn);
		
		MyPage myPage = new MyPage();
		
		
		
		String uri = req.getRequestURI();
		String url;
		
		
		//���� ���� ��� ����
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "saveFile";
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
			
		}
		
		if(uri.indexOf("write.do")!=-1) {
			
			url = "/file/write.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("write_ok.do")!=-1) {
			
			//���� ���ε�
			String encType = "utf-8";
			int maxSize = 10*1024*1024;
			
			MultipartRequest mr = 
					new MultipartRequest(req, path, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			//���� �� ���� ���� DB ����
			if(mr.getFile("upload")!=null) {
				
				int maxNum = dao.getMaxNum();
				
				FileTestDTO dto = new FileTestDTO();
				
				dto.setNum(maxNum + 1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("upload"));
				dto.setOriginalFileName(mr.getOriginalFileName("upload"));
				
				dao.insertData(dto);
				
			}
			
			url = cp + "/fileTest/list.do";
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum=req.getParameter("pageNum");
			
			int currentPage = 1;
			
			if(pageNum!=null){
				
				currentPage = Integer.parseInt(pageNum);
				
			}
			
			
			//��ü ������ ����
			int dataCount =  dao.getDataCount();
			
			//���������� ����� �������� ����
			int numPerPage = 3;
			
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			
			//System.out.print(totalPage); <-������ ���� �߰��� Ȯ��
			
			//��ü������ ������ ǥ���� �������� ū ���
			//ǥ���� �������� ��ü �������� ����� ���� �ڵ�
			if(currentPage>totalPage){
				currentPage = totalPage;
			}
			
			//�����ͺ��̽����� ������ rownum�� ���۰� ����ġ
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage;
			//=int end = start + numPerPage - 1;
			
			
			
			
			List<FileTestDTO> lists = dao.getLists(start,end);
			
			
			//����¡ ó��
			String listUrl = cp + "/fileTest/list.do";
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			
			
			
			String downloadPath = cp + "/fileTest/download.do";
			String deletePath = cp + "/fileTest/delete.do";
			

			//�̹��� �Խ���--------------
			String imagePath = cp + "/pds/saveFile";
			req.setAttribute("imagePath", imagePath);
			//�̹����Խ���---------------
			
			
			req.setAttribute("downloadPath", downloadPath);
			req.setAttribute("deletePath", deletePath);
			
			
			
			
			
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("pageNum", currentPage);
			
			req.setAttribute("lists", lists);
			
			url = "/file/list.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("delete.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num);
			
			//���� ����
			FileManager.doFileDelete(dto.getSaveFileName(), path);
			//DB ����
			dao.deleteData(num);
			
			url = cp+"/fileTest/list.do";
			resp.sendRedirect(url);
			
			
			
		}else if(uri.indexOf("download.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num);
			
			if(dto==null) {
				return;
			}
			
			boolean flag =
					FileManager.doFileDownload(resp, dto.getSaveFileName(), dto.getOriginalFileName(), path);
			
			
			if(flag==false) {
				
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = resp.getWriter();
				
				out.print("<script type='text/javascript'>");
				out.print("alert('Download Error');");
				out.print("history.back();");
				out.print("</script>");
			}
			
			
		}
		
	}

}
