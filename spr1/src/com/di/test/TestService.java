package com.di.test;

public class TestService {
	
	public TestService() {};
	
	
	//---------------------의존성 주입--------------
	//생성자를 이용한 의존성 주입.
	private Test test;
	
	
	//Test ob = new TestImpl1();
	//Test ob = new TestImpl2();
	public TestService(Test test) {
		this.test = test;
	}
	
	//-----------------------------------------------
	
	//메서드를 이용한 의존설 주입
	//메서드를 이용할 때는 xml에서 set을 빼버리고 소문자로 입력한다.
	//이 때는 기본생성자가 반드시 필요하다.
	public void setTest(Test test) {
		this.test = test;
		
	}
	
	
	public String getValue() {
		
		return test.result();
	}

}
