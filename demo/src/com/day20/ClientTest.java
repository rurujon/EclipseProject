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

public class ClientTest extends Frame implements ActionListener,Runnable{	//인터페이스는 다중상속이 가능하다

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	//private ServerSocket ss = null;			//다름
	private Socket sc = null;
	private int port = 5555;					//다름
	private String host = /*"127.0.0.1"*/"192.168.16.0";			//localhost : 루프백 주소
	
	
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
		
		setTitle("채팅 클라이언트");
		setSize(300,400);
		setVisible(true);
	}
	
	public void connect() {
		
		try {
			
			//서버 소켓 생성
			//ss = new ServerSocket(5555);
			//ta.setText("서버 시작");
			
			sc = new Socket(host, port);
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			ta.append("서버가 죽었어?!");
			
		}
	}

	public static void main(String[] args) {
		ClientTest ob = new ClientTest();
		ob.connect();

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
			
			pw.println("윤재]" + str);		//서버에게 전송
			
			ta.append("\r\n 윤재]" + str);	//나에게 출력	
			tf.setText("");							//텍스트필드에 적은 값 초기화
			tf.requestFocus();						//커서를 텍스트 필드로
			
		} catch (Exception e2) {
			
			ta.append("\r\n 서버와 접속이 끊겼습니다.");
			sc = null;
		}
		
	}

	@Override
	public void run() {
		
		//상대가 보내는 메시지
		
		String str;
		//String ip;
		
		try {
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//ip= sc.getInetAddress().getHostAddress();
			//ta.append("\r\n[" + ip + "] 접속");
			
			while((str=br.readLine())!=null) {
				ta.append("\r\n" + str);
			}
		
				
			
		} catch (Exception e) {
			ta.append("\t\n 서버 연결 종료");
			sc = null;
			//ss = null;
		}
	}

}
