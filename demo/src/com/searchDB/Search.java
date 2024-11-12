package com.searchDB;

import java.util.Scanner;

import com.mondayFinal.MondayFinalDAO;


public class Search {

	Scanner sc = new Scanner(System.in);
	SearchDAO dao = new SearchDAO();

	public void searchId() {

		try {
			System.out.print("���̵� ��ϵ� �̸��� �Է��ϼ���. : ");
			String name = sc.next();

			System.out.print("���̵� ��ϵ� �޴��� ��ȣ�� �Է��ϼ���. ex)010-1234-1234 : ");
			String tel = sc.next();

			SearchDTO dto = dao.getSearchId(name, tel);

			if(dto!=null) {

				String id = dto.getId();

				String replacedid = id.substring(0, id.length() - 3) + "***";

				System.out.println("�Է��Ͻ� ������ ��ġ�ϴ� ���̵�� "+ replacedid +" �Դϴ�.");

			}else {
				System.out.println("�Է��Ͻ� ������ ��ġ�ϴ� ���̵� ã�� �� �����ϴ�.");
			}


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void searchPw() {

		try {
			System.out.print("���̵� �Է��ϼ���. : ");
			String id = sc.next();

			System.out.print("�̸��� �Է��ϼ���. : ");
			String name = sc.next();

			System.out.print("�ֹε�Ϲ�ȣ�� �Է��ϼ���. ex)801221-1234567 : ");
			String jumin = sc.next();

			SearchDTO dto = dao.getSearchPw(id, name, jumin);

			if(dto!=null) {

				String newpw;

				while(true) {

					System.out.print("�����Ͻ� ��й�ȣ�� �Է��ϼ��� :");
					newpw = sc.next();
					if(MondayFinalDAO.checkPassword(newpw)) {
						break;
					}else {
						System.out.println("��й�ȣ�� ����,����,Ư�����ڸ� ȥ���ؾ߸� �մϴ�.\n");
					}
					
				}

				dao.getInPw(dto.getId(), newpw);
				System.out.println("������ �Ϸ� �Ǿ����ϴ�.");

			}else {
				System.out.println("�Է��Ͻ� ������ ��ġ�ϴ� ������ ã�� �� �����ϴ�.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}


