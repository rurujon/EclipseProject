package com.day21;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ChatCS extends Frame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MulticastSocket ms = null;
	private InetAddress XGroup = null;
	
	//그룹범위 : D class(224.0.0.0~239.255.255.255)
	//DatagramSocket : UDP로 데이터그램 패킷을 전송하거나 수신
	//DatagramPacket : UDP를 이용하여 전송될 수 있는 데이터
	//MulticastSocket : 다수의 클라이언트에게 데이터그램을 전송
	
	private String host = "230.0.0.1";
	private int port = 5555;
	private String userName = "윤재";
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	public ChatCS() {
		
		ta.setEditable(false);
		add(ta,BorderLayout.CENTER);
		
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("그룹채팅 [" + host + "]");
		setSize(400,400);
		setVisible(true);
		tf.requestFocus();
		
	}
	
	public void setup() {
		
		try {
			
			XGroup = InetAddress.getByName(host);
			
			ms = new MulticastSocket(port);
			
			//특정 그룹에 포함
			ms.joinGroup(XGroup);		//같은 그룹끼리 송수신이 가능해진다.
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}
	}
	
	public void disConnection() {
		
		try {
			
			//특정 그룹에서 빠져나옴
			ms.leaveGroup(XGroup);
			ms.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) {
		
		new ChatCS().setup();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = tf.getText().trim();
		if(str.equals("")) {
			
			return;
		}
		
		byte[] buffer = (userName + "]"+ str).getBytes();		//string 값을 byte 값으로
		
		try {
			
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, XGroup, port);
			
			ms.send(dp);
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			System.out.println(e2.toString());
		}
	}

	@Override
	public void run() {
		
		try {
			
			while(true) {
				
				byte[] buffer = new byte[512];
				
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				
				ms.receive(dp);
				String str = new String(dp.getData()).trim();
				ta.append(str + "\r\n");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			disConnection();
		}
	}

}
