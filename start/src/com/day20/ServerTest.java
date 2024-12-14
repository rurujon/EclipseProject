package com.day20;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest extends Frame implements ActionListener,Runnable{	//�������̽��� ���߻���� �����ϴ�

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	private ServerSocket ss = null;
	private Socket sc = null;
	
	public ServerTest() {
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);;
			}
		});
		
		setTitle("ä�� ����");
		setSize(300,400);
		setVisible(true);
	}
	
	public void serverStart() {
		
		try {
			
			//���� ���� ����
			ss = new ServerSocket(5555);
			ta.setText("���� ����");
			
			sc = ss.accept();
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		ServerTest ob = new ServerTest();
		ob.serverStart();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//���� ������ �޼���
		
		String str = tf.getText();
		
		if(str.trim().equals("")) {
			return;
		}
		
		if(sc==null) {
			return;
		}
		
		try {
			
			//OutputStream os = sc.getOutputStream(os);
			
			PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);	//true : flush�� ���� ���. �ɰ����鵵 �� ��������.
			
			pw.println("����]" + str);		//Ŭ���̾�Ʈ���� ����
			
			ta.append("\r\n ����]" + str);	//������ ���	
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			
			ta.append("\r\n Ŭ���̾�Ʈ�� ������ ������ϴ�.");
			sc = null;
		}
		
	}

	@Override
	public void run() {
		
		//��밡 ������ �޽���
		
		String str;
		String ip;
		
		try {
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			ip= sc.getInetAddress().getHostAddress();
			ta.append("\r\n[" + ip + "] ����");
			
			while((str=br.readLine())!=null) {
				ta.append("\r\n" + str);
			}
		
				
			
		} catch (Exception e) {
			ta.append("\t\n Ŭ���̾�Ʈ�� ���� ����");
			sc = null;
			ss = null;
		}
	}

}
