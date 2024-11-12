package com.day20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//java.util.regex
//정규화 표현식
//용도 : 단어 바꾸기, 메일 주소 검색, 파일에서 문자 제거, 검색, etc...

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
		
		//[\\w]+ : 한 글자 이상의 영,숫자
		//@ : at
		//(\\.[\\w]+) : 괄호 안에 있는 것은 반드시 한 번은 사용해야 한다.
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
c[a-z]* : c 로 시작하는 영어단어 (c,ca,caaa)
c[a-z] : c 로 시작하는 두글자의 영어단어(ca, cb)
c[a-zA-Z0-9] :ca, cA, c4
c. : c로 시작하는 두글자(ca, cB, c&)
c.* : c 로 시작하는 모든문자
c.*t : ct, chhhhhht, c7777777t
[b|c].* 또는 [bc].* 또는 [b-c].* : b, c, bbb
[^b|c].* 또는 [^bc].* 또는 [^b-c].* : b 또는 c 로 시작하지 않는
.*c.* : c가포함된 모든 문자열
*/