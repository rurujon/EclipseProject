package com.score2;

public class ScoreVO {//Value Object
						//DTO : Data Transfer Object : 데이터를 전달해주는 오브젝트
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	
	//변수는 private로 설정하고 getter setter을 반드시 만든다. 프로그래머의 약속.
	
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
	public int getTot() {
		return kor+eng+mat;
	}
	@Override
	public String toString() {
		String str = String.format("%s %s %4d %4d %4d %4d %4d\n", hak,name,kor,eng,mat,getTot(),getTot()/3);
		return str;
	}
}
	
	
	//public ScoreVO() {}
	
	/*public ScoreVO(String hak, String name, int kor, int eng, int mat) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}//생성자를 가지고 초기화를 할 때는 보통 인수를 많이 쓰지 않는다.(대부분 하나, 간혹 둘)*/
	
	
	//보통 데이터를 입력할 때는 set을 많이 쓴다.
	/*public void set(String hak, String name, int kor, int eng, int mat) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}
	*/
	/*
	//Getter, Setter
	
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getHak() {
		return hak;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	
	public void setEng(int Eng) {
		this.eng = Eng;
	}
	public int getEng() {
		return eng;
	}
	
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getMat() {
		return mat;
	}*/


