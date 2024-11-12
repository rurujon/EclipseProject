package com.day10;

class TestD{
	
	private String title;//��-----------"null"
	protected double area;//314.0--------50
	
	public TestD() {}
	
	public TestD(String title) {
		this.title = title;
	}
	
	public void write() {
		System.out.println(title + ":" + area);
	}
	
}

class Circle extends TestD{
	
	private int r;//10
	protected static final double PI=3.14;
	
	public Circle(int r) {
		super("��");
		this.r = r;
	}
	
	public void circleArea() {
		area = (double)r*r*PI;
	}
	
}

class RectD extends TestD{
	
	private int w,h;
	
	public void rectArea(int w,int h) {//10,5
		this.w = w;
		this.h = h;
		
		area = w*h;
	}
	
	//�޼��� �������̵�(override)
	//��Ӱ��迡�� �θ� ���� �޼ҵ�� ����� ������ �ϴ� �޼ҵ��� ���ϼ��� ���� ����Ѵ�.
	//��Ӱ��迡���� ����.
	@Override // ������̼�(annotation) 
	public void write() {//5. �θ�� �ڽ��� ������ ��ü�� ������ �ִٸ� ������ �ڽ� ���� ����.
		System.out.println("���� : " + w + ", ���� : "+h);
		System.out.println("���� : " + area);
	}
	
}



public class Test7 {

	public static void main(String[] args) {
		
		Circle ob1 = new Circle(10);
		
		ob1.circleArea();
		ob1.write();
		
		RectD ob2 = new RectD();
	
		ob2.rectArea(10, 5);
		ob2.write();

	}

}
