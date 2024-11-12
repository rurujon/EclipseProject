package com.mondayFinal;

import java.util.Scanner;

public class InfoUpdate {

	Scanner sc = new Scanner(System.in);

	InfoUpdateDAO dao = new InfoUpdateDAO();

	public void update() {

		try {

			InfoUpdateDTO dto = new InfoUpdateDTO();

			System.out.print("���� ������ ���̵� �Է��ϼ���. : ");
			dto.setId(sc.next());
			
			System.out.print("\n������ �ּ�,��ȭ��ȣ,���ɺо߸� ������ �����մϴ�.\n\n");
			
			System.out.print("���� �� ���ø� �Է��ϼ���. : ");
			dto.setAddr1(sc.next());

			System.out.print("���� �� ��,��,���� �Է��ϼ���. : ");
			dto.setAddr2(sc.next());

			System.out.print("���� �� ���θ��� �Է��ϼ���. : ");
			dto.setAddr3(sc.next());

			System.out.print("���� �� �����ȣ�� �Է��ϼ���. : ");
			dto.setZip(sc.next());

			System.out.print("���� �� ��ȭ��ȣ�� �Է��ϼ���. : ");
			dto.setTel(sc.next());

			System.out.print("���� �� '���ɺо� 1'�� �Է��ϼ���. : ");
			dto.setInterest1(sc.next());

			System.out.print("���� �� '���ɺо� 2'�� �Է��ϼ���. : ");
			dto.setInterest2(sc.next());

			int result = dao.updateInfo(dto);

			if(result!=0) {
				System.out.println("������ �����Ǿ����ϴ�.");
			}else {
				System.out.println("���� ������ �����Ͽ����ϴ�.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
