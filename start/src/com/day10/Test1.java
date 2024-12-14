package com.day10;

//Call By Value
//stack ������ �����Ͱ� heap �������� �Ѿ
//Call By Reference
//heap ������ �����ʹ� stack �������� �Ѿ �� ���� ������ �ּҸ� �Ѿ

class Test{
	
	public int x = 10;
	
	public void sub(int a) {
		x +=a; //x=x+a
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Test ob = new Test();
		int a = 20;
		
		System.out.println("sub() �޼ҵ� ���� �� x : " + ob.x);
		ob.sub(a);//Call Bu Value
		System.out.println("sub() �޼ҵ� ���� �� x : " + ob.x);
		//stack �������� ������ ���� heap �������� �Ѿ ����.
		
		//Call By Reference
		
		Test ob1;
		ob1 = ob;
		System.out.println(ob.x);
		System.out.println(ob1.x);
		
		ob1.x = 300;
		
		System.out.println(ob.x);
		System.out.println(ob1.x);
		

	}

}
