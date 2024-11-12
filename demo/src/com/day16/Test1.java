package com.day16;

//<> ���ʸ�(Generic)
//���ʸ��� ����

class Box<T>{
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Box b1 = new Box();
		
		b1.set("����");
		
		String str = (String)b1.get();
		System.out.println(str);

		b1.set(30);
		
		Integer i = (Integer)b1.get();
		System.out.println(Integer.toString(i));
		
		Box<String> b2 = new Box<String>();
		b2.set("�γ�");
		
		str = b2.get();
		System.out.println(str);
		
		Box<Integer> b3 = new Box<Integer>();
		b3.set(50);
		
		i = b3.get();
		System.out.println(i);

	}

}
