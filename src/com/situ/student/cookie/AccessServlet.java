package com.situ.student.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss/");
		String time = simpleDateFormat.format(date);
		Cookie cookie = new Cookie("lastAccessTime",time);
		cookie.setMaxAge(3*60);
		resp.addCookie(cookie);
		Cookie[] cookies = req.getCookies();
		String lastTime = null;
		if (cookies != null) {
			
			for (Cookie cook : cookies) {
				if ("lastAccessTime".equals(cook.getName())) {
					lastTime = cook.getValue();
				}
			}
		}
		resp.setContentType("text/hetml;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		if (lastTime == null) {
			printWriter.println("<p>欢迎您第一次访问</p>");
		} else {
			printWriter.println("<p>您上一次访问的时间是" + lastTime + "</p>");
		}
	}
}
