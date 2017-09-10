package com.situ.student.conteoller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();
		if ("GET".equals(method)) {
			EncodingRequest encodingRequest = new EncodingRequest(req);
			chain.doFilter(encodingRequest, response);
		} else {
			req.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
		
	}
	
		class EncodingRequest extends HttpServletRequestWrapper {
			private HttpServletRequest request;

			public EncodingRequest(HttpServletRequest request) {
				super(request);
				this.request = request;
			}
			
			public String getParameter(String name) {
				String parameter = request.getParameter(name);
				if (parameter != null && !parameter.equals("")) {
					try {
						parameter = new String(parameter.getBytes("iso8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return parameter;
			}
		}
}
