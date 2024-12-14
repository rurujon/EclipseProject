package com.day10;

//Call By Value
//stack 영역의 데이터가 heap 영역으로 넘어감
//Call By Reference
//heap 영역의 데이터는 stack 영역으로 넘어갈 수 없기 때문에 주소만 넘어감

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
		
		System.out.println("sub() 메소드 실행 전 x : " + ob.x);
		ob.sub(a);//Call Bu Value
		System.out.println("sub() 메소드 실행 후 x : " + ob.x);
		//stack 영역에서 지정한 값이 heap 영역으로 넘어가 계산됨.
		
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
