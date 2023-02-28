package com.iu.home.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Controller 진입전
		// return이 true라면 다음 Controller로 진행
		// return이 false라면 다음 Controller로 진행 X
		System.out.println("Controller 진입 전 체크");
		
		// 로그인 된 사람은 true 안된사람 form으로 이동
		
		
		
		response.sendRedirect("");
		
		return true;
	}
}
