package com.excep;

//���� �޼���

public class OperatorMethod {
	
	public void inputForm(String str) throws MyException {
		
		//20,30
		String temp[] = str.split(",");
		
		if(temp.length!=2) {
			throw new MyException("���� �Է� ���� ����" + str);
		}
		
		
	}
	
	@SuppressWarnings("unused")		//������� �ʴ� ������ ���ǥ��(�����) ���� ����.
	public void number(String str) throws MyException{
		try {
			
			if(str.indexOf(".")!=-1) {//�Ǽ��ΰ�.
				double num = Double.parseDouble(str);
			}
			else {
				int num = Integer.parseInt(str);
			}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new MyException("���� ��ȯ �Ұ�" + str);
		}
	}
	
	//������ Ȯ��.
	public void operator(char oper) throws MyException{
		
		switch(oper) {
		case '+' : 
		case '-' : 
		case '*' : 
		case '/' : return;
		default : 
			throw new MyException("������ ���� " + oper);
		}
	}

}
