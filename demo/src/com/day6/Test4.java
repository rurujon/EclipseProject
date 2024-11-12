package com.day6;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		//주민번호 검사

		//jumin : 941010-2052498
		//check : 234567892345
		//(9*2)+(4*3)+....+(9*5) = 합
		//11-합%11=값
		//값%10=마지막값
		//마지막값 = 8

		Scanner sc = new Scanner(System.in);
		String jumin;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i,tot,su;

		System.out.print("주민번호[xxxxxx-xxxxxxx]?");
		jumin = sc.next();
		
		sc.close();

		if(jumin.length()!=14) {
			System.out.println("입력 오류!");
			return;
		}

		//검증
		tot=0;

		//jumin : 941010-2052498
		//index : 01234567890123
		//check : 234567892345

		for(i=0; i<12; i++) {
			if(i>=6) {// 주민번호 뒷자리
				tot += chk[i]*Integer.parseInt(jumin.substring(i+1, i+2));

			}
			else {//생년월일
				tot += chk[i] * Integer.parseInt(jumin.substring(i, i+1));
			}
		}
		su=11-tot%11;
		su = su%10;

		if(su==Integer.parseInt(jumin.substring(13))) {
			System.out.println("정확한 주민번호!");
		}
		else {
			System.out.println("부정확한 주민번호!");
		}
	}

}


/*String str = "seoul korea";
//index : 	  01234567890

System.out.println(str.substring(0, 3));//seo
System.out.println(str.substring(6, 8));//ko
System.out.println(str.substring(6));//korea
*/