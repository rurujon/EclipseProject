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
			//직렬화가 된 것은 다른 클래스에서 읽어내기 어려우므로 ObjectInputStream으로 감싸 다른 클래스들도 읽어낼 수 있도록 한다.
			
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
