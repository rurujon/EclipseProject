package com.monday2;

import java.util.Scanner;

public class Login {
	
	public LoginDTO login() {
		
		Scanner sc = new Scanner(System.in);
		LoginDTO dto = new LoginDTO();
		LoginDAO dao = new LoginDAO();
		
		String userid;
		String userpw;
		
		try {
			System.out.print("아이디 : ");
			userid = sc.next();
			System.out.print("비밀번호 : ");
			userpw = sc.next();
			
			dto = dao.getLogin(userid, userpw);
			
			if(dto!=null) {
				
				String pw = dto.getPw();
				
				if(userpw.equals(pw)) {
					System.out.println("로그인이 되었습니다.");
					dto.setId(userid);
					return dto;
				}else {
					System.out.println("비밀번호가 틀립니다.");
					return null;
				}
			}else {
				System.out.println("아이디가 없습니다.");
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("로그인 중 오류가 발생했습니다.");
			return null;
		}
	
	}

}
