package com.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("클래스명 [예:java.lang.String]? ");
		String str = br.readLine();
		
		Class cls = Class.forName(str);
		
		//생성자 정보
		Constructor[] c = cls.getConstructors();
		
		System.out.println("\n생성자 정보.....");
		
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
		
		//필드 정보
		Field[] f = cls.getFields();
		System.out.println("\n필드 정보.....");
		
		for(int i=0; i<f.length; i++) {
			System.out.println(f[i]);
		}
		
		//메서드 정보
		Method[] m = cls.getMethods();
		System.out.println("\n메서드 정보.....");
		
		for(int i=0; i<m.length; i++) {
			System.out.println(m[i]);
		}
		
		
		
		
	}

}
