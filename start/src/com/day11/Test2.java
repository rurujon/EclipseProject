package com.day11;

//StringBuffer
//StringBuilder

public class Test2 {
	
	public void stringTime() {
		System.out.println("String ...");
		
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		String str = "A";
		
		for(int i=1; i<=50000; i++) {
			str += "A"; //str = str + "A"
		}
		
		long end = System.nanoTime();
		
		System.out.println("����ð� : " + (end-start) + "ms");
		
	}
	
	public void stringBuffer() { //���� : ����ȭ ����
		System.out.println("StringBuffer ...");
		
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		StringBuffer str = new StringBuffer("A");
		
		for(int i=1; i<=50000; i++) {
			str.append("A"); //str = str + "A"
		}
		
		long end = System.nanoTime();
		
		System.out.println("����ð� : " + (end-start) + "ms");
		
	}
	
	public void stringBuilder() { //���� : ����ȭ ���� X
		System.out.println("StringBuilder ...");
		
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		StringBuilder str = new StringBuilder("A");
		
		for(int i=1; i<=50000; i++) {
			str.append("A"); //str = str + "A"
		}
		
		long end = System.nanoTime();
		
		System.out.println("����ð� : " + (end-start) + "ms");
		
	}
	
	

	public static void main(String[] args) {
		
		Test2 ob = new Test2();
		ob.stringTime();
		ob.stringBuffer();
		ob.stringBuilder();

	}

}
