package com.naver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Myauthen{
	public void inputForm(String str) throws Exception{
		
		if(str.length()<8||str.length()>15) {
			throw new Exception("���̵�� 8~15�� �̳��Դϴ�.");
		}
		
		int eng = 0;
		int num = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) {
				eng++;
			}
			else if(ch>='0'&&ch<='9') {
				num++;
			}
		}
		
		if(eng==0||num==0) {
			
			throw new Exception("������ ������ ȥ���� �����ּ���.");
		}
		if(eng+num != str.length()) {
			throw new Exception("������ ���� �̿��� ���ڴ� �Է��� �� �����ϴ�.");
		}
	}
}

class Myauthen2{
	public void inputForm(int num, int checkNum) throws Exception{
		if(num!=checkNum) {
			throw new Exception("��й�ȣ�� ���� �ٸ��ϴ�.");
		}
	}
}



public class NaverImpl implements Naver{
	
	Scanner sc = new Scanner(System.in);
	List<NaverVO> lists = new ArrayList<NaverVO>();
	

	@Override
	public void input() {
		
		String str;
		int num;
		int checkNum;
		Myauthen auth = new Myauthen();
		Myauthen2 auth2 = new Myauthen2();
		NaverVO vo = new NaverVO();
		
		System.out.println("ID");
		str = sc.next();
		
		try {
			auth.inputForm(str);
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
			// TODO: handle exception
		}
		vo.setId(str);
		System.out.println("PassWord");
		num = sc.nextInt();
		System.out.println("PassWord Check");
		checkNum = sc.nextInt();
		
		try {
			auth2.inputForm(num, checkNum);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
			// TODO: handle exception
		}
		
		vo.setPassword(num);
		System.out.println("Name");
		vo.setName(sc.next());
		System.out.println("Gender(��,��)");
		vo.setGender(sc.next());
		System.out.println("Birth");
		vo.setBirth(sc.nextInt());
		System.out.println("Email");
		vo.setEmail(sc.next());
		System.out.println("Tel");
		vo.setTel(sc.nextInt());
		
		lists.add(vo);
	}

	@Override
	public void print() {
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next(); 
			System.out.println(vo);
		}
	}

	@Override
	public void searchId() {
		
		System.out.println("�̸�?");
		String searchName = sc.next();
		System.out.println("�������?");
		Integer searchBirth = sc.nextInt();
		System.out.println("�̸���?");
		String searchEmail = sc.next();
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getName().equals(searchName)&&vo.getBirth()==searchBirth
					&&vo.getEmail().equals(searchEmail)) {
				System.out.println(vo.getId());
			}
			else {
				System.out.println("����� ã�� �� �����ϴ�.");
			}
		}
		
	}

	@Override
	public void searchPassword() {

		System.out.println("���̵�?");
		String searchId = sc.next();
		System.out.println("�̸�?");
		String searchName = sc.next();
		System.out.println("�������?");
		Integer searchBirth = sc.nextInt();

		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getId().equals(searchId)&&vo.getName().equals(searchName)
					&&vo.getBirth()==searchBirth) {
				System.out.println(vo.getPassword());
			}
			else {
				System.out.println("����� ã�� �� �����ϴ�.");
			}

		}
	}

	@Override
	public void delete() {
		
		System.out.println("������ ���̵�?");
		String searchId = sc.next();
		System.out.println("��й�ȣ?");
		Integer searchPassword = sc.nextInt();
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getId().equals(searchId)&&vo.getPassword()==searchPassword) {
				lists.remove(vo);
				
			}
			else {
				System.out.println("����� ã�� �� �����ϴ�.");
				return;
			}
			System.out.println("�����Ǿ����ϴ�.");
			
		}
		
	}

	@Override
	public void change() {
		
		System.out.println("������ ���̵�?");
		String searchId = sc.next();
		System.out.println("��й�ȣ?");
		Integer searchPassword = sc.nextInt();
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getId().equals(searchId)&&vo.getPassword()==searchPassword) {
				System.out.println("������ ����? 1.����, 2.��й�ȣ, 3.�̸�,"
						+ " 4.����, 5.�������, 6.�̸���, 7.��ȭ��ȣ, 8.���");
				int choose = sc.nextInt();
				switch (choose) {
				case 1 : 
					lists.remove(vo);
					System.out.println("������ ����� �����Ǿ����ϴ�. ���� �Է����ּ���.");
					input();
					break;
				case 2 : 
					System.out.println("�� ��й�ȣ?");
					int newPass = sc.nextInt();
					vo.setPassword(newPass);
					break;
				case 3 :
					System.out.println("�� �̸�?");
					String newName = sc.next();
					vo.setName(newName);
					break;
				case 4 :
					System.out.println("�� ����?");
					String newGender = sc.next();
					vo.setGender(newGender);
					break;
				case 5 :
					System.out.println("�� �������?");
					int newBirth = sc.nextInt();
					vo.setBirth(newBirth);
					break;
				case 6 :
					System.out.println("�� �̸���?");
					String newEmail = sc.next();
					vo.setEmail(newEmail);
					break;
				case 7 :
					System.out.println("�� ��ȭ��ȣ?");
					int newTel = sc.nextInt();
					vo.setTel(newTel);
					break;
				default:
					System.out.println("����մϴ�.");
				}
			}
			else {
				System.out.println("����� ã�� �� �����ϴ�.");
				return;
			}
			
			
		}
	}

}
