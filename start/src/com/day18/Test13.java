package com.day18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//��ü�� ����ȭ
//�޸𸮿� ������ Ŭ������ �ν��Ͻ� ������ ���� ���¸�
//�״�� �����ؼ� ���Ͽ� �����ϰų� ��Ʈ��ũ�� ���� �����ϴ� ����� �����Ѵ�.
//����Ʈ �����θ� �����͸� �ۼ����� �� �ִ�.

//��ü(Ŭ����) ��ü�� ������ ����� ���Ŀ� ���ֹ��� �ʰ� ��ü��
//���Ͽ� ���������ν� ���Ӽ��� �����ϰ� ��Ʈ��ũ�� ����
//�ս��� ��ȯ�� �� �ְ� �ȴ�.

//implements Serializable�� �����Ѵ�.)�޼��尡 ����.
//�޸𸮿� �ִ� ���� �ϵ��ũ�� ���� ���� �����Ѵ�.


public class Test13 {

	public static void main(String[] args) throws IOException {
		
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		h.put("1", "�����" );
		h.put("2", "�ڹο�");
		h.put("3", "�ڽ���" );			//�����ϰ� �Ϸ�� ����
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\data.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(h);	//���Ͽ� ����
		oos.close();
		fos.close();
		
		System.out.println("���Ͽ� ����߽��ϴ�.");
 
	}

}
