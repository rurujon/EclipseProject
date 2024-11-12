package com.excep;

//검증 메서드

public class OperatorMethod {
	
	public void inputForm(String str) throws MyException {
		
		//20,30
		String temp[] = str.split(",");
		
		if(temp.length!=2) {
			throw new MyException("숫자 입력 형식 오류" + str);
		}
		
		
	}
	
	@SuppressWarnings("unused")		//사용하지 않는 변수에 경고표시(노란줄) 쓰지 마라.
	public void number(String str) throws MyException{
		try {
			
			if(str.indexOf(".")!=-1) {//실수인가.
				double num = Double.parseDouble(str);
			}
			else {
				int num = Integer.parseInt(str);
			}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new MyException("숫자 변환 불가" + str);
		}
	}
	
	//연산자 확인.
	public void operator(char oper) throws MyException{
		
		switch(oper) {
		case '+' : 
		case '-' : 
		case '*' : 
		case '/' : return;
		default : 
			throw new MyException("연산자 오류 " + oper);
		}
	}

}
