package com.day12;

//�߻� Ŭ����
//�޸��� ���� ���� Ŭ������ �̸� ����
//�޼ҵ带 ������(Override)�ؼ� ����Ѵ�.

//�ڹٴ� �������̽��� �� ���� ����.
//�ڹٴ� �������̽��� ����.


abstract class ShapeClass{ //abstract : �߻�Ŭ������ ����.
	
	abstract void draw(); //�߻�Ŭ�������� �ݵ�� �ϳ� �̻��� �߻�޼ҵ尡 �־���Ѵ�.
	
	
}

class Circ extends ShapeClass{

	@Override
	public void draw() {
		System.out.println("���� �׸���....");
	}
	
	
}

class Rect extends ShapeClass{

	@Override
	public void draw() {
		
		System.out.println("�簢���� �׸���...");
	}
	
	
}

class Tri extends ShapeClass{
	@Override
	public void draw() {
		
		System.out.println("�ﰢ���� �׸���...");
	}
	
}


public class Test8 {

	public static void main(String[] args) {
		
		Circ c = new Circ(); //����� ���� �̻� �ݵ�� ����ؾ� �Ѵ�.
		Rect r = new Rect();
		Tri t = new Tri();
		
		c.draw();
		r.draw();
		t.draw();
		

	}

}
