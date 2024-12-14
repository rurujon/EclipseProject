package com.day13;

//Interface
//1. �߻� Ŭ������ �����̸�, ���� �ְ� ���ǰ� ����.
//2. final ������ ������ �� �ִ�.
//3. Interface�� �����ϱ� ���ؼ��� implements�� ����Ѵ�.
//4. �ϳ� �̻��� �������̽��� ������ Ŭ������ �������̽���
//	 ��� �޼��带 Override�ؾ��Ѵ�
//5. Interface�� ���߱����� �����ϴ�.
//6. �������� �ǹ̸� ������ �ִ�.
//7. Interface �� �ٸ� Interface�� ��ӹ��� �� �ִ�. �׶��� extands�� ����Ѵ�.
//

interface Fruit{//public static final �� �����Ǿ� �ִ�.
	String Won = "��";//���� �� �ʱ�ȭ�� �ؾ��Ѵ�.
	
	int getPrice();		//public abstract �� �����Ǿ� �ִ�.
	public String getName();//abstract�� �����Ǿ� �ִ�.
	
	//public void print() {	} : �Ϲ� �޼��带 ���� �� ����.
	
}

class Inter implements Fruit{
//class FruitImpl inmplements Fruit	

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "���";
	}
	
	public String getItems() {
		return "����";
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Inter ob1 = new Inter();
		//Fruit ob1 = new Inter(); upcast �Ǿ���. ���� : �ڽŸ��� �޼��带 ������ ������ �� �ȴ�.
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice() + Fruit.Won);
		
		//����
		
		Fruit ob2 = ob1; //upcast
		System.out.println(ob2.getName());
		System.out.println(ob2.getPrice());
		//System.out.println(ob2.getItems()); �θ�� �ڽ� �� �� �� ����.

	}

}
