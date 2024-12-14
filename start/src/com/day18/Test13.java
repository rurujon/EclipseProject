package com.day18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//객체의 직렬화
//메모리에 생성된 클래스의 인스턴스 변수의 현재 상태를
//그대로 보존해서 파일에 저장하거나 네트워크를 통해 전달하는 기능을 제공한다.
//바이트 단위로만 데이터를 송수신할 수 있다.

//객체(클래스) 자체의 내용을 입출력 형식에 구애받지 않고 개체를
//파일에 저장함으로써 연속성을 제공하고 네트워크를 통해
//손쉽게 교환할 수 있게 된다.

//implements Serializable로 구현한다.)메서드가 없다.
//메모리에 있는 값을 하드디스크에 고대로 들고와 저장한다.


public class Test13 {

	public static void main(String[] args) throws IOException {
		
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		h.put("1", "배수지" );
		h.put("2", "박민영");
		h.put("3", "박신혜" );			//직렬하가 완료된 상태
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\data.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(h);	//파일에 쓰기
		oos.close();
		fos.close();
		
		System.out.println("파일에 기록했습니다.");
 
	}

}
