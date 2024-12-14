package com.event;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//서블릿의 라이프 사이클
//HTTPSessionListener : 세션이 생성, 종료될 때를 감시해 실행
//ServletContextListener : 서버가 시작, 종료될 때를 감시해 실행

//Listener : 감시자. 가만히 있다가 어떤 작업을 수행했을 때 작동하는 것
//Context : 전체


public class CountManager implements HttpSessionListener{
	
	private static CountManager countManager;
	
	private static int count;
	
	public CountManager() {
		countManager = this;
	}
	
	//동기화 : 이 작업을 수행할 때까지 다른 건 들어갈 수 없다.
	public static synchronized CountManager getInstance() throws Exception{
		
		if(countManager==null) {
			countManager = new CountManager();
		}
		
		return countManager;
		
	}
	
	public static int getCount() {
		
		return count;
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		
		HttpSession session = evt.getSession();
		session.setMaxInactiveInterval(3*60);
		
		count++;
		
		System.out.print(session.getId() + " : 세션 생성, ");
		System.out.println("접속자 수 : " + count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		
		HttpSession session = evt.getSession();
		
		count--;
		
		System.out.print(session.getId() + " : 세션 소멸, ");
		System.out.println("접속자 수 : " + count);
	}
	
	

}
