package com.situ.student.conteoller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.situ.student.pojo.Admin;

public class ServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/*Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				System.out.println("银行计息");
			}
			
		};*/
		/*timer.scheduleAtFixedRate(task, date, 5000);*/
		List<Admin> onLineAdminList = new ArrayList<Admin>();
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("onLineAdminList", onLineAdminList);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
