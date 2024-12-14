package com.day17;

class MyThread1 extends Thread{
	
	private int num;
	private String name;
	
	public MyThread1(int num, String name) {
		this.name = name;
		this.num = num;
	}
	
	@Override
	public void run() {
		int i=0;
		
		while(i<num) {
			System.out.println(this.getName() + ":" + name + i);
			i++;
			
			try {
				sleep(100);//0.1��
			} catch (Exception e) {
				
			}
		}
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		System.out.println("main ����.");
		
		MyThread1 t1 = new MyThread1(100, "ù��°");
		MyThread1 t2 = new MyThread1(200, "�ι�°");
		
		t1.start();
		t2.start();
		
		//������� ������ �Ǿ��ٸ� ����� ������ ������ 3��
		
		System.out.println("main ����.");

	}

}
