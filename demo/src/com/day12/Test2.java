package com.day12;

import java.util.Calendar;import java.util.Locale.Category;

public class Test2 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int y = now.get(Calendar.YEAR);//��
		int m = now.get(Calendar.MONTH)+1;//��(0~11)
		int d = now.get(Calendar.DATE);//��
		int w = now.get(Calendar.DAY_OF_WEEK);//����(1~7 : �Ͽ��� 1)
		
		System.out.println(y + "-" + m + "-" + d);
		System.out.println(w);
		
		String[] yoil = {"��", "��", "ȭ", "��", "��", "��", "��"};
		System.out.println(yoil[w-1] + "����");
		
		//���� ù��, ���� ���ϱ�
		int startDay = now.getActualMinimum(Calendar.DATE);//1
		int endDay = now.getActualMaximum(Calendar.DATE);//1
		
		System.out.println(startDay + ":" + endDay);
		
		System.out.printf("%tF\n",now);//2024-06-03 ��¥
		System.out.printf("%tT\n",now);//11:10:04 �ð�
		
		System.out.printf("%1$tF %1$tT\n",now);//
		
		//��¥ ������
		now.set(2025, 10-1, 21);
		
		y = now.get(Calendar.YEAR);//��
		m = now.get(Calendar.MONTH)+1;//��(0~11)
		d = now.get(Calendar.DATE);//��
		w = now.get(Calendar.DAY_OF_WEEK);//����(1~7 : �Ͽ��� 1)
		System.out.println(y + "-" + m + "-" + d);
		System.out.println(yoil[w-1] + "����");

	}

}
