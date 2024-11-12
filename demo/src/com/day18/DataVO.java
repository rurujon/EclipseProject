package com.day18;

import java.io.Serializable;

public class DataVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int score;
	
	public DataVO(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return name + ":" + score;
	}
	
	

}
