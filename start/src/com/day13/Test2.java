package com.day13;

interface Test{
	
	public int total();		//abstract�� ����.
	public void write();	//abstract�� ����.
	
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
			
			if(this.hak.equals(t.hak)&&t.name.equals(this.name)) {	//hak�� name �� String ���̹Ƿ� equals �� String�� equals �̴�.
				flag = true;
			}
		}
		
		return flag;
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Test ob1 = new TestImpl("111", "�ڹο�", 80, 70, 60);
		Test ob2 = new TestImpl("111", "�ڹο�", 100, 100, 100);
		
		if(ob1.equals(ob2)) {	//Object equals �� ==�� ����. �ּҸ� ���Ѵ�.
			System.out.println("ob1�� ob2�� ���� �ι�");
		}
		else {
			System.out.println("ob1�� ob2�� �ٸ� �ι�");
		}
		
		ob1.write();
		ob2.write();

	}

}
