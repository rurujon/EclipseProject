package com.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//클라이언트의 소켓은 각각 하나면 되지만 서버는 모든 클라이언트의 소켓을 가지고 있어야 한다.
//이를 위해 서버가 관리하는 소켓을 List로 만들어 보관, 관리한다.
//동시 접속은 불가능하고 순차적으로 접속한다.

public class ServerTest {
	
	private List<Socket> clients = new ArrayList<Socket>();
	
	public void serverStart() {
		
		try {
			
			ServerSocket ss = new ServerSocket(5555);
			System.out.println("서버 시작 ...");
			
			while(true) {
				
				Socket sc = ss.accept();		//40 WorkThread로
				
				//스레드
				
				WorkThread wt = new WorkThread(sc);
				wt.start();
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//내부스레드클래스
	class WorkThread extends Thread{
		
		private Socket sc;
		
		public WorkThread(Socket sc) {
			this.sc = sc;
		}
		
		@Override
		public void run() {
			
			String ip = null;
			String msg = null;
			
			try {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				ip = sc.getInetAddress().getHostAddress();
				
				//접속한 클라이언트를 저장
				clients.add(sc);
				
				msg = ip + "]가 입장했습니다.";
				
				for(Socket s : clients) {
					if(s==sc){
						continue;//이번만 생략. 조건이 맞았을 때, 이번 한 번만 아래의 코딩을 실행하지 않고 다음으로 넘어간다.
					}
					
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
					pw.println(msg);
				}
				
				System.out.println(msg);//서버에 출력
				
				//전달받은 메세지를 나를 제외한 클라이언트에게 전송한다.
				while((msg=br.readLine())!=null){
					
					for(Socket s : clients) {
						if(s==sc){
							continue;//이번만 생략. 조건이 맞았을 때, 이번 한 번만 아래의 코딩을 실행하지 않고 다음으로 넘어간다.
						}
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					
					System.out.println(msg);
					
				}
				
				
			} catch (Exception e) {

				msg = ip + "] 가 퇴장했습니다.";
				
				try {
					
					for(Socket s : clients) {
						if(s==sc){
							continue;//이번만 생략. 조건이 맞았을 때, 이번 한 번만 아래의 코딩을 실행하지 않고 다음으로 넘어간다.
						}
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					
					System.out.println(msg);
					sc = null;
					
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		ServerTest ob = new ServerTest();
		ob.serverStart();
		
		

	}

}
