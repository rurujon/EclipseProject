package com.day17;

class MyThread7 implements Runnable{
	
	private int bank = 10000;
	
	private int getBank() {
		return bank;
	}
	
	private int drawMoney(int m) {
		bank -= m;	//인출(bank) = bank-m
		return m;	//인출금액
	}

	@Override
	public void run() {
		
		int moneyNeed = 6000; //인출할 금액
		int money;
		String msg = "";
		
		try {
			
			synchronized (this) {
				
			
				if(getBank()>=moneyNeed) {
					money = drawMoney(moneyNeed);
					msg = "인출 성공";
				}
				else {
					money = 0;
					msg = "인출 실패";
				}
			}
			
			System.out.println(Thread.currentThread().getName() + msg + ", 인풀 금액 : " + money + ", 잔고 : " + getBank());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}

public class Test7 {

	public static void main(String[] args) {
		
		MyThread7 ob = new MyThread7();
		
		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();

	}

}
