package com.day17;

//스레드 생명주기

class MyThread6 extends Thread{
	
	@Override
	public void run() {
		
		try {
			
			System.out.println("스레드 시작");
			System.out.println("우선순위 : " + getPriority());
			System.out.println("스레드 이름 : " + getName());
			
			sleep(500);
			
			//우선순위 변경
			setPriority(2);
			System.out.println("변경된 우선 순위 : " + getPriority());
			
			System.out.println("스레드 종료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
public class Test6 {

	public static void main(String[] args) {
		
		Thread t1 = Thread.currentThread();		//현재 스레드를 여기에 넣어라 : main
		Thread t2 = new MyThread6();
		
		System.out.println("메인 스레드 우선순위 : " + t1.getPriority());//5
		System.out.println("메인 스레드 이름 : " + t1.getName());//main
		System.out.println("start 메서드 실행 전 is Alive  : " + t2.isAlive());//false
		
		t2.start();
		
		//t2의 우선순위
		System.out.println("t2의 우선 순위 : " + t2.getPriority());//5
		
		//t2의 우선순위
		t2.setPriority(1);
		try {
			
			Thread.sleep(100);//0.1초
			
			System.out.println("t2 살아있냐? : " + t2.isAlive());
			
			Thread.sleep(1000);
			
			System.out.println("1초후 t2 살아있냐? : " + t2.isAlive());
			
			t2.join();
			
			System.out.println("t2 살아있냐? : " + t2.isAlive());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
