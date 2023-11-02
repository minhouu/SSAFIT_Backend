package com.ssafy.ssafit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 낚아채자");
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			System.out.println("실패");
			response.setHeader("blocked", "true");
			return false;
		}
		return true;
	}
}
