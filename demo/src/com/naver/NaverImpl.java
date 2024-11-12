package com.naver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Myauthen{
	public void inputForm(String str) throws Exception{
		
		if(str.length()<8||str.length()>15) {
			throw new Exception("아이디는 8~15자 이내입니다.");
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
			
			throw new Exception("영문과 숫자의 혼용을 적어주세요.");
		}
		if(eng+num != str.length()) {
			throw new Exception("영문과 숫자 이외의 문자는 입력할 수 없습니다.");
		}
	}
}

class Myauthen2{
	public void inputForm(int num, int checkNum) throws Exception{
		if(num!=checkNum) {
			throw new Exception("비밀번호가 서로 다릅니다.");
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
		System.out.println("Gender(남,여)");
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
		
		System.out.println("이름?");
		String searchName = sc.next();
		System.out.println("생년월일?");
		Integer searchBirth = sc.nextInt();
		System.out.println("이메일?");
		String searchEmail = sc.next();
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getName().equals(searchName)&&vo.getBirth()==searchBirth
					&&vo.getEmail().equals(searchEmail)) {
				System.out.println(vo.getId());
			}
			else {
				System.out.println("기록을 찾을 수 없습니다.");
			}
		}
		
	}

	@Override
	public void searchPassword() {

		System.out.println("아이디?");
		String searchId = sc.next();
		System.out.println("이름?");
		String searchName = sc.next();
		System.out.println("생년월일?");
		Integer searchBirth = sc.nextInt();

		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getId().equals(searchId)&&vo.getName().equals(searchName)
					&&vo.getBirth()==searchBirth) {
				System.out.println(vo.getPassword());
			}
			else {
				System.out.println("기록을 찾을 수 없습니다.");
			}

		}
	}

	@Override
	public void delete() {
		
		System.out.println("삭제할 아이디?");
		String searchId = sc.next();
		System.out.println("비밀번호?");
		Integer searchPassword = sc.nextInt();
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getId().equals(searchId)&&vo.getPassword()==searchPassword) {
				lists.remove(vo);
				
			}
			else {
				System.out.println("기록을 찾을 수 없습니다.");
				return;
			}
			System.out.println("삭제되었습니다.");
			
		}
		
	}

	@Override
	public void change() {
		
		System.out.println("수정할 아이디?");
		String searchId = sc.next();
		System.out.println("비밀번호?");
		Integer searchPassword = sc.nextInt();
		
		Iterator<NaverVO> it = lists.iterator();
		while(it.hasNext()) {
			NaverVO vo = it.next();
			if(vo.getId().equals(searchId)&&vo.getPassword()==searchPassword) {
				System.out.println("수정할 정보? 1.전부, 2.비밀번호, 3.이름,"
						+ " 4.성별, 5.생년월일, 6.이메일, 7.전화번호, 8.취소");
				int choose = sc.nextInt();
				switch (choose) {
				case 1 : 
					lists.remove(vo);
					System.out.println("기존의 기록이 삭제되었습니다. 새로 입력해주세요.");
					input();
					break;
				case 2 : 
					System.out.println("새 비밀번호?");
					int newPass = sc.nextInt();
					vo.setPassword(newPass);
					break;
				case 3 :
					System.out.println("새 이름?");
					String newName = sc.next();
					vo.setName(newName);
					break;
				case 4 :
					System.out.println("새 성별?");
					String newGender = sc.next();
					vo.setGender(newGender);
					break;
				case 5 :
					System.out.println("새 생년월일?");
					int newBirth = sc.nextInt();
					vo.setBirth(newBirth);
					break;
				case 6 :
					System.out.println("새 이메일?");
					String newEmail = sc.next();
					vo.setEmail(newEmail);
					break;
				case 7 :
					System.out.println("새 전화번호?");
					int newTel = sc.nextInt();
					vo.setTel(newTel);
					break;
				default:
					System.out.println("취소합니다.");
				}
			}
			else {
				System.out.println("기록을 찾을 수 없습니다.");
				return;
			}
			
			
		}
	}

}
