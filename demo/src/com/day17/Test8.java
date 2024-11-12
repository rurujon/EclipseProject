package com.day17;

class MyThread8 implements Runnable{
	
	private int bank = 10000;
	private int getBank() {
		return bank;
	}
	
	private int drawMoney(int m) {
		
		if(getBank()>0) {
			bank -= m;
			System.out.println(Thread.currentThread().getName() + ", 인출 : " + m + ". 잔액 : " + bank);
		}
		else {
			m=0;
			System.out.println(Thread.currentThread().getName() + ", 잔액 부족");
		}
		
		return m;
	}
	
	@Override
	public void run() {
		
		synchronized (this) {
			
			//하나의 스레드가 사용중이면 다른 스레드는 이 블럭에 진입할 수 없다.
			//단, 접근 가능하게 하려면 wait가 필요.
			
			for(int i=1; i<=10; i++) {
				if(getBank()<=0) {
					break;
				}
				
				drawMoney(1000);
				
				if(getBank()==2000||getBank()==4000||getBank()==6000||getBank()==8000) {
					
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}else {
					notify();
				}
			}
			
		}
	}
}

public class Test8 {

	public static void main(String[] args) {
		
		MyThread8 ob = new MyThread8();
		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();

	}

}
