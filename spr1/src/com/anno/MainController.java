package com.anno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//dispatcher servlet의
//<bean name="mainController" class="com.anno.MainController">
//의 작업을 자동으로 해주고
//첫글자를 소문자로 해서 mainComtroller라는 이름으로 자동으로 저장해준다.

@Controller
@RequestMapping(value = "/main.action")
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String method() {
		
		return "/main";
		
	}

}
