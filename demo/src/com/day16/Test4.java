package com.day16;

//����ó���� ������ class�� �и�

class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	//eclips ���α׷�. Exception�� �ʹ� Ŀ�� ����/
	
	public MyException(String msg) {
		super(msg);
	}
	
}

public class Test4 {
	
	private int value;
	public void setValue(int value) throws MyException {
		if(value<0) {
			throw new MyException("���� 0���� ���� �� ����.");		//�޽����� 12���� ����.
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
			
		} catch (Exception e) {//exception�� ����� �̰�����.
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		System.out.println(ob.getValue());

	}
	


}
