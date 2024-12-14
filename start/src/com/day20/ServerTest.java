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

public class ServerTest extends Frame implements ActionListener,Runnable{	//인터페이스는 다중상속이 가능하다

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
		
		setTitle("채팅 서버");
		setSize(300,400);
		setVisible(true);
	}
	
	public void serverStart() {
		
		try {
			
			//서버 소켓 생성
			ss = new ServerSocket(5555);
			ta.setText("서버 시작");
			
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
		
		//내가 보내는 메세지
		
		String str = tf.getText();
		
		if(str.trim().equals("")) {
			return;
		}
		
		if(sc==null) {
			return;
		}
		
		try {
			
			//OutputStream os = sc.getOutputStream(os);
			
			PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);	//true : flush와 같은 기능. 쪼가리들도 다 내보낸다.
			
			pw.println("서버]" + str);		//클라이언트에게 전송
			
			ta.append("\r\n 서버]" + str);	//나에게 출력	
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			
			ta.append("\r\n 클라이언트와 접속이 끊겼습니다.");
			sc = null;
		}
		
	}

	@Override
	public void run() {
		
		//상대가 보내는 메시지
		
		String str;
		String ip;
		
		try {
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			ip= sc.getInetAddress().getHostAddress();
			ta.append("\r\n[" + ip + "] 접속");
			
			while((str=br.readLine())!=null) {
				ta.append("\r\n" + str);
			}
		
				
			
		} catch (Exception e) {
			ta.append("\t\n 클라이언트가 연결 종료");
			sc = null;
			ss = null;
		}
	}

}
