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
			
			System.out.println("구매한 물품의 번호를 입력하세요.");
			saleDto.setProductNo(sc.next());
			
			//구매이력 확인
			//아이디가 일치하고, 구매물품 번호와 매칭되는 물품이 있고, 평점 칸이 비어있는 데이터가 있는지 확인.
			
			boolean check = graDao.existCheck(logDto, saleDto);	//로그인id와 입력받은 productno가 들어있는 dto를 매개변수로.
			
			if(check) {
				
				do {
					System.out.println("평점 등록시 가장 오래된 구매내역에 평점이 등록됩니다.");
					System.out.println("평점을 입력하세요.(0~5)");
					grade=sc.nextInt();
					
				}
				while(grade<0||grade>5);
				saleDto.setGrade(grade);
				
				//sales에 평점 등록.
				result = graDao.gradeInput(saleDto,logDto);		//로그인id와 입력받은 productno, 평점(grade)가 들어있는 dto를 매개변수로.
				
				if((result!=0)) {
					System.out.println("평점 추가 완료.");
				}
				else {
					System.out.println("평점 추가 실패.");
				}
				
				//product에 평균평점 등록.
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
