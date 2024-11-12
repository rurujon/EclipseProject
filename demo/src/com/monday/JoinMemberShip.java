package com.monday;

import java.util.Scanner;

public class JoinMemberShip {
	
	Scanner sc = new Scanner(System.in);

	JoinMemberShipDAO dao = new JoinMemberShipDAO();

	public void insert() {

		try {

			JoinMemberShipDTO dto = new JoinMemberShipDTO();

			System.out.print("이    름 : ");
			dto.setName(sc.next());

			System.out.print("주민번호 : ");
			dto.setJumin(sc.next());

			System.out.print("성    별 : ");
			dto.setGender(sc.next());

			System.out.print("전화번호 : ");
			dto.setTel(sc.next());

			try {

				while(true) {

					System.out.print("아이디(8~15자) : ");
					String userid = sc.next();

					if(!JoinMemberShipDAO.checkId(userid)) {
						System.out.println("아이디는 8~15자 이내의 영문 및 숫자만 가능합니다.");
						continue;
					}

					boolean exist = dao.idExist(userid);

					if(exist) {
						System.out.println("이미 있는 아이디입니다.");
					}else {
						dto.setId(userid);
						break;
					}

				}

				while(true) {

					System.out.print("비밀번호(영문,숫자,특수문자 혼용) : ");
					String password = sc.next();

					if(!JoinMemberShipDAO.checkPassword(password)) {
						System.out.println("비밀번호는 영문,숫자,특수문자를 혼용해야만 합니다.");
					}else {
						dto.setPw(password);
						break;
					}
					
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			System.out.print("도    시 : ");
			dto.setAddr1(sc.next());

			System.out.print("시 군 구 : ");
			dto.setAddr2(sc.next());

			System.out.print("도 로 명 : ");
			dto.setAddr3(sc.next());

			System.out.print("우편주소 : ");
			dto.setZip(sc.next());

			System.out.print("관심분야 1 : ");
			dto.setInterest1(sc.next());

			System.out.print("관심분야 2 : ");
			dto.setInterest2(sc.next());

			int result = dao.joinMemberData(dto);

			if(result!=0) {
				System.out.println("회원가입이 완료되었습니다.");
			}else {
				System.out.println("회원가입에 실패하였습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	
	

}
