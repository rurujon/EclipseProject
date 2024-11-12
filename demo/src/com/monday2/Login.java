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
			System.out.print("���̵� : ");
			userid = sc.next();
			System.out.print("��й�ȣ : ");
			userpw = sc.next();
			
			dto = dao.getLogin(userid, userpw);
			
			if(dto!=null) {
				
				String pw = dto.getPw();
				
				if(userpw.equals(pw)) {
					System.out.println("�α����� �Ǿ����ϴ�.");
					dto.setId(userid);
					return dto;
				}else {
					System.out.println("��й�ȣ�� Ʋ���ϴ�.");
					return null;
				}
			}else {
				System.out.println("���̵� �����ϴ�.");
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("�α��� �� ������ �߻��߽��ϴ�.");
			return null;
		}
	
	}

}
