package com.day17;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//TimerTask, Timer
//������ �ð����� Ư�� �۾��� �Ϸ��� �� ��.


public class Test9 extends Thread{
	
	private int num = 0;
	
	public Test9() {
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				num = 1;//�ݺ��� �۾�.
			}
		};
		
		Timer t = new Timer();
		
		Calendar now = Calendar.getInstance();
		
		/*
		 * ���� 0�� 0�� 0�ʺ��� �Ϸ翡 �� ���� �ݺ� ����
		 * now.add(Calendar.DATE,1);
		 * now.set(Calendar.HOUR,0);	//���� 1�� : 13
		 * now.set(Calendar.MINUTE,0); 
		 * now.set(Calendar.SECOND,0); 
		 * now.set(Calendar.MILLISECOND,0); 
		 * 
		 * t.schedule(task,now,getTime(), 1000*60*60*24);	//�̸� * �� * �� * ��
		 */
		
		t.schedule(task, now.getTime(), 5000);//
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(num++);
			try {
				sleep(1000);
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		
		//Test9 ob = new Test9();
		//ob.start();
		
		new Test9().start();

	}

}
