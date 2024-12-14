package com.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestEx{
	
	public void print(String r) {
		System.out.println(r);
	}
}

class CalcEx extends TestEx{
	String str;
	public void input() throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("계산 입력(1+1)");
		str = br.readLine();
		
		str = str.replaceAll("\\s", "");
		System.out.println(str);//확인용
		
	}
	
	public String calc() {
		
		String end = "";
		int pos;
		
		for(String op : new String[]{"+", "-", "*", "/"}) {
			
			pos = str.indexOf(op);
			
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
				
				end = Integer.toString(result);
				
			}//end if

		}//end for
		
		return end;
		
		
		
	}
	
	
}

public class Test6 {

	public static void main(String[] args) throws IOException {
		
		CalcEx ob = new CalcEx();
		
		ob.input();
		String r = ob.calc();
		ob.print(r);

	}

}
