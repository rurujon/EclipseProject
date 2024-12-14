package com.day16;

//예외처리를 별개의 class로 분리

class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	//eclips 프로그램. Exception이 너무 커서 생김/
	
	public MyException(String msg) {
		super(msg);
	}
	
}

public class Test4 {
	
	private int value;
	public void setValue(int value) throws MyException {
		if(value<0) {
			throw new MyException("수는 0보다 작을 수 없다.");		//메시지를 12번에 던짐.
		}
		else {
			this.value = value;
		}
	}
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		
		try {
			
			ob.setValue(-20);
			
		} catch (Exception e) {//exception의 출력이 이곳으로.
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		System.out.println(ob.getValue());

	}
	


}
