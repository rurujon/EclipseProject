package com.day14;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Test3 {
	
	private static final String city[] = {"����","�λ�","�뱸","��õ","����","����","���"};

	public static void main(String[] args) {
		
		Vector<String> lists = new Vector<String>();
		
		System.out.println("�ʱ� �뷮 : " + lists.capacity());
		
		for(String c : city) {
			lists.add(c);
		}
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		System.out.println("�������� ���� : " + lists.size() + "��");
		
		//����
		lists.set(0, "Seoul");
		lists.set(1, "Pusan");
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//����
		lists.insertElementAt("���ѹα�", 0);
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//�˻�
		int index = lists.indexOf("�뱸");	//indexOf �˻����� ������ -1�� ��ȯ.
		if(index!=-1) {
			System.out.println("�˻� ���� : " + index);
		}
		else {
			System.out.println("�˻� ���� : " + index);
		}
		
		//��������
		Collections.sort(lists);	
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//��������
		Collections.sort(lists, Collections.reverseOrder());
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//����
		lists.remove("Pusan"); //lists.remove(7);
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		//�뷮 ����
		for(int i = 1; i<=20; i++) {
			lists.add(Integer.toString(i));
		}
		System.out.println("���� �뷮 : " + lists.capacity());
		System.out.println("�������� ���� : " + lists.size() + "��");
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//Ư�� ���� ����
		for(int i =1; i<=10; i++) {
			lists.remove(5);
		}
		System.out.println("���� �뷮 : " + lists.capacity());
		System.out.println("�������� ���� : " + lists.size() + "��");
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//���� ����
		lists.trimToSize();
		System.out.println("���� �뷮 : " + lists.capacity());
		System.out.println("�������� ���� : " + lists.size() + "��");
		
		//������ ����
		lists.clear();
		System.out.println("���� �뷮 : " + lists.capacity());
		System.out.println("�������� ���� : " + lists.size() + "��");

	}

}
