package com.day13;

interface Test{
	
	public int total();		//abstract가 생략.
	public void write();	//abstract가 생략.
	
}

class TestImpl implements Test{
	
	private String hak, name;
	private int kor,eng,mat;
	
	public TestImpl() {}
	
	public TestImpl(String hak, String name, int kor, int eng, int mat) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}
	
	public void set(String hak, String name, int kor, int eng, int mat) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}

	@Override
	public int total() {
		return kor + eng + mat;
	}

	@Override
	public void write() {
		System.out.println(hak + ":" + name + ":" + total());
	}
	
	public boolean equals(Object ob) {//ob1.equals(ob2)
		boolean flag = false;
		
		if(ob instanceof TestImpl) {
			
			TestImpl t = (TestImpl)ob;	//downcast
			
			if(this.hak.equals(t.hak)&&t.name.equals(this.name)) {	//hak과 name 이 String 값이므로 equals 는 String의 equals 이다.
				flag = true;
			}
		}
		
		return flag;
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Test ob1 = new TestImpl("111", "박민영", 80, 70, 60);
		Test ob2 = new TestImpl("111", "박민영", 100, 100, 100);
		
		if(ob1.equals(ob2)) {	//Object equals 은 ==와 같다. 주소를 비교한다.
			System.out.println("ob1과 ob2는 동일 인물");
		}
		else {
			System.out.println("ob1과 ob2는 다른 인물");
		}
		
		ob1.write();
		ob2.write();

	}

}
