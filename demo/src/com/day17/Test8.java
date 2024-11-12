package com.day17;

class MyThread8 implements Runnable{
	
	private int bank = 10000;
	private int getBank() {
		return bank;
	}
	
	private int drawMoney(int m) {
		
		if(getBank()>0) {
			bank -= m;
			System.out.println(Thread.currentThread().getName() + ", ���� : " + m + ". �ܾ� : " + bank);
		}
		else {
			m=0;
			System.out.println(Thread.currentThread().getName() + ", �ܾ� ����");
		}
		
		return m;
	}
	
	@Override
	public void run() {
		
		synchronized (this) {
			
			//�ϳ��� �����尡 ������̸� �ٸ� ������� �� ���� ������ �� ����.
			//��, ���� �����ϰ� �Ϸ��� wait�� �ʿ�.
			
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
