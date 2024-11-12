package com.monday;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.monday.ProductDTO;

public class Monday {
	
	Scanner sc = new Scanner(System.in);
	
	MondayDAO dao = new MondayDAO();
	GradeDAO graDao = new GradeDAO();
	
	//전체 제품 리스트 monday
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
		
		System.out.println("    대분류    ");
		System.out.println("--------------------------------------");
		
		List<BigCatalDTO> bigCatalLists = dao.bigCatalList();
		
		Iterator<BigCatalDTO> bigCatalIt = bigCatalLists.iterator();
		
		while(bigCatalIt.hasNext()) {
			
			BigCatalDTO bigDto = bigCatalIt.next();
			System.out.println(bigDto.toString());
		}
		
		System.out.println("대분류를 선택하시오.(한글로 입력하세요)");
		
		
		dto.setSearchCatal(sc.next());
		
		
		System.out.println("이대로 검색하시겠습니까?");
		System.out.println("1.예, 2.소분류로");
		
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
			
			System.out.println("     대분류       소분류");
			System.out.println("-------------------------------------------");
			
			List<SmallCatalDTO> smallCatalLists = dao.smallCatalList(dto);
			
			Iterator<SmallCatalDTO> smallCatalIt = smallCatalLists.iterator();
			
			while(smallCatalIt.hasNext()) {
				
				SmallCatalDTO smallDto = smallCatalIt.next();
				System.out.println(smallDto.toString());
			}
			
			
			System.out.println("소분류를 선택하세요 (한글로 입력하세요)");
			dto.setSearchCatal(sc.next());
			List<ProductDTO> smallLists = dao.getSmallList(dto);

			Iterator<ProductDTO> smallIt = smallLists.iterator();

			while(smallIt.hasNext()) {

				dto = smallIt.next();
				System.out.println(dto.toString());
			}
			
			break;
			
		default : System.out.println("잘못 입력하셨습니다."); break;
			
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
	//////////////////////////////////////////////////////////////////////////////////////////
	public void grade(LoginDTO logDto) {
		
		int result;
		int grade;
		SalesDTO saleDto = new SalesDTO();
		int avgResult = 0;
		
		try {
			
			System.out.println("구매한 물품의 번호를 입력하세요.");
			saleDto.setProductNo(sc.next());
			
			boolean check = graDao.existCheck(logDto, saleDto);	//로그인id와 입력받은 productno가 들어있는 dto를 매개변수로.
			
			if(check) {
				
				do {
					System.out.println("평점 등록시 가장 오래된 구매내역에 평점이 등록됩니다.");
					System.out.println("평점을 입력하세요.(0~5)");
					grade=sc.nextInt();
					
				}
				while(grade<0||grade>5);
				saleDto.setGrade(grade);
				
				result = graDao.gradeInput(saleDto,logDto);		//로그인id와 입력받은 productno, 평점(grade)가 들어있는 dto를 매개변수로.
				
				if((result!=0)) {
					System.out.println("평점 추가 완료.");
				}
				else {
					System.out.println("평점 추가 실패.");
				}
				
				avgResult = graDao.avgGradeSet(saleDto);
				
				if((avgResult!=0)) {
					System.out.println("평균 평점 반영 완료");
				}
				else {
					System.out.println("평균 평점 반영 실패");
				}
				
				
			}
			
			else {
				System.out.println("리뷰를 입력할 이력이 존재하지 않습니다.");
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
