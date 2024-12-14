package com.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//Ŭ���̾�Ʈ�� ������ ���� �ϳ��� ������ ������ ��� Ŭ���̾�Ʈ�� ������ ������ �־�� �Ѵ�.
//�̸� ���� ������ �����ϴ� ������ List�� ����� ����, �����Ѵ�.
//���� ������ �Ұ����ϰ� ���������� �����Ѵ�.

public class ServerTest {
	
	private List<Socket> clients = new ArrayList<Socket>();
	
	public void serverStart() {
		
		try {
			
			ServerSocket ss = new ServerSocket(5555);
			System.out.println("���� ���� ...");
			
			while(true) {
				
				Socket sc = ss.accept();		//40 WorkThread��
				
				//������
				
				WorkThread wt = new WorkThread(sc);
				wt.start();
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//���ν�����Ŭ����
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
				
				//������ Ŭ���̾�Ʈ�� ����
				clients.add(sc);
				
				msg = ip + "]�� �����߽��ϴ�.";
				
				for(Socket s : clients) {
					if(s==sc){
						continue;//�̹��� ����. ������ �¾��� ��, �̹� �� ���� �Ʒ��� �ڵ��� �������� �ʰ� �������� �Ѿ��.
					}
					
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
					pw.println(msg);
				}
				
				System.out.println(msg);//������ ���
				
				//���޹��� �޼����� ���� ������ Ŭ���̾�Ʈ���� �����Ѵ�.
				while((msg=br.readLine())!=null){
					
					for(Socket s : clients) {
						if(s==sc){
							continue;//�̹��� ����. ������ �¾��� ��, �̹� �� ���� �Ʒ��� �ڵ��� �������� �ʰ� �������� �Ѿ��.
						}
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					
					System.out.println(msg);
					
				}
				
				
			} catch (Exception e) {

				msg = ip + "] �� �����߽��ϴ�.";
				
				try {
					
					for(Socket s : clients) {
						if(s==sc){
							continue;//�̹��� ����. ������ �¾��� ��, �̹� �� ���� �Ʒ��� �ڵ��� �������� �ʰ� �������� �Ѿ��.
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
