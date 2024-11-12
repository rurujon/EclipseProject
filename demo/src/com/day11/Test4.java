package com.day11;

public class Test4 {

	public static void main(String[] args) {
		
		String s1 = "����,�λ�,�뱸";
		String ss[] = s1.split(",");
		
		for(String s : ss) {
			System.out.print(s + " ");
		}
		
		String s2 = "seoul";
		String s3 = "Seoul";
		System.out.println(s2.equals(s3));
		System.out.println(s2.equalsIgnoreCase(s3)); //��ҹ��� �������� �ʰ� ���ϱ�.
		
		String s4 = "abc.def.hij";
		System.out.println(s4.indexOf("."));//3
		System.out.println(s4.lastIndexOf("."));//7
		System.out.println(s4.indexOf("def"));//7
		System.out.println(s4.indexOf("x"));//-1
		
		if(s4.indexOf("x")!=-1) {
			
			
		}
		
		String s5 = "�츮���� ���ѹα� �������� ���ѹα�";
		String s6 = s5.replaceAll("����", "����");
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim());
		System.out.println(s7.replaceAll(" ", ""));
		System.out.println(s7.replaceAll("\\s", "")); //\\s : �� ĭ�� ����.
		
		String a = "abcdefg";
		char ch = "abcdefg".charAt(2); // ���ڿ��� n+1 ���� �о�� (0~n)
		System.out.println(ch);//c
		
		System.out.println("abc defg".length());//���ڿ��� ���� : 8
		
		String s8 = "abcdefg";
		String s9 = "abcbbbb";
		
		
		//������ �迭
		System.out.println(s8.compareToIgnoreCase(s9)); //�ƽ�Ű�� ��. 100-98
		System.out.println(s9.compareToIgnoreCase(s8)); //98-100
		
	}
}
