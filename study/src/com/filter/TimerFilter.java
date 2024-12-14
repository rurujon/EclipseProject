package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimerFilter implements Filter{
	
	private FilterConfig config;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		long before = System.currentTimeMillis();
		//request에 시간을 재 타이머를 달고 서버로 보낸다.
		
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		
		String uri;
		
		if(request instanceof HttpServletRequest) {
			
			HttpServletRequest req=(HttpServletRequest)request;
			
			uri=req.getRequestURI();
			
			config.getServletContext().log(uri + " : " + (after-before) + "ms");
			
			//System.out.println(uri + " : " + (after-before) + "ms");
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.config = filterConfig;
	}
	
	
	
	

}
