package com.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController{
	
	private Authenticator authenticator;
	
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {	//onSubmit : submit을 하면 무조건 실행되는 메서드
		
		
		LoginCommand login = (LoginCommand)command;
		
		try {
			
			authenticator.authen(login.getUserId(), login.getUserPwd());
			
			String message = "id: " + login.getUserId();
			message += ", pwd : " + login.getUserPwd();
			message +=", type : " + login.getLoginType();
			
			request.setAttribute("message", message);
			
			return new ModelAndView("test1/login_ok");
			
			
			
		} catch (Exception e) {
			
			return showForm(request, response, errors);
			// TODO: handle exception
		}
	}	
		
		

	@Override
	protected Map<String, List<String>> referenceData(HttpServletRequest request) throws Exception {
		
		List<String> loginTypes = new ArrayList<String>();
		
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("특별회원");
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("loginTypes", loginTypes);
		
		
		
		return map;
	}
	
	

}
