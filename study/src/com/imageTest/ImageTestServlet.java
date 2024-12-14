package com.imageTest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fileTest.FileTestDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

public class ImageTestServlet extends HttpServlet{

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
		String cp=req.getContextPath();	//	/study
		
		Connection conn = DBConn.getConnection();
		ImageTestDAO dao = new ImageTestDAO(conn);
		
		MyPage myPage = new MyPage();
		
		String uri = req.getRequestURI();
		String url;
		
		//파일 저장 경로 설정
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "imageFile";
				
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
			
		}
		if(uri.indexOf("write.do")!=-1) {
			
			url = "/imageTest/write.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("write_ok.do")!=-1) {
			
			//파일 업로드
			String encType = "utf-8";
			int maxSize = 10*1024*1024;
			
			MultipartRequest mr =
					new MultipartRequest(req, path, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			//검증 및 파일 정보 DB 저장
			if(mr.getFile("upload")!=null) {
				
				int maxNum = dao.getMaxNum();
				
				ImageTestDTO dto = new ImageTestDTO();
				
				dto.setNum(maxNum + 1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("upload"));
				dto.setOriginalFileName(mr.getOriginalFileName("upload"));
				
				dao.insertData(dto);
				
			}
			
			url = cp + "/image/list.do";
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum=req.getParameter("pageNum");
			
			int currentPage = 1;
			
			if(pageNum!=null){
				
				currentPage = Integer.parseInt(pageNum);
				
			}
			
			
			//전체 데이터 갯수
			int dataCount =  dao.getDataCount();
			
			//한페이지에 출력할 데이터의 갯수
			int numPerPage = 9;
			
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
			
			
			
			
			List<ImageTestDTO> lists = dao.getLists(start,end);
			
			
			//페이징 처리
			String listUrl = cp + "/image/list.do";
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			
			
			
			String downloadPath = cp + "/image/download.do";
			String deletePath = cp + "/image/delete.do";
			

			//이미지 게시판--------------
			String imagePath = cp + "/pds/imageFile";
			req.setAttribute("imagePath", imagePath);
			//이미지게시판---------------
			
			
			req.setAttribute("downloadPath", downloadPath);
			req.setAttribute("deletePath", deletePath);
			
			
			
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("currentPage", currentPage);
			
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("pageNum", currentPage);
			
			req.setAttribute("lists", lists);
			
			url = "/imageTest/list.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("delete.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			ImageTestDTO dto = dao.getReadData(num);
			
			//파일 삭제
			FileManager.doFileDelete(dto.getSaveFileName(), path);
			//DB 삭제
			dao.deleteData(num);
			
			url = cp+"/image/list.do";
			resp.sendRedirect(url);
			
			
			
		}
		
		
	}

}