package com.ssafy.ssafit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ssafit.JwtUtil;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}
		
//		System.out.println(request.getHeader(HEADER_AUTH));
		String token = request.getHeader(HEADER_AUTH);
		if (token != null) {
			jwtUtil.isValid(token);
			return true;
		}
		throw new Exception("Access Token has problem");
	}
}
