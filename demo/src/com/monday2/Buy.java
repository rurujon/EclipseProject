package com.monday2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.monday2.LoginDTO;
import com.monday2.SalesDTO;


public class Buy {
	
	Scanner sc = new Scanner(System.in);
	BuyDAO buyDao = new BuyDAO();
	
	public void buy(LoginDTO logDto) {							//�α���id�� ���� �α���dto�� �޴´�.
		
		String buyNum;
		SalesDTO saleDto = new SalesDTO();
		int result;
		int pointUse;
		int point;

		try {
			
			System.out.println("������ ��ǰ�� ��ǰ��ȣ�� �Է��ϼ���");
			buyNum = sc.next();
			
			boolean proCheck = buyDao.productCheck(buyNum);		//product ���̺� �Է¹��� ��ȣ�� ��ǰ�� �ִ��� Ȯ��.
			
			if(!proCheck) {
				System.out.println("�����Ϸ��� ��ǰ�� �������� �ʽ��ϴ�.");	//���ٸ� return
				return;
			}

			saleDto.setProductNo(buyNum);					//������ ��ǰ ��ȣ saleDTO�� ����.
			
			
			
			System.out.println("�ٷ� �����Ͻðڽ��ϱ�?");
			System.out.println("1.�ٷα��� 2.��ٱ���");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1 :										//1. �ٷα���.
				
				do {
					System.out.println("����Ʈ�� ����Ͻðڽ��ϱ�?");
					System.out.println("1.�� 2.�ƴϿ�");
					pointUse = sc.nextInt();	
				}
				while (pointUse<1||pointUse>2);
					
				result = buyDao.sales(saleDto, logDto);		//����
				
				if(pointUse != 2) {
					
					System.out.println("����� ����Ʈ�� �Է��Ͻʽÿ�.");
					point = sc.nextInt();
					logDto.setPoint(point);					//logDTO�� ����� ����Ʈ �� ����.
					
					boolean priceCheck = buyDao.priceCheck(logDto,saleDto);
					if(!priceCheck) {
						System.out.println("���ݺ��� ū ����Ʈ�� �Է��ϼ̽��ϴ�.");
						return;
					}
					
					boolean check = buyDao.pointCheck(logDto);		//�Է��� ����Ʈ�� ������ �������ִ� ����Ʈ���� ������.
					
					if(check) {
						int pointUseResult = buyDao.pointUse(logDto,saleDto);			//����Ʈ ���.
						if(pointUseResult!=0) {											//�����δ� buy ���� �߿� �Բ� ó���Ǵ°� �°�����, �߰��� �߰��ϰ� �� ����̶�
																						//���� ������� ���� ������ ��.
							System.out.println("����Ʈ�� ����Ͽ����ϴ�.");				//����Ʈ�� ����ϴٸ� ����Ʈ ���.
																						//sales�� discount �׸� ����Ʈ�� �Էµǰ�, userinfo�� ����Ʈ�� ����.
						}
						else {
							System.out.println("����Ʈ ��뿡 �����Ͽ����ϴ�.");
						}
					}
					else {
						System.out.println("����� ����Ʈ�� �������� �ʽ��ϴ�.");				//���� ����Ʈ�� �����ϴٸ� ����Ʈ ���� ����.
						System.out.println("����Ʈ ����� ����ϰ� ���Ÿ� �����մϴ�.");
					}
				}
				
				if(result!=0) {
					System.out.println("���� ����!");
				}
				else {
					System.out.println("���� ����");
				}
				
				break;
				
			case 2 :													//2. ��ٱ��� �ֱ�
				
				result = buyDao.move(logDto,saleDto);					//sales�� �ʿ��� ������ �� �Ϻΰ� ��ٱ��� ������ �ϴ� buy���̺� ����.
				
				if(result!=0) {
					System.out.println("��ٱ��� ��� ����!");
				}
				else {
					System.out.println("��ٱ��� ��� ����");
				}
				
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}


		
	}
	
	public void listBuy(LoginDTO logDto) {					//��ٱ��� ����
		
		try {
			
			List<BuyDTO> buyLists = buyDao.getList();		//��ٱ��� ��� ���.
			
			Iterator<BuyDTO> buyit = buyLists.iterator();
			
			while(buyit.hasNext()) {
				
				BuyDTO dto = buyit.next();
				System.out.println(dto.toString());
			}
			
			System.out.println("���� �����Ͻðڽ��ϱ�?");
			System.out.println("1.�� 2.�ƴϿ�");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1 : 
				
				int result = buyDao.listBuy(logDto);		//���α��� ���ý� ��ٱ��� ���̺� �ִ� �����Ͱ� buydate�� �߰��Ͽ� sales���̺�� �̵�.
				if(result!=0) {								//�׸��� ��ٱ��� ����� buy ���̺� ������ ����.
					System.out.println("���� ����.");
					int delete = buyDao.delete();
				}
				else {
					System.out.println("���� ����");
				}
				
				break;
				
			case 2 : 
				
				int deleteResult = buyDao.delete();			//��� ���ý� ��ٱ��� ��� ����.
				if(deleteResult!=0) {
					System.out.println("��ٱ��� ����� �����Ͽ����ϴ�.");
				}
				
				break;

			default:
				break;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
