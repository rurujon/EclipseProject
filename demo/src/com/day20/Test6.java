package com.day20;

import java.net.InetAddress;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String host;
		
		System.out.println("호스트[ex : www.naver.com]? ");
		host = sc.next();
		
		try {
			
			InetAddress ia = InetAddress.getByName(host);
			
			System.out.println("ip주소 : " + ia.getHostAddress());
			System.out.println("호스트 : " + ia.getHostName());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
