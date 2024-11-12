package com.day16;

import java.io.IOException;
import java.util.Scanner;

//throw로 예외를 의도적으로 발생시키기.

public class Test3 {
	
	
	
	public static String getOper() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String oper = "";
		try {
			
			System.out.println("연산자?");
			oper = sc.next();
			
			if(!oper.equals("+") && !oper.equals("-") &&!oper.equals("*") && !oper.equals("/")) {
				
				
				//throw로 예외를 의도적으로 발생시킴.
				//throw를 사용하면 위 메소드 옆에 throws Exception을 반드시 명시
				//호출하는 곳에서는 반드시 try~catch 문을 사용해야함
				throw new Exception("연산자 입력 오류.");
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		return oper;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int num1, num2, result;
		String oper;
		
		
		try {
			
			System.out.println("두개의 수");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			oper = Test3.getOper();
			
			result = 0;
			
			if(oper.equals("+")) {
				result = num1+num2;
			}
			else if(oper.equals("-")) {
				result = num1-num2;
			}
			else if(oper.equals("*")) {
				result = num1*num2;
			}
			else if(oper.equals("/")) {
				result = num1/num2;
			}
			
			System.out.printf("%d %s %d = %d\n",num1,oper,num2,result);
			
		}
		catch (Exception e) {		//0으로 나눴을 때의 오류를 처리하는 부서.
			System.out.println(e.toString());
			// TODO: handle exception
		}
			
		
		

	}

}
