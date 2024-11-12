package com.test;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		String message = "";
		
		if(hour>=6 && hour<8) {
			message = "일어나세요 용사여.";
		}else if (hour>=8 && hour<13) {
			message = "지각입니다.";
			
		}else if(hour>=14 && hour<18) {
			message = "오후입니다.";
		}else {
			message = "저녁입니다.";
		}
		
		request.setAttribute("message", message);
		
		return new ModelAndView("test/view");
		
		
	}
	
	

}
