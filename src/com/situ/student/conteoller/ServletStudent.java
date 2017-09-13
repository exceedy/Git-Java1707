package com.situ.student.conteoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.exception.NameReapeatException;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.StudentServiceImpl;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.SearchCondition;


public class ServletStudent extends BaseServlet {
		IStudentService studentService = new StudentServiceImpl();
	/*protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletStudent.service()");
		 //resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String servletPath = req.getServletPath();
		HttpSession session = req.getSession(false);
			if (session == null) {
				resp.sendRedirect(req.getContextPath() + "/WEB-INF/jsp/login.jsp");
				return;
			}  
		
		
		//PrintWriter printWriter  = resp.getWriter();
			*//**
			 * 访问量
			 * @throws  
			 *//*
		ServletContext servletContext = getServletContext();
		int count = (int) servletContext.getAttribute("count");
		count++;
	*/	
		/**
		 * 转发
		 * @param req
		 * @param resp
		 * @throws IOException
		 * @throws ServletException 
		 */
	private void toAddStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BanjiServlet banjiServlet = new BanjiServlet();
		List<Banji> banjiList = banjiServlet.banjiList();
		req.setAttribute("banjiList", banjiList);
		req.getRequestDispatcher("/WEB-INF/jsp/add_student.jsp").forward(req, resp);
	}
	
	private void toupdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		Student student = studentService.findById(Integer.parseInt(id));
		BanjiServlet banjiServlet = new BanjiServlet();
		List<Banji> banjiList = banjiServlet.banjiList();
		req.setAttribute("banjiList", banjiList);
		req.setAttribute("student", student);
		req.getRequestDispatcher("/WEB-INF/jsp/update_student.jsp").forward(req, resp);
	}
		/**
		 * 学生已经是否存在
		 * @param req
		 * @param resp
		 * @throws IOException 
		 */
		private void chekName(HttpServletRequest req, HttpServletResponse resp) throws IOException{
			String name = req.getParameter("name");
			System.out.println(name);
			boolean isExit = studentService.chekName(name);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("{\"isExit\":" + isExit+ "}");
		}
		/**
		 * 分页
		 * @param req
		 * @param resp
		 * @throws IOException
		 * @throws ServletException
		 */
		private void pageList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			String pageIndexStr = req.getParameter("pageIndex");
			String pageSizeStr = req.getParameter("pageSize");
			int index = 1;
			if (pageIndexStr != null && !pageIndexStr.equals("")) {
				index = Integer.parseInt(pageIndexStr);
			}
			int pageSize = 3;
			if (pageSizeStr != null && !pageSizeStr.equals("")) {
				pageSize = Integer.parseInt(pageSizeStr);
			}
			PageBean pageBean = studentService.getPageBean(index,pageSize); 
			BanjiServlet banjiServlet = new BanjiServlet();
			List<Banji> banjiList = banjiServlet.banjiList();
			req.setAttribute("banjiList", banjiList);
			req.setAttribute("pageBean", pageBean);
			req.setAttribute("method", req.getParameter("method"));
			req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
		}
		
		/**
		 * 特殊查询
		 * @param req
		 * @param resp
		 * @throws IOException
		 * @throws ServletException 
		 */
		private void specialSelect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String address = req.getParameter("address");
			String birthday = req.getParameter("birthday");
			String pageIndexStr = req.getParameter("pageIndex");
			String pageSizeStr = req.getParameter("pageSize");
			String banjiId = req.getParameter("banji");
			int pageIndex = 1;
			if (pageIndexStr != null && !pageIndexStr.equals("")) {
				pageIndex = Integer.parseInt(pageIndexStr);
			}
			int pageSize = 3;
			if (pageSizeStr != null && !pageSizeStr.equals("")) {
				pageSize = Integer.parseInt(pageSizeStr);
			}
			SearchCondition searchCondition = new SearchCondition(pageIndex, pageSize, name, age, gender, birthday, address,banjiId);
			PageBean pageBean = studentService.getPageBeanCondition(searchCondition); 
			BanjiServlet banjiServlet = new BanjiServlet();
			List<Banji> banjiList = banjiServlet.banjiList();
			req.setAttribute("banjiList", banjiList);
			req.setAttribute("pageBean", pageBean);
			req.setAttribute("method", req.getParameter("method"));
			req.setAttribute("searchCondition", searchCondition);
			/*System.out.println(1);
			for (Student student : list) {
				System.out.println(student);
			}*/
			/*System.out.println(req.getServletPath());
			System.out.println(req.getParameter("method"));*/
			req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
		}
		
	/**
	 * 修改信息
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		String date = req.getParameter("birthday");
		String banjiId = req.getParameter("banji");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = simpleDateFormat.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Student student = new Student(Integer.parseInt(id),name, Integer.parseInt(age), gender, address, birthday,Integer.parseInt(banjiId));
		
		IStudentService studentServlet = new StudentServiceImpl();
		
		studentServlet.upDate(student);
		resp.setContentType("text/html;charset=utf-8");	
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
	}


	/**
	 * 按性别查询
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void genderSelectStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();*/
		
		String gender = req.getParameter("gender");
		List<Student> list = studentService.findByGender(gender);
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		Integer index = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			index = Integer.parseInt(pageIndexStr);
		}
		Integer pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = studentService.getPageBean(index,pageSize); 
		pageBean.setList(list);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
		/*printlnStudent(printWriter, list);*/
	}


	/**
	 * 按地址查询
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void addressSelectStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();*/
		
		String address = req.getParameter("address");
		List<Student> list = studentService.findAddress(address);
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		Integer index = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			index = Integer.parseInt(pageIndexStr);
		}
		Integer pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = studentService.getPageBean(index,pageSize); 
		pageBean.setList(list);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
		/*printlnStudent(printWriter, list);*/
	}



	/**
	 * 按日期查询
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void birthdaySelectStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();*/
		String firthDate = req.getParameter("firthDate");
		String endDate = req.getParameter("endDate");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date firthBirthday = null;
		Date endBirthday = null;
		try {
			firthBirthday = simpleDateFormat.parse(firthDate);
			endBirthday = simpleDateFormat.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Student> list = studentService.findByDate(firthBirthday, endBirthday);
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		Integer index = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			index = Integer.parseInt(pageIndexStr);
		}
		Integer pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = studentService.getPageBean(index,pageSize); 
		pageBean.setList(list);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
			/*printlnStudent(printWriter, list);*/
	}


	
	/**
	 * 按年龄查询
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void ageSelectStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	/*	resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();*/
		String age = req.getParameter("age");
		List<Student> list = studentService.findByAge(Integer.parseInt(age));
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		Integer index = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			index = Integer.parseInt(pageIndexStr);
		}
		Integer pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = studentService.getPageBean(index,pageSize); 
		pageBean.setList(list);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
			/*printlnStudent(printWriter, list);*/
	}



	/**
	 * 按名字查询
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void nameSelectStduent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();*/
		
		String name = req.getParameter("name");
		List<Student> list = studentService.findByName(name);
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		Integer index = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			index = Integer.parseInt(pageIndexStr);
		}
		Integer pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = studentService.getPageBean(index,pageSize); 
		pageBean.setList(list);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
		/*printlnStudent(printWriter, list);*/
	}


	/**
	 * html表格输出
	 * @param printWriter
	 * @param list
	 *//*
	private void printlnStudent(PrintWriter printWriter, List<Student> list) {
		printWriter.println("<table border = ' 1px soild' cellspacing ='0'>");
		printWriter.println("     <tr>");
		printWriter.println("          <td>id</td>");
		printWriter.println("          <td>name</td>");
		printWriter.println("          <td>age</td>");
		printWriter.println("          <td>gender</td>");
		printWriter.println("          <td>address</td>");
		printWriter.println("          <td>birthday</td>");
		printWriter.println("      </tr>");
		
		for (Student student : list) {
			printWriter.println("   <tr>");
			printWriter.println("   <td>" + student.getId() + "</td>");
			printWriter.println("   <td>" + student.getName() + "</td>");
			printWriter.println("   <td>" + student.getAge() + "</td>");
			printWriter.println("   <td>" + student.getGender() + "</td>");
			printWriter.println("   <td>" + student.getAddress() + "</td>");
			printWriter.println("   <td>" + student.getBirthday() + "</td>");
			printWriter.println("   <td> <a href = '/java1707web/deleteStudent.do?id="+ student.getId()+"' name = 'getId'>删除</a></td>");
			
			printWriter.println("   </tr>");
		}
			printWriter.println("</table>");
			printWriter.close();
	}*/


	/**
	 * 删除学生
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		/*PrintWriter printWriter = resp.getWriter();*/
		String id = req.getParameter("id");
		studentService.deleteById(Integer.parseInt(id));
		resp.sendRedirect("/java1707web/student?method=pageList");
		/*printWriter.println("删除成功");
		printWriter.println("<a href = '/java1707web/findAllStudent.do'>返回</a>");*/
	}
	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		/*PrintWriter printWriter = resp.getWriter();*/
		/*String id = req.getParameter("id");*/
		String[] ids = req.getParameterValues("selectIds");
		studentService.deleteById(ids);
		/*studentService.deleteById(Integer.parseInt(id));*/
		resp.sendRedirect("/java1707web/student?method=pageList");
		/*printWriter.println("删除成功");
		printWriter.println("<a href = '/java1707web/findAllStudent.do'>返回</a>");*/
	}
	
	
	
	/**
	 * 查询所有
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	/*private void findAllStudent(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		StudentServiceImpl studentServlet = new StudentServiceImpl();
		List<Student> list = studentServlet.findAll();
		HttpSession session =  req.getSession(false);
		if (session != null) {
			String urname = (String) session.getAttribute("urname");
			PageBean pageBean = new PageBean();
			pageBean.setList(list);
			req.setAttribute("pageBean", pageBean);
			req.setAttribute("name", urname);
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/findall_student.jsp").forward(req, resp);
		
		    for (Student student : list) {
				
		    	System.out.println("name" + student.getName());
		    	
			}
		    resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("欢迎回来" + urname + "");
		printWriter.println("<a href='/java1707web/html/add_stduent.html' color = 'black'>添加</a>");
		printWriter.println("<a href='/java1707web/html/select_Student.html' color = 'black'>查询</a>");
		printWriter.println("<a href='/java1707web/html/updateStudent.html' color = 'black'>修改</a>");
		
		printlnStudent(printWriter, list);
	}*/

	/**
	 * 添加学生
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		String date = req.getParameter("birthday");
		String banji_id = req.getParameter("banji");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = simpleDateFormat.parse(date);
		} catch (ParseException e1) {
 			e1.printStackTrace();
		}
		Student student = new Student(name, Integer.parseInt(age), gender, address, birthday,Integer.parseInt(banji_id));
		
		IStudentService studentServlet = new StudentServiceImpl();
			try {
				 studentServlet.add(student);
			} catch (NameReapeatException e) {
				e.printStackTrace();
			}
			
			resp.setContentType("text/html;charset='utf-8'");
			resp.sendRedirect( req.getContextPath() + "/student?method=pageList");
	}
}
