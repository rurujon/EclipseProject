package com.mondayFinal;

import java.util.Scanner;

public class MondayFinalJoinMember {

	Scanner sc = new Scanner(System.in);

	MondayFinalDAO dao = new MondayFinalDAO();

	public void insert() {

		try {

			MondayFinalDTO dto = new MondayFinalDTO();

			System.out.print("��    �� : ");
			dto.setName(sc.next());

			System.out.print("�ֹι�ȣ : ");
			dto.setJumin(sc.next());

			System.out.print("����[��/��] : ");
			dto.setGender(sc.next());

			System.out.print("��ȭ��ȣ : ");
			dto.setTel(sc.next());

			try {

				while(true) {

					System.out.print("���̵�(8~15��) : ");
					String userid = sc.next();

					if(!MondayFinalDAO.checkId(userid)) {
						System.out.println("���̵�� 8~15�� �̳��� ���� �� ���ڸ� �����մϴ�.\n");
						continue;
					}

					boolean exist = dao.idExist(userid);

					if(exist) {
						System.out.println("�̹� �ִ� ���̵��Դϴ�.\n");
					}else {
						dto.setId(userid);
						break;
					}

				}

				while(true) {

					System.out.print("��й�ȣ(����,����,Ư������ ȥ��) : ");
					String password = sc.next();

					if(!MondayFinalDAO.checkPassword(password)) {
						System.out.println("��й�ȣ�� ����,����,Ư�����ڸ� ȥ���ؾ߸� �մϴ�.\n");
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

			System.out.print("�����ȣ : ");
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
	
	public void delete() {
		
	    try {
	    	
	        System.out.print("Ż�� �� ���̵� �Է��ϼ���. : ");
	        String did = sc.next();
	        
	        int result = dao.deleteId(did);
	        
	        if(result != 0) {
	            System.out.println("ȸ���� Ż���ϼ̽��ϴ�.");
	        } else {
	            System.out.println("ȸ��Ż�� �����Ͽ����ϴ�.");
	        }
	        
	    } catch (Exception e) {
	        System.out.println(e.toString());
	    }
	    
	}

}
