package com.day6;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		//�ֹι�ȣ �˻�

		//jumin : 941010-2052498
		//check : 234567892345
		//(9*2)+(4*3)+....+(9*5) = ��
		//11-��%11=��
		//��%10=��������
		//�������� = 8

		Scanner sc = new Scanner(System.in);
		String jumin;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i,tot,su;

		System.out.print("�ֹι�ȣ[xxxxxx-xxxxxxx]?");
		jumin = sc.next();
		
		sc.close();

		if(jumin.length()!=14) {
			System.out.println("�Է� ����!");
			return;
		}

		//����
		tot=0;

		//jumin : 941010-2052498
		//index : 01234567890123
		//check : 234567892345

		for(i=0; i<12; i++) {
			if(i>=6) {// �ֹι�ȣ ���ڸ�
				tot += chk[i]*Integer.parseInt(jumin.substring(i+1, i+2));

			}
			else {//�������
				tot += chk[i] * Integer.parseInt(jumin.substring(i, i+1));
			}
		}
		su=11-tot%11;
		su = su%10;

		if(su==Integer.parseInt(jumin.substring(13))) {
			System.out.println("��Ȯ�� �ֹι�ȣ!");
		}
		else {
			System.out.println("����Ȯ�� �ֹι�ȣ!");
		}
	}

}


/*String str = "seoul korea";
//index : 	  01234567890

System.out.println(str.substring(0, 3));//seo
System.out.println(str.substring(6, 8));//ko
System.out.println(str.substring(6));//korea
*/