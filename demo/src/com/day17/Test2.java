package com.day17;

class MyThread2 implements Runnable{
	
	private int num;
	private String name;
	
	public MyThread2(int num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public void run() {
		
		int i=0;
		while(i<num) {
			
			System.out.println(name + ":" + i);
			i++;
			
			try {
				Thread.sleep(100);//Runnable에는 슬립이란 메서드가 없다. 고로 스레드 것을 빌린다.
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("메인 시작.");
		
		Thread t1 = new Thread(new MyThread2(100, "첫번째"));
		Thread t2 = new Thread(new MyThread2(200, "두번째"));
		
		t1.start();
		t2.start();
		
		
		System.out.println("메인 종료.");
		
		
		

	}

}
