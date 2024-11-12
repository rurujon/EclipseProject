package com.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

public class MemController extends AbstractWizardFormController{
	
	public MemController() {
		// TODO Auto-generated constructor stub
		setCommandClass(MemCommand.class);
		setCommandName("info");
		//MemCommand info = new MemCommand();
	}
	
	

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		//최종 처리 요청을 처리(데이터 입력이 정상처리되었을 때 작업)
		
		
		return new ModelAndView("test2/mem_ok");
	}

	@Override
	protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page)
			throws Exception {
		
		
		MemCommand mem = (MemCommand)command;
		
		if(page==0) {
			
			if(mem.getJumin().equals("1234")) {
				
				String str = mem.getName() + "님 이미 가입되어 있습니다.";
				
				
				//error 객체가 에러를 저장하고 있으면 다시 입력을 요구\
				//다음 페이지로 넘어가지 못함
				errors.rejectValue("message", str);	//에러 코드 저장
			
			
				mem.setMessage(str);
			
			}
			
			
		}else if(page==1) {
			
			
		}
		
		
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		return new ModelAndView("test2/mem_cancel",errors.getModel());
		
	}

	@Override
	protected Map<String, List<String>> referenceData(HttpServletRequest request, Object command, Errors errors, int page) throws Exception {
		
		//특정 페이지로 넘어갈 때 준비작업
		
		if(page==1) {
			
			List<String> types = new ArrayList<String>();
			
			types.add("일반회원");
			types.add("기업회원");
			types.add("특별회원");
			
			
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			
			map.put("types", types);
			
			return map;
			
		}
		
		
		return null;
	}
	
	

}
