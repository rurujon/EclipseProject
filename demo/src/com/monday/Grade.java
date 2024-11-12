package com.monday;

import java.util.Scanner;

public class Grade {
	
	Scanner sc = new Scanner(System.in);
	
	GradeDAO graDao = new GradeDAO();
	
	public void grade(LoginDTO logDto) {
		
		int result;
		int grade;
		SalesDTO saleDto = new SalesDTO();
		int avgResult = 0;
		
		try {
			
			System.out.println("������ ��ǰ�� ��ȣ�� �Է��ϼ���.");
			saleDto.setProductNo(sc.next());
			
			//�����̷� Ȯ��
			//���̵� ��ġ�ϰ�, ���Ź�ǰ ��ȣ�� ��Ī�Ǵ� ��ǰ�� �ְ�, ���� ĭ�� ����ִ� �����Ͱ� �ִ��� Ȯ��.
			
			boolean check = graDao.existCheck(logDto, saleDto);	//�α���id�� �Է¹��� productno�� ����ִ� dto�� �Ű�������.
			
			if(check) {
				
				do {
					System.out.println("���� ��Ͻ� ���� ������ ���ų����� ������ ��ϵ˴ϴ�.");
					System.out.println("������ �Է��ϼ���.(0~5)");
					grade=sc.nextInt();
					
				}
				while(grade<0||grade>5);
				saleDto.setGrade(grade);
				
				//sales�� ���� ���.
				result = graDao.gradeInput(saleDto,logDto);		//�α���id�� �Է¹��� productno, ����(grade)�� ����ִ� dto�� �Ű�������.
				
				if((result!=0)) {
					System.out.println("���� �߰� �Ϸ�.");
				}
				else {
					System.out.println("���� �߰� ����.");
				}
				
				//product�� ������� ���.
				avgResult = graDao.avgGradeSet(saleDto);
				
				if((avgResult!=0)) {
					System.out.println("��� ���� �ݿ� �Ϸ�");
				}
				else {
					System.out.println("��� ���� �ݿ� ����");
				}
				
				
			}
			
			else {
				System.out.println("���並 �Է��� �̷��� �������� �ʽ��ϴ�.");
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
