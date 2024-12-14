package com.day18;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Test14 {

	public static void main(String[] args) {
		
		//역 직렬화
		
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\data.txt");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Hashtable<String, String> h = (Hashtable<String, String>)ois.readObject();
			
			//System.out.println(h);
			
			Iterator<String> it = h.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				String value = h.get(key);
				System.out.println(key + ":" + value);
			}
			
			fis.close();
			ois.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
