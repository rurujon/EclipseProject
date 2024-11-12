package com.test2;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class TestAction extends ActionSupport implements Preparable, ModelDriven<UserDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//----------- struts2의 기본 구조------------------
	private UserDTO dto;

	//request.setAttribute("dto",dto);
	//struts2가 알아서 dto에 값을 넘겨준다.
	public UserDTO getDto() {
		return dto;
	}

	//dto의 객체를 생성해주는 코딩
	@Override
	public void prepare() throws Exception {
		dto = new UserDTO();
	}

	
	@Override
	public UserDTO getModel() {
		return dto;
	}
	//--------------------------------------
	
	
	
	public String created() throws Exception{
		
		//입력창
		if(dto==null||dto.getMode()==null||dto.getMode().equals("")) {
			return INPUT;
		}
		
		//입력
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//request.setAttribute("dto", dto);
		request.setAttribute("message", "스트럿츠2..");
		
		return SUCCESS;
		
	}

}
