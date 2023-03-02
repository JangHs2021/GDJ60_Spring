package com.iu.home.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.home.member.MemberDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	// Role이 Admin이면 통과
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(memberDTO != null){
			if(memberDTO.getRoleDTO().getRoleName().equals("ADMIN")) {
				return true;
			}
		}
		
		request.setAttribute("result", "권한이 없다");
		request.setAttribute("url", "../");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		return false;
	}
}
