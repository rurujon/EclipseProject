package com.seri;

import java.io.Serializable;

public class ScoreVO implements Serializable {
	
	private String name;
	private String birth;
	private int score;
	
	//private transient int :	�����ͷδ� ����������, ���Ϸδ� ������� �ʵ��� ����.
	//							��й�ȣ�� ����, ���� ������ �ʿ䰡 ���� ������ �ɷ��� �� �ִ�.
	
	
	
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
