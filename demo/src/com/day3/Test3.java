package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		//���
		//if, for, while, do~while, switch
		
		
		BufferedReader br = new BufferedReader(
				
				new InputStreamReader(System.in));
		
		int num;
		String str="";
		
		System.out.print("�� �Է�?"); //788
		num = Integer.parseInt(br.readLine());
		
		//if (���ǽ�){�۾�}else{�۾�}
		//���� if��
		
		if(num%2==0) {
			str = "¦��";
			
		}
		else str = "Ȧ��";
		
		System.out.println(num + ":" + str);

	}

}
