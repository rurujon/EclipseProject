package com.day19;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test4 extends Frame{
	
	public Test4() {

		setTitle("������");
		setSize(200,300);

		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
	}
	//Nested Class
	/*class MyWindowAdapter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
		
	}*/




	public static void main(String[] args) {
		
		new Test4();

	}

}
