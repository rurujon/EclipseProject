package com.seri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.score2.ScoreVO;



public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Score ob = new Score();
		
		int ch;
		
		
		
		while(true) {
			
			do {
				System.out.print("1. �Է� 2. ��� 3. ���� 4. ����");
				ch=sc.nextInt();
			}while(ch<1);
			
			switch (ch) {
			case 1 : 
				ob.input();	break;
			case 2 : 
				ob.print(); break;
			case 3 : 
				ob.save(); 	break;
			default :
				ob.end(); 	
				
			}
			
			
		}
	}

}
