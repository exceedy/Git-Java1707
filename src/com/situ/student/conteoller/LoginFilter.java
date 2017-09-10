package com.situ.student.conteoller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf('/') + 1, uri.length());
		//String path = req.getServletPath();
		if ("/jsp/login.jsp".equals(path) || "/login".equals(path)) {
			chain.doFilter(request, response);
			return;
		}
		if ("login.jsp".equals(path) || "login".equals(path) 
				|| "addAdmin".equals(path) || "chekImg".equals(path)) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession(false);
			if (session == null) {
				resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			} else {
		chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
