package com.day13;

//���� Ŭ����(static)

class Outer3{
	
	static int a = 10;
	int b = 20;
	
	public static class Inner3{	//static���� ���� ��ü������ �Ǿ� �ö� �ִ�.
		
		int c = 30;
		
		public void write() {
			
			System.out.println(a);
			//System.out.println(b);
			System.out.println(c);
			
			Outer3 o = new Outer3();
			System.out.println("o.b : " + o.b);	//���ο��� �ܺθ� ��ü������ �����ϴ�.
		}
		
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Outer3 ob = new Outer3();
		Outer3.Inner3 in = new Outer3.Inner3();
		in.write();
		

	}

}
