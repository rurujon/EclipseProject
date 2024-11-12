package com.di.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResultMain {

	public static void main(String[] args) {
		
		String path = "com/di/test/applicationContext.xml";
		
		Resource res = new ClassPathResource(path);
		
		BeanFactory factory = new XmlBeanFactory(res);
		
		TestService ob = (TestService)factory.getBean("testService");
		System.out.println(ob.getValue());
		
		
		
		/* 원래의 코딩법.
		TestImpl1 ob1 = new TestImpl1();
		ob1.result();
		
		Test ob2 = new TestImpl1();
		ob2.result();
		*/
	}

}
