package com.day16;

import java.io.IOException;
import java.util.Scanner;

//throw�� ���ܸ� �ǵ������� �߻���Ű��.

public class Test3 {
	
	
	
	public static String getOper() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String oper = "";
		try {
			
			System.out.println("������?");
			oper = sc.next();
			
			if(!oper.equals("+") && !oper.equals("-") &&!oper.equals("*") && !oper.equals("/")) {
				
				
				//throw�� ���ܸ� �ǵ������� �߻���Ŵ.
				//throw�� ����ϸ� �� �޼ҵ� ���� throws Exception�� �ݵ�� ���
				//ȣ���ϴ� �������� �ݵ�� try~catch ���� ����ؾ���
				throw new Exception("������ �Է� ����.");
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
			
			System.out.println("�ΰ��� ��");
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
		catch (Exception e) {		//0���� ������ ���� ������ ó���ϴ� �μ�.
			System.out.println(e.toString());
			// TODO: handle exception
		}
			
		
		

	}

}
