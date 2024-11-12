package com.day17;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//TimerTask, Timer
//정해진 시간마다 특정 작업을 하려고 할 때.


public class Test9 extends Thread{
	
	private int num = 0;
	
	public Test9() {
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				num = 1;//반복할 작업.
			}
		};
		
		Timer t = new Timer();
		
		Calendar now = Calendar.getInstance();
		
		/*
		 * 내일 0시 0분 0초부터 하루에 한 번씩 반복 실행
		 * now.add(Calendar.DATE,1);
		 * now.set(Calendar.HOUR,0);	//오후 1시 : 13
		 * now.set(Calendar.MINUTE,0); 
		 * now.set(Calendar.SECOND,0); 
		 * now.set(Calendar.MILLISECOND,0); 
		 * 
		 * t.schedule(task,now,getTime(), 1000*60*60*24);	//미리 * 초 * 분 * 시
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
