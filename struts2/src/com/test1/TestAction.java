package com.test1;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private UserDTO userDTO;
	private String message;
	
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public String getMessage() {
		return message;
	}
	
	public String execute() throws Exception{
		
		
		message = userDTO.getUserName() + "방가방가..";
		
		return "ok";
	}

}
