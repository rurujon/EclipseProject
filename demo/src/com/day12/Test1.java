package com.day12;

//wrapper Ŭ����
//�ڷ����� ����
//boolean, byte, char, short, int, long, float, double
//���� �ڷ����� �Ȱ��� ������ Ŭ����
//���۷��� �ڷ���
//Boolean, Byte, Character, Short, Integer, Long, Float, Double

//Auto-Boxing : stack ��> heap
//Auto-unboxing : heap ��> stack
//���� ������ ���� ���̿����� ������.

public class Test1 {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2;
		
		Integer num1;
		Integer num2 = new Integer(20);
		
		//Auto-Boxing
		num1 = n1;
		//Auto-Unboxing
		n2 = num2;
		
		System.out.println(n1 + ":" + num1);
		System.out.println(n2 + ":" + num2);

	}

}

/* ����ȯ(casting)

int a = 10;
float b;

b=a;  O : �Ͻ��� ����ȯ(���� ��ȯ���� �ʾƵ� ���� �� ū �� �ȿ� �� ����)
b=(float)a;  O : ����� ����ȯ(�ڷ��� ��ȯ�ϸ� �翬�� ����.)

a=b;  X : �Ͻ��� ����ȯ �Ұ���
a=(int)b  O : ����� ����ȯ

-----------------------

���
�θ�(b) - �ڽ�(a)

�θ�(b) = �ڽ�(a) UPCAST(0) : �ڽ��� �θ�ȭ ��Ű�� �۾�
�θ�(b) = (�θ�)�ڽ�(a) UPCAST(0)

�ڽ�(a) = �θ�(b)  (X)
�ڽ�(a) = (�ڽ�)�θ�(b) DOWNCAST(0) 

*/