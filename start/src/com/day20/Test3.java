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
		
		System.out.println("Ŭ������ [��:java.lang.String]? ");
		String str = br.readLine();
		
		Class cls = Class.forName(str);
		
		//������ ����
		Constructor[] c = cls.getConstructors();
		
		System.out.println("\n������ ����.....");
		
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
		
		//�ʵ� ����
		Field[] f = cls.getFields();
		System.out.println("\n�ʵ� ����.....");
		
		for(int i=0; i<f.length; i++) {
			System.out.println(f[i]);
		}
		
		//�޼��� ����
		Method[] m = cls.getMethods();
		System.out.println("\n�޼��� ����.....");
		
		for(int i=0; i<m.length; i++) {
			System.out.println(m[i]);
		}
		
		
		
		
	}

}
