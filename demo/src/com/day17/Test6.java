package com.day17;

//������ �����ֱ�

class MyThread6 extends Thread{
	
	@Override
	public void run() {
		
		try {
			
			System.out.println("������ ����");
			System.out.println("�켱���� : " + getPriority());
			System.out.println("������ �̸� : " + getName());
			
			sleep(500);
			
			//�켱���� ����
			setPriority(2);
			System.out.println("����� �켱 ���� : " + getPriority());
			
			System.out.println("������ ����");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
public class Test6 {

	public static void main(String[] args) {
		
		Thread t1 = Thread.currentThread();		//���� �����带 ���⿡ �־�� : main
		Thread t2 = new MyThread6();
		
		System.out.println("���� ������ �켱���� : " + t1.getPriority());//5
		System.out.println("���� ������ �̸� : " + t1.getName());//main
		System.out.println("start �޼��� ���� �� is Alive  : " + t2.isAlive());//false
		
		t2.start();
		
		//t2�� �켱����
		System.out.println("t2�� �켱 ���� : " + t2.getPriority());//5
		
		//t2�� �켱����
		t2.setPriority(1);
		try {
			
			Thread.sleep(100);//0.1��
			
			System.out.println("t2 ����ֳ�? : " + t2.isAlive());
			
			Thread.sleep(1000);
			
			System.out.println("1���� t2 ����ֳ�? : " + t2.isAlive());
			
			t2.join();
			
			System.out.println("t2 ����ֳ�? : " + t2.isAlive());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
