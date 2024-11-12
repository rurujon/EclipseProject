package com.mondayFinal;

import java.util.Scanner;

public class InfoUpdate {

	Scanner sc = new Scanner(System.in);

	InfoUpdateDAO dao = new InfoUpdateDAO();

	public void update() {

		try {

			InfoUpdateDTO dto = new InfoUpdateDTO();

			System.out.print("정보 수정할 아이디를 입력하세요. : ");
			dto.setId(sc.next());
			
			System.out.print("\n정보는 주소,전화번호,관심분야만 수정이 가능합니다.\n\n");
			
			System.out.print("수정 할 도시를 입력하세요. : ");
			dto.setAddr1(sc.next());

			System.out.print("수정 할 시,군,구를 입력하세요. : ");
			dto.setAddr2(sc.next());

			System.out.print("수정 할 도로명을 입력하세요. : ");
			dto.setAddr3(sc.next());

			System.out.print("수정 할 우편번호를 입력하세요. : ");
			dto.setZip(sc.next());

			System.out.print("수정 할 전화번호를 입력하세요. : ");
			dto.setTel(sc.next());

			System.out.print("수정 할 '관심분야 1'을 입력하세요. : ");
			dto.setInterest1(sc.next());

			System.out.print("수정 할 '관심분야 2'를 입력하세요. : ");
			dto.setInterest2(sc.next());

			int result = dao.updateInfo(dto);

			if(result!=0) {
				System.out.println("정보가 수정되었습니다.");
			}else {
				System.out.println("정보 수정에 실패하였습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
