package com.join;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.util.DBConn;

public class MemberServlet extends HttpServlet{

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
		
		Connection conn = DBConn.getConnection();
		MemberDAO dao = new MemberDAO(conn);
		
		String cp = req.getContextPath();
		String uri=req.getRequestURI();
		
		String url;
		
		if(uri.indexOf("created.do")!=-1) {
			
			url = "/member/created.jsp";
			forward(req, resp, url);
		}else if(uri.indexOf("created_ok.do")!=-1) {
			
			MemberDTO dto=new MemberDTO();
			
			dto.setUserId(req.getParameter("userId"));
			dto.setUserPwd(req.getParameter("userPwd"));
			dto.setUserName(req.getParameter("userName"));
			dto.setUserBirth(req.getParameter("userBirth"));
			dto.setUserTel(req.getParameter("userTel"));
			
			dao.insertData(dto);
			
			url = cp;	//"index.jsp"
			resp.sendRedirect(url);
		}else if(uri.indexOf("login.do")!=-1) {
			
			url="/member/login.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("login_ok.do")!=-1) {
			
			String userId=req.getParameter("userId");
			String userPwd=req.getParameter("userPwd");
			
			MemberDTO dto=dao.getReadData(userId);
			
			if(dto==null || (!dto.getUserPwd().equals(userPwd))) {
				
				req.setAttribute("message", "아이디 또는 패스워드를 정확히 입력하세요");
				
				req.setAttribute("findPwd", "비밀번호 찾기");
				
				url = "/member/login.jsp";
				forward(req, resp, url);
				
				return;
			}
			
			//id pwd가 일치
			
			HttpSession session = req.getSession();
			
			CustomInfo info = new CustomInfo();
			
			info.setUserId(dto.getUserId());
			info.setUserName(dto.getUserName());
			
			session.setAttribute("customInfo", info);
			
			url = cp;
			resp.sendRedirect(url);
			
			
			
		}else if(uri.indexOf("logout.do")!=-1) {
			HttpSession session=req.getSession();
			
			session.removeAttribute("customInfo");
			//변수 안에 있는 내용물을 지운다.
			session.invalidate();
			//변수 자체를 지운다
			
			url=cp;
			resp.sendRedirect(url);
		}else if(uri.indexOf("searchPwd.do")!=-1) {
			
			url="/member/searchPwd.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("searchPwd_ok.do")!=-1) {
			
			String userId=req.getParameter("userId");
			String userTel=req.getParameter("userTel");
			
			MemberDTO dto=dao.getReadData(userId);

			if(dto==null || (!dto.getUserTel().equals(userTel))) {
				
				req.setAttribute("message", "회원 정보가 존재하지 않습니다.");
				
				url = "/member/login.jsp";
				forward(req, resp, url);
				
				return;
			}
			
			String userPwd=dto.getUserPwd();
			
			req.setAttribute("message", "비밀번호는 " + userPwd + " 입니다.");
			
			url = "/member/login.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("updated.do")!=-1) {
			
			HttpSession session = req.getSession();
			
			CustomInfo info = (CustomInfo)session.getAttribute("customInfo");
			
			String userId=req.getParameter("userId");
			
			MemberDTO dto=dao.getReadData(userId);
			
			req.setAttribute("dto", dto);
			
			url ="/member/updated.jsp";
			forward(req, resp, url);
		}else if(uri.indexOf("updated_ok.do")!=-1) {
			
			
			MemberDTO dto=new MemberDTO();
			
			dto.setUserId(req.getParameter("userId"));
			dto.setUserName(req.getParameter("userName"));
			dto.setUserPwd(req.getParameter("userPwd"));
			dto.setUserBirth(req.getParameter("userBirth"));
			dto.setUserTel(req.getParameter("userTel"));
			
			dao.updateData(dto);
			
			
			url = "/member/login.jsp";
			forward(req, resp, url);
			
		}
		
	}

}
