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
			System.out.println("�α����� ���̵�?");
			userid = sc.next();
			System.out.println("�α����� ��й�ȣ?");
			userpw = sc.next();
			
			dto = dao.getLogin(userid, userpw);
			
			
			if(dto==null) {
				

				System.out.println("���̵� �����ϴ�.");


			}


			if(dto!=null) {

				String pw = dto.getPw();

				if(!userpw.equals(pw)) { 
					System.out.println("��й�ȣ�� Ʋ���ϴ�.");
				}


			}

			System.out.println("�α����� �Ǿ����ϴ�");
			System.out.println();
			

			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		dto.setId(userid);
		return dto;

	}

}
