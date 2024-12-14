package com.day16;

import java.util.Scanner;

//Exception(예외처리)

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1, num2, result;
		String oper;
		
		try {
			
			System.out.println("두개의 수");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.println("연산자?");
			oper = sc.next();
			
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
		catch (ArithmeticException e) {		//0으로 나눴을 때의 오류를 처리하는 부서.
			System.out.println("0으로 나눌 수 없습니다.");
			// TODO: handle exception
		}
		
		catch (Exception e) {
			
			System.out.println("넌 그게 숫자로 보이냐");
			System.out.println(e.toString());
			e.printStackTrace();
			
		}	finally {
			System.out.println("항상 에러 조심");
		}
		

	}

}
