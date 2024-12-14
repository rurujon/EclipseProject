package com.day20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//java.util.regex
//����ȭ ǥ����
//�뵵 : �ܾ� �ٲٱ�, ���� �ּ� �˻�, ���Ͽ��� ���� ����, �˻�, etc...

public class Test4 {

	public static void main(String[] args) {
		
		String[] str = {"bat","baby","bonus","c","cA","ca","c.","c0","car","combat","count","data","disc"};
		
		Pattern p;
		
		p=Pattern.compile("c[a-z]*");
		
		for(String s : str) {
			
			Matcher m = p.matcher(s);
			if(m.matches()) {
				System.out.println(s);
			}
		}
		
		System.out.println("----------------------------");
		
		p=Pattern.compile("c[a-z]+");
		
		for(String s : str) {
			
			Matcher m = p.matcher(s);
			if(m.matches()) {
				System.out.println(s);
			}
		}
		
		System.out.println("----------------------------");
		
		String[] mail = {"aaaa@aaa.com","aaa.co.kr", ".@bbb.com","aaa@bbb.co.kr","sss.co.kr","abc@def"};
		
		//[\\w]+ : �� ���� �̻��� ��,����
		//@ : at
		//(\\.[\\w]+) : ��ȣ �ȿ� �ִ� ���� �ݵ�� �� ���� ����ؾ� �Ѵ�.
		//\\. : dot
		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for(String s : mail) {
			if(Pattern.matches(pat, s)) {
				System.out.println(s);
			}
		}
	}

}


/*
c[a-z]* : c �� �����ϴ� ����ܾ� (c,ca,caaa)
c[a-z] : c �� �����ϴ� �α����� ����ܾ�(ca, cb)
c[a-zA-Z0-9] :ca, cA, c4
c. : c�� �����ϴ� �α���(ca, cB, c&)
c.* : c �� �����ϴ� ��繮��
c.*t : ct, chhhhhht, c7777777t
[b|c].* �Ǵ� [bc].* �Ǵ� [b-c].* : b, c, bbb
[^b|c].* �Ǵ� [^bc].* �Ǵ� [^b-c].* : b �Ǵ� c �� �������� �ʴ�
.*c.* : c�����Ե� ��� ���ڿ�
*/