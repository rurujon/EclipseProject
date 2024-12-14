package com.day21;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerTest{
	
	

	class WorkThread extends Thread{
		
		private Socket sc = null;
		
		public WorkThread(Socket sc) {
			this.sc = sc;
		}
		
		@Override
		public void run() {
			try {
				
				//fileinputstream : 클라이언트에 있는 파일을 읽어내고
				//objectoutputstream : 내보낸다.
				//objectinputstream : 서버는 그 파일을 받아 읽어내고
				//fileoutputstream : 서버의 파일에다가 기록한다.
				
				ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
				System.out.println("클라이언트 접속");
				
				FileOutputStream fos = null;
				Object ob = null;
				
				while((ob=ois.readObject())!=null) {
					
					if(ob instanceof FileInfo) {
						
						FileInfo info = (FileInfo)ob;
						
						if(info.getCode()==100) {		//파일 전송 시작(파일명)
							
							String str = new String(info.getData());
							fos = new FileOutputStream(str);	//파일 생성
							System.out.println(str + "파일 전송 시작");
						}
						else if(info.getCode()==110) {	//파일 전송중
							
							if(fos==null) {
								break;
							}
							
							fos.write(info.getData(),0,info.getSize());
							
							System.out.println(info.getSize() + "bytes 받는 중");
						}
						else if(info.getCode()==200) {	//파일 전송 완료(파일명)
							
							if(fos==null) {
								break;
							}
							String str = new String(info.getData());	//파일명
							
							fos.close();
							System.out.println(str + "파일 전송 끝");
							
						}
						
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	public void serverStart() {
		
		try {
			
			ServerSocket ss = new ServerSocket(5555);
			System.out.println("클라이언트 접속 대기중");
			
			Socket sc = ss.accept();
			
			WorkThread wt = new WorkThread(sc);
			wt.start();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		
		new FileServerTest().serverStart();
		
		
	}

}
