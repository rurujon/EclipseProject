package com.day17;

class MyThread7 implements Runnable{
	
	private int bank = 10000;
	
	private int getBank() {
		return bank;
	}
	
	private int drawMoney(int m) {
		bank -= m;	//����(bank) = bank-m
		return m;	//����ݾ�
	}

	@Override
	public void run() {
		
		int moneyNeed = 6000; //������ �ݾ�
		int money;
		String msg = "";
		
		try {
			
			synchronized (this) {
				
			
				if(getBank()>=moneyNeed) {
					money = drawMoney(moneyNeed);
					msg = "���� ����";
				}
				else {
					money = 0;
					msg = "���� ����";
				}
			}
			
			System.out.println(Thread.currentThread().getName() + msg + ", ��Ǯ �ݾ� : " + money + ", �ܰ� : " + getBank());
			
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
