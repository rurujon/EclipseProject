package com.day13;

//���� Ŭ����(�͸���,Annonymus,������ Ŭ����)

public class Test7 {
	
	public Object getTitle() {
		
		//return "������";
		
		return new Object() {	//�̸��� ����. �ַ� �߻�Ŭ����, Ȥ�� �������̽���.
			
			@Override
			public String toString() {
				return "������ Ŭ����";
			}
		};
	}

	public static void main(String[] args) {
		
		Test7 ob = new Test7();
		
		Object o = ob.getTitle();
		System.out.println(o);

	}

}
