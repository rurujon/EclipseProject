package com.monday;

import java.util.Scanner;

public class Login {
	
	public LoginDTO login() {
		
		Scanner sc = new Scanner(System.in);
		LoginDTO dto = new LoginDTO();
		LoginDAO dao = new LoginDAO();
		
		String userid = null;
		String userpw;
		
		try {
			System.out.println("로그인할 아이디?");
			userid = sc.next();
			System.out.println("로그인할 비밀번호?");
			userpw = sc.next();
			
			dto = dao.getLogin(userid, userpw);
			
			
			if(dto==null) {
				

				System.out.println("아이디가 없습니다.");


			}


			if(dto!=null) {

				String pw = dto.getPw();

				if(!userpw.equals(pw)) { 
					System.out.println("비밀번호가 틀립니다.");
				}


			}

			System.out.println("로그인이 되었습니다");
			System.out.println();
			

			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		dto.setId(userid);
		return dto;

	}

}
