package com.day18;

import java.io.OutputStream;

//System.out

public class Test2 {

	public static void main(String[] args) {
		
		try {

			OutputStream os = System.out;	//1byte ����� OutputStream���� ������ ��
			//������ Stream ���� ���.
			//OutputStream : ������ Stream, ���� �������� �� ���� �� ���� �ȴ� (InputStream)

			byte[] b = new byte[3];		//buffer ����
			b[0] = 65;
			b[1] = 97;
			b[2] = 122;

			os.write(b);	//System.out �� 1Byte���� ���� ������ �� ������ OutputStream�� ��ӵ����� �� ���� ���� ������ �� ����.
			os.close();		//System.out�� �����鼭 print�� ���� ������.
							//��������� system.out�� ����ؼ� �����ֱ� ������ ������ �� �� �ִ� ��.
			
			System.out.println("\n��� �Ϸ�");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
