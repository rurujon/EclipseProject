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

public class ClientTest extends Frame implements ActionListener,Runnable{	//�������̽��� ���߻���� �����ϴ�

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	//private ServerSocket ss = null;			//�ٸ�
	private Socket sc = null;
	private int port = 5555;					//�ٸ�
	private String host = /*"127.0.0.1"*/"192.168.16.0";			//localhost : ������ �ּ�
	
	
	public ClientTest() {
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);;
			}
		});
		
		setTitle("ä�� Ŭ���̾�Ʈ");
		setSize(300,400);
		setVisible(true);
	}
	
	public void connect() {
		
		try {
			
			//���� ���� ����
			//ss = new ServerSocket(5555);
			//ta.setText("���� ����");
			
			sc = new Socket(host, port);
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			ta.append("������ �׾���?!");
			
		}
	}

	public static void main(String[] args) {
		ClientTest ob = new ClientTest();
		ob.connect();

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
			
			pw.println("����]" + str);		//�������� ����
			
			ta.append("\r\n ����]" + str);	//������ ���	
			tf.setText("");							//�ؽ�Ʈ�ʵ忡 ���� �� �ʱ�ȭ
			tf.requestFocus();						//Ŀ���� �ؽ�Ʈ �ʵ��
			
		} catch (Exception e2) {
			
			ta.append("\r\n ������ ������ ������ϴ�.");
			sc = null;
		}
		
	}

	@Override
	public void run() {
		
		//��밡 ������ �޽���
		
		String str;
		//String ip;
		
		try {
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//ip= sc.getInetAddress().getHostAddress();
			//ta.append("\r\n[" + ip + "] ����");
			
			while((str=br.readLine())!=null) {
				ta.append("\r\n" + str);
			}
		
				
			
		} catch (Exception e) {
			ta.append("\t\n ���� ���� ����");
			sc = null;
			//ss = null;
		}
	}

}
