package com.seri;

import java.io.Serializable;

public class ScoreVO implements Serializable {
	
	private String name;
	private String birth;
	private int score;
	
	//private transient int :	데이터로는 남아있으나, 파일로는 저장되지 않도록 해줌.
	//							비밀번호와 같이, 굳이 저장할 필요가 없는 정보를 걸러낼 수 있다.
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		String str = String.format("%6s %10s %4d",name,birth,score);
		return str;
	}

}
