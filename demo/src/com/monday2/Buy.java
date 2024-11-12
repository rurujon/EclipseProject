package com.monday2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.monday2.LoginDTO;
import com.monday2.SalesDTO;


public class Buy {
	
	Scanner sc = new Scanner(System.in);
	BuyDAO buyDao = new BuyDAO();
	
	public void buy(LoginDTO logDto) {							//로그인id를 위해 로그인dto를 받는다.
		
		String buyNum;
		SalesDTO saleDto = new SalesDTO();
		int result;
		int pointUse;
		int point;

		try {
			
			System.out.println("구매할 제품의 제품번호를 입력하세요");
			buyNum = sc.next();
			
			boolean proCheck = buyDao.productCheck(buyNum);		//product 테이블에 입력받은 번호의 제품이 있는지 확인.
			
			if(!proCheck) {
				System.out.println("구매하려는 제품이 존재하지 않습니다.");	//없다면 return
				return;
			}

			saleDto.setProductNo(buyNum);					//구매할 제품 번호 saleDTO에 저장.
			
			
			
			System.out.println("바로 구매하시겠습니까?");
			System.out.println("1.바로구매 2.장바구니");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1 :										//1. 바로구매.
				
				do {
					System.out.println("포인트를 사용하시겠습니까?");
					System.out.println("1.예 2.아니오");
					pointUse = sc.nextInt();	
				}
				while (pointUse<1||pointUse>2);
					
				result = buyDao.sales(saleDto, logDto);		//구매
				
				if(pointUse != 2) {
					
					System.out.println("사용할 포인트를 입력하십시오.");
					point = sc.nextInt();
					logDto.setPoint(point);					//logDTO에 사용할 포인트 값 저장.
					
					boolean priceCheck = buyDao.priceCheck(logDto,saleDto);
					if(!priceCheck) {
						System.out.println("가격보다 큰 포인트를 입력하셨습니다.");
						return;
					}
					
					boolean check = buyDao.pointCheck(logDto);		//입력한 포인트가 본인이 가지고있는 포인트보다 적은가.
					
					if(check) {
						int pointUseResult = buyDao.pointUse(logDto,saleDto);			//포인트 사용.
						if(pointUseResult!=0) {											//실제로는 buy 과정 중에 함께 처리되는게 맞겠지만, 중간에 추가하게 된 기능이라
																						//따로 만들어져 따로 실행이 됨.
							System.out.println("포인트를 사용하였습니다.");				//포인트가 충분하다면 포인트 사용.
																						//sales의 discount 항목에 포인트가 입력되고, userinfo의 포인트가 차감.
						}
						else {
							System.out.println("포인트 사용에 실패하였습니다.");
						}
					}
					else {
						System.out.println("충분한 포인트가 존재하지 않습니다.");				//가진 포인트가 부족하다면 포인트 없이 구매.
						System.out.println("포인트 사용을 취소하고 구매를 진행합니다.");
					}
				}
				
				if(result!=0) {
					System.out.println("구매 성공!");
				}
				else {
					System.out.println("구매 실패");
				}
				
				break;
				
			case 2 :													//2. 장바구니 넣기
				
				result = buyDao.move(logDto,saleDto);					//sales에 필요한 데이터 중 일부가 장바구니 역할을 하는 buy테이블에 저장.
				
				if(result!=0) {
					System.out.println("장바구니 담기 성공!");
				}
				else {
					System.out.println("장바구니 담기 실패");
				}
				
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}


		
	}
	
	public void listBuy(LoginDTO logDto) {					//장바구니 구매
		
		try {
			
			List<BuyDTO> buyLists = buyDao.getList();		//장바구니 목록 출력.
			
			Iterator<BuyDTO> buyit = buyLists.iterator();
			
			while(buyit.hasNext()) {
				
				BuyDTO dto = buyit.next();
				System.out.println(dto.toString());
			}
			
			System.out.println("전부 구매하시겠습니까?");
			System.out.println("1.예 2.아니오");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1 : 
				
				int result = buyDao.listBuy(logDto);		//전부구매 선택시 장바구니 테이블에 있는 데이터가 buydate를 추가하여 sales테이블로 이동.
				if(result!=0) {								//그리고 장바구니 목록인 buy 테이블 데이터 삭제.
					System.out.println("구매 성공.");
					int delete = buyDao.delete();
				}
				else {
					System.out.println("구매 실패");
				}
				
				break;
				
			case 2 : 
				
				int deleteResult = buyDao.delete();			//취소 선택시 장바구니 목록 삭제.
				if(deleteResult!=0) {
					System.out.println("장바구니 목록을 삭제하였습니다.");
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
