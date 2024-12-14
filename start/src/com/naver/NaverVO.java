package com.naver;

public class NaverVO {
	
	private String id;
	private int password;
	private String name;
	private String gender;
	private int birth;
	private String email;
	private int tel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		
		String str;
		
		str = String.format("%s %s %s %d %s %d", id, name, gender, birth, email, tel);
		return str;
	}

}
