package com.searchDB;

import java.util.Scanner;

import com.mondayFinal.MondayFinalDAO;


public class Search {

	Scanner sc = new Scanner(System.in);
	SearchDAO dao = new SearchDAO();

	public void searchId() {

		try {
			System.out.print("아이디에 등록된 이름을 입력하세요. : ");
			String name = sc.next();

			System.out.print("아이디에 등록된 휴대폰 번호를 입력하세요. ex)010-1234-1234 : ");
			String tel = sc.next();

			SearchDTO dto = dao.getSearchId(name, tel);

			if(dto!=null) {

				String id = dto.getId();

				String replacedid = id.substring(0, id.length() - 3) + "***";

				System.out.println("입력하신 정보와 일치하는 아이디는 "+ replacedid +" 입니다.");

			}else {
				System.out.println("입력하신 정보와 일치하는 아이디 찾을 수 없습니다.");
			}


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void searchPw() {

		try {
			System.out.print("아이디를 입력하세요. : ");
			String id = sc.next();

			System.out.print("이름을 입력하세요. : ");
			String name = sc.next();

			System.out.print("주민등록번호를 입력하세요. ex)801221-1234567 : ");
			String jumin = sc.next();

			SearchDTO dto = dao.getSearchPw(id, name, jumin);

			if(dto!=null) {

				String newpw;

				while(true) {

					System.out.print("변경하실 비밀번호를 입력하세요 :");
					newpw = sc.next();
					if(MondayFinalDAO.checkPassword(newpw)) {
						break;
					}else {
						System.out.println("비밀번호는 영문,숫자,특수문자를 혼용해야만 합니다.\n");
					}
					
				}

				dao.getInPw(dto.getId(), newpw);
				System.out.println("변경이 완료 되었습니다.");

			}else {
				System.out.println("입력하신 정보와 일치하는 계정을 찾을 수 없습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}


