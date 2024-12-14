package com.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//String의 메소드로 만든 계산기 v4.0

public class Test5 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.print("수식[3+5]?"); //3+5, 13+45, 1 5 + 6 5
		String str = br.readLine();
		
		str = str.replaceAll("\\s", "");
		
		//String[] op = {"+", "-", "*", "/"};
		//for(String oper : op){}
		
		for(String op : new String[]{"+", "-", "*", "/"}) {
			
			int pos = str.indexOf(op);
			if(pos>-1) {
				
				int num1 = Integer.parseInt(str.substring(0,pos));
				int num2 = Integer.parseInt(str.substring(pos+1));
				
				//System.out.println(num1 + ":" + num2);
				
				int result = 0;
				
				char oper = str.charAt(pos);
				//System.out.println(oper);
				
				switch(oper)	{
				
				case '+' : result = num1+num2; break;
				case '-' : result = num1-num2; break;
				case '*' : result = num1*num2; break;
				case '/' : result = num1/num2; break;
				
				}
				
				String s = String.format("%d %c %d = %d",num1,oper,num2,result);
				
				System.out.println(s);
			}//end if
			
		}//end for
		

	}

}
