package com.day7;

public class Test1 {

	public static void main(String[] args) {
		
		//Class
		//전체가 아닌, 각각의 부품을 만들어 조립.
		//자동차가 있다면, 바퀴, 문짝, 엔진 등으로 분해 가능.
		//초등학교 : 한 사람이 모든 과목 가르침 ㅡ> 선생에게 문제가 생긴다면 모든 과목 불가능
		//중 고등학교 : 과목마다 선생 배정. 누군가 다쳐도 다른 데는 문제 없음.
		//Com이라는 새로운 건물, main 이라는 출입문, 사장과 직원 각각의 자리, 직원이 늘어날수록 Test1의 공간이 점점 꽉참.
		//Test2 라는 새로운 건물, main이라는 출입문이 없음. Test1 구름다리를 통해 입장 가능.
		//Test2에는 부서에 따라 칸막이가 존재. 칸막이 : 메소드, 부서이름(영업부) : 메소드명
		//영업부엔 누구나 들어올 필요가 있다. public(누구나),private(staff only) : 접근 지정자.
		//Class는 전부 public
		//각 부서에 걸맞는 세간살이 : 코딩
		//각 main 의 int 등의 정수기 : 지역변수, 그 부서만 사용할 수 있다.
		//모든 부서에 연결된 복도에 있는 정수기 : 전역변수(멤버변수) instance 변수
		//각 부서에 방문하고 돌아나올 때 받는 사은품 : return 값(자료형8개. string, object)
		//나올 때 사은품을 주지 않는 부서 :void(return 값 없음)
		//main(인수). 인수 : 식당을 들어갈 수 있는 식권.
		//Com ob = new Com(); new : 복사하라. 구름다리 설치 완료.
		//Com ame = new Com(); Com을 계속 복사하며 같은 양식으로 복제된다.
		
		
		
		//객체 생성(메모리 할당)
		Rect r1 = new Rect();
		
		r1.input();
		int a = r1.area();
		int l = r1.length();
		r1.print(a, l); //변수명은 어떻게 넣든 상관은 없으나, 자료형은 일치해야한다.
		
		Rect r2=new Rect();
		
		r2.input();
		a= r2.area();
		l=r2.length();
		r2.print(a, l);
		

		
		
		System.out.println(r1.w);
		System.out.println(r1.h);
		System.out.println(r1.w);
		System.out.println(r2.h);
		
		//메모리 구조
		//stack 영역에서는 마음대로 저장할 수 있으며, 크기가 작은 지역 변수 등의 값이 저장된다.
		//지역 변수, 매개변수, 메서드 호출 시점 등의 정보
		//Class는 사이즈가 크기 때문에 Heap 영역에만 저장할 수 있다.
		//Rect r1 = new Rect():
		//Rect r1 : stack 영역에 저장.  new Rect(); : heap 영역에 저장.
		//heap영역에는 메소드만 저장하는 메소드 영역이 존재한다.
		

	}

}
