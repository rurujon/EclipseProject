package com.day18;

import java.io.OutputStream;

//System.out

public class Test2 {

	public static void main(String[] args) {
		
		try {

			OutputStream os = System.out;	//1byte 출력을 OutputStream으로 감싸준 것
			//일종의 Stream 계의 상속.
			//OutputStream : 보급형 Stream, 딱히 생각나는 것 없을 때 쓰면 된다 (InputStream)

			byte[] b = new byte[3];		//buffer 형태
			b[0] = 65;
			b[1] = 97;
			b[2] = 122;

			os.write(b);	//System.out 은 1Byte씩의 값만 내보낼 수 있지만 OutputStream에 상속됨으로 한 번에 전부 내보낼 수 있음.
			os.close();		//System.out을 닫으면서 print도 같이 닫힌다.
							//명시적으로 system.out은 계속해서 열려있기 때문에 언제든 쓸 수 있던 것.
			
			System.out.println("\n출력 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
