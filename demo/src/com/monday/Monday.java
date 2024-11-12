package com.monday;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.monday.ProductDTO;

public class Monday {
	
	Scanner sc = new Scanner(System.in);
	
	MondayDAO dao = new MondayDAO();
	GradeDAO graDao = new GradeDAO();
	
	//��ü ��ǰ ����Ʈ monday
	public void selectAllProduct() {			
		
		
		
		List<ProductDTO> lists = dao.getList();
		
		Iterator<ProductDTO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ProductDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void selectPointProduct() {
		
		ProductDTO dto = new ProductDTO();
		
		System.out.println("    ��з�    ");
		System.out.println("--------------------------------------");
		
		List<BigCatalDTO> bigCatalLists = dao.bigCatalList();
		
		Iterator<BigCatalDTO> bigCatalIt = bigCatalLists.iterator();
		
		while(bigCatalIt.hasNext()) {
			
			BigCatalDTO bigDto = bigCatalIt.next();
			System.out.println(bigDto.toString());
		}
		
		System.out.println("��з��� �����Ͻÿ�.(�ѱ۷� �Է��ϼ���)");
		
		
		dto.setSearchCatal(sc.next());
		
		
		System.out.println("�̴�� �˻��Ͻðڽ��ϱ�?");
		System.out.println("1.��, 2.�Һз���");
		
		int b=sc.nextInt();
		
		switch(b) {
		
		case 1 :
			List<ProductDTO> bigLists = dao.getBigList(dto);

			Iterator<ProductDTO> bigIt = bigLists.iterator();

			while(bigIt.hasNext()) {

				dto = bigIt.next();
				System.out.println(dto.toString());
			}
			
			break;
			
		case 2 :
			
			System.out.println("     ��з�       �Һз�");
			System.out.println("-------------------------------------------");
			
			List<SmallCatalDTO> smallCatalLists = dao.smallCatalList(dto);
			
			Iterator<SmallCatalDTO> smallCatalIt = smallCatalLists.iterator();
			
			while(smallCatalIt.hasNext()) {
				
				SmallCatalDTO smallDto = smallCatalIt.next();
				System.out.println(smallDto.toString());
			}
			
			
			System.out.println("�Һз��� �����ϼ��� (�ѱ۷� �Է��ϼ���)");
			dto.setSearchCatal(sc.next());
			List<ProductDTO> smallLists = dao.getSmallList(dto);

			Iterator<ProductDTO> smallIt = smallLists.iterator();

			while(smallIt.hasNext()) {

				dto = smallIt.next();
				System.out.println(dto.toString());
			}
			
			break;
			
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
			
		}
		
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void selectMakerList() {
		
		List<MakerListDTO> MakerLists = dao.getMakerList();
		
		Iterator<MakerListDTO> MakerListIt = MakerLists.iterator();
		
		while(MakerListIt.hasNext()) {
			
			MakerListDTO dto = MakerListIt.next();
			System.out.println(dto.toString());
		}
		
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void selectBuyList(LoginDTO logDto) {
		
		List<SalesDTO> salesLists = dao.getSalesList(logDto);
		
		Iterator<SalesDTO> salesListIT = salesLists.iterator();
		
		while(salesListIT.hasNext()) {
			
			SalesDTO dto = salesListIT.next();
			System.out.println(dto.toString());
		}
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void buy(LoginDTO logDto) {							//�α���id�� ���� �α���dto�� �޴´�.
		
		String buyNum;
		SalesDTO saleDto = new SalesDTO();
		int result;

		try {
			
			System.out.println("������ ��ǰ�� ��ǰ��ȣ�� �Է��ϼ���");
			buyNum = sc.next();

			saleDto.setProductNo(buyNum);

			
			result = dao.sales(saleDto, logDto);
			
			if(result!=0) {
				System.out.println("���� ����!");
			}
			else {
				System.out.println("���� ����");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}


		
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	public void grade(LoginDTO logDto) {
		
		int result;
		int grade;
		SalesDTO saleDto = new SalesDTO();
		int avgResult = 0;
		
		try {
			
			System.out.println("������ ��ǰ�� ��ȣ�� �Է��ϼ���.");
			saleDto.setProductNo(sc.next());
			
			boolean check = graDao.existCheck(logDto, saleDto);	//�α���id�� �Է¹��� productno�� ����ִ� dto�� �Ű�������.
			
			if(check) {
				
				do {
					System.out.println("���� ��Ͻ� ���� ������ ���ų����� ������ ��ϵ˴ϴ�.");
					System.out.println("������ �Է��ϼ���.(0~5)");
					grade=sc.nextInt();
					
				}
				while(grade<0||grade>5);
				saleDto.setGrade(grade);
				
				result = graDao.gradeInput(saleDto,logDto);		//�α���id�� �Է¹��� productno, ����(grade)�� ����ִ� dto�� �Ű�������.
				
				if((result!=0)) {
					System.out.println("���� �߰� �Ϸ�.");
				}
				else {
					System.out.println("���� �߰� ����.");
				}
				
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
