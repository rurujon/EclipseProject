package com.day12;

//Singleton
//��ü�� ������ �����ϴ� ���� �ƴ϶� �ϳ��� ��ü�� �����ϰ� �����ؼ� ����ϴ� ���
//���� �� ���� ���� ������ ����.
//ex : Calendar now = new Calendar.getInstance();
//static�� call by reference

class Sing{
	
	private static Sing ob; 
	
	static Sing getInstance() {
		if(ob==null) {
			
			ob=new Sing();
		}
		
		return ob;
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Sing ob1 = Sing.getInstance();
		Sing ob2 = Sing.getInstance();
		
		if(ob1==ob2) {
			System.out.println("������ ��ü");
		}
		else {
			System.out.println("�������� ���� ��ü");
		}

	}

}
