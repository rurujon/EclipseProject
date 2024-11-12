package com.monday;

import java.util.Scanner;

public class JoinMemberShip {
	
	Scanner sc = new Scanner(System.in);

	JoinMemberShipDAO dao = new JoinMemberShipDAO();

	public void insert() {

		try {

			JoinMemberShipDTO dto = new JoinMemberShipDTO();

			System.out.print("��    �� : ");
			dto.setName(sc.next());

			System.out.print("�ֹι�ȣ : ");
			dto.setJumin(sc.next());

			System.out.print("��    �� : ");
			dto.setGender(sc.next());

			System.out.print("��ȭ��ȣ : ");
			dto.setTel(sc.next());

			try {

				while(true) {

					System.out.print("���̵�(8~15��) : ");
					String userid = sc.next();

					if(!JoinMemberShipDAO.checkId(userid)) {
						System.out.println("���̵�� 8~15�� �̳��� ���� �� ���ڸ� �����մϴ�.");
						continue;
					}

					boolean exist = dao.idExist(userid);

					if(exist) {
						System.out.println("�̹� �ִ� ���̵��Դϴ�.");
					}else {
						dto.setId(userid);
						break;
					}

				}

				while(true) {

					System.out.print("��й�ȣ(����,����,Ư������ ȥ��) : ");
					String password = sc.next();

					if(!JoinMemberShipDAO.checkPassword(password)) {
						System.out.println("��й�ȣ�� ����,����,Ư�����ڸ� ȥ���ؾ߸� �մϴ�.");
					}else {
						dto.setPw(password);
						break;
					}
					
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			System.out.print("��    �� : ");
			dto.setAddr1(sc.next());

			System.out.print("�� �� �� : ");
			dto.setAddr2(sc.next());

			System.out.print("�� �� �� : ");
			dto.setAddr3(sc.next());

			System.out.print("�����ּ� : ");
			dto.setZip(sc.next());

			System.out.print("���ɺо� 1 : ");
			dto.setInterest1(sc.next());

			System.out.print("���ɺо� 2 : ");
			dto.setInterest2(sc.next());

			int result = dao.joinMemberData(dto);

			if(result!=0) {
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}else {
				System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	
	

}
