package com.day16;

import java.util.Scanner;

//Exception(����ó��)

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1, num2, result;
		String oper;
		
		try {
			
			System.out.println("�ΰ��� ��");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.println("������?");
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
		catch (ArithmeticException e) {		//0���� ������ ���� ������ ó���ϴ� �μ�.
			System.out.println("0���� ���� �� �����ϴ�.");
			// TODO: handle exception
		}
		
		catch (Exception e) {
			
			System.out.println("�� �װ� ���ڷ� ���̳�");
			System.out.println(e.toString());
			e.printStackTrace();
			
		}	finally {
			System.out.println("�׻� ���� ����");
		}
		

	}

}
