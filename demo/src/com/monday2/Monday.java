package com.monday2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.monday2.ProductDTO;

public class Monday {
	
	Scanner sc = new Scanner(System.in);
	
	MondayDAO dao = new MondayDAO();
	
	//��ü ��ǰ ����Ʈ monday
	public void selectAllProduct() {			
		
		List<ProductDTO> lists = dao.getList();
		
		Iterator<ProductDTO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ProductDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	
	public void selectPointProduct() {
		
		ProductDTO dto = new ProductDTO();
		
		System.out.println("    ��з�    ");
		System.out.println("--------------------------------------");
		
		List<BigCatalDTO> bigCatalLists = dao.bigCatalList();			//��з� ����Ʈ ���
		
		Iterator<BigCatalDTO> bigCatalIt = bigCatalLists.iterator();
		
		while(bigCatalIt.hasNext()) {
			
			BigCatalDTO bigDto = bigCatalIt.next();
			System.out.println(bigDto.toString());
		}
		
		System.out.println("��з��� �����Ͻÿ�.(�ѱ۷� �Է��ϼ���)");	//��з� ����
		
		
		dto.setSearchCatal(sc.next());
		
		
		System.out.println("�̴�� �˻��Ͻðڽ��ϱ�?");
		System.out.println("1.��, 2.�Һз���");
		
		int b=sc.nextInt();
		
		switch(b) {
		
		case 1 :
			List<ProductDTO> bigLists = dao.getBigList(dto);		//��з��� where �Ͽ� ��Ī.

			Iterator<ProductDTO> bigIt = bigLists.iterator();

			while(bigIt.hasNext()) {

				dto = bigIt.next();
				System.out.println(dto.toString());
			}
			
			break;
			
		case 2 :
			
			System.out.println("     ��з�       �Һз�");
			System.out.println("-------------------------------------------");
			
			List<SmallCatalDTO> smallCatalLists = dao.smallCatalList(dto);		//�Һз� ����Ʈ
			
			Iterator<SmallCatalDTO> smallCatalIt = smallCatalLists.iterator();
			
			while(smallCatalIt.hasNext()) {
				
				SmallCatalDTO smallDto = smallCatalIt.next();
				System.out.println(smallDto.toString());
			}
			
			
			System.out.println("�Һз��� �����ϼ��� (�ѱ۷� �Է��ϼ���)");		//�Һз� ����
			dto.setSearchCatal(sc.next());
			List<ProductDTO> smallLists = dao.getSmallList(dto);				//�Һз��� where �Ͽ� ��Ī

			Iterator<ProductDTO> smallIt = smallLists.iterator();

			while(smallIt.hasNext()) {

				dto = smallIt.next();
				System.out.println(dto.toString());
			}
			
			break;
		
		default : break;
		}
		
	}
	
	public void selectMakerList() {
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("�������                                         �ּ�                                                 ��ȭ��ȣ           �ִٱ�����ǰ");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		List<MakerListDTO> MakerLists = dao.getMakerList();
		
		Iterator<MakerListDTO> MakerListIt = MakerLists.iterator();		//����� ���̺� ��ü ������
		
		while(MakerListIt.hasNext()) {
			
			MakerListDTO dto = MakerListIt.next();
			System.out.println(dto.toString());
		}
		
		
	}
	
	public void selectBuyList(LoginDTO logDto) {						//���̵�� �ɷ��� sales ���̺� ������
		
		List<SalesDTO> salesLists = dao.getSalesList(logDto);
		
		Iterator<SalesDTO> salesListIT = salesLists.iterator();
		
		while(salesListIT.hasNext()) {
			
			SalesDTO dto = salesListIT.next();
			System.out.println(dto.toString());
		}
		
	}
	
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

}
