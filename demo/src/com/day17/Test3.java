package com.day17;

import java.util.Calendar;

class MyThread3 implements Runnable{

	@Override
	public void run() {
		
		
		
		while(true) {
			Calendar cal =Calendar.getInstance();
			System.out.printf("%1$tF\n %1$tT\n",cal);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
}

public class Test3 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyThread3());
		t1.start();

	}

}
