package com.monday2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.monday2.ProductDTO;

public class Monday {
	
	Scanner sc = new Scanner(System.in);
	
	MondayDAO dao = new MondayDAO();
	
	//전체 제품 리스트 monday
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
		
		System.out.println("    대분류    ");
		System.out.println("--------------------------------------");
		
		List<BigCatalDTO> bigCatalLists = dao.bigCatalList();			//대분류 리스트 출력
		
		Iterator<BigCatalDTO> bigCatalIt = bigCatalLists.iterator();
		
		while(bigCatalIt.hasNext()) {
			
			BigCatalDTO bigDto = bigCatalIt.next();
			System.out.println(bigDto.toString());
		}
		
		System.out.println("대분류를 선택하시오.(한글로 입력하세요)");	//대분류 지정
		
		
		dto.setSearchCatal(sc.next());
		
		
		System.out.println("이대로 검색하시겠습니까?");
		System.out.println("1.예, 2.소분류로");
		
		int b=sc.nextInt();
		
		switch(b) {
		
		case 1 :
			List<ProductDTO> bigLists = dao.getBigList(dto);		//대분류로 where 하여 서칭.

			Iterator<ProductDTO> bigIt = bigLists.iterator();

			while(bigIt.hasNext()) {

				dto = bigIt.next();
				System.out.println(dto.toString());
			}
			
			break;
			
		case 2 :
			
			System.out.println("     대분류       소분류");
			System.out.println("-------------------------------------------");
			
			List<SmallCatalDTO> smallCatalLists = dao.smallCatalList(dto);		//소분류 리스트
			
			Iterator<SmallCatalDTO> smallCatalIt = smallCatalLists.iterator();
			
			while(smallCatalIt.hasNext()) {
				
				SmallCatalDTO smallDto = smallCatalIt.next();
				System.out.println(smallDto.toString());
			}
			
			
			System.out.println("소분류를 선택하세요 (한글로 입력하세요)");		//소분류 지정
			dto.setSearchCatal(sc.next());
			List<ProductDTO> smallLists = dao.getSmallList(dto);				//소분류로 where 하여 서칭

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
		System.out.println("제조사명                                         주소                                                 전화번호           최다구매제품");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		List<MakerListDTO> MakerLists = dao.getMakerList();
		
		Iterator<MakerListDTO> MakerListIt = MakerLists.iterator();		//평범한 테이블 전체 셀렉팅
		
		while(MakerListIt.hasNext()) {
			
			MakerListDTO dto = MakerListIt.next();
			System.out.println(dto.toString());
		}
		
		
	}
	
	public void selectBuyList(LoginDTO logDto) {						//아이디로 걸러낸 sales 테이블 셀렉팅
		
		List<SalesDTO> salesLists = dao.getSalesList(logDto);
		
		Iterator<SalesDTO> salesListIT = salesLists.iterator();
		
		while(salesListIT.hasNext()) {
			
			SalesDTO dto = salesListIT.next();
			System.out.println(dto.toString());
		}
		
	}
	
	public void buy(LoginDTO logDto) {							//로그인id를 위해 로그인dto를 받는다.
		
		String buyNum;
		SalesDTO saleDto = new SalesDTO();
		int result;

		try {
			
			System.out.println("구매할 제품의 제품번호를 입력하세요");
			buyNum = sc.next();

			saleDto.setProductNo(buyNum);

			
			result = dao.sales(saleDto, logDto);
			
			if(result!=0) {
				System.out.println("구매 성공!");
			}
			else {
				System.out.println("구매 실패");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
