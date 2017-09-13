<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
				<a href="<%= request.getContextPath()%>/jsp/findbyname_student.jsp">按姓名查询</a>
				<a href="<%= request.getContextPath()%>/jsp/findbyage_student.jsp">按年龄查询</a>
				<a href="<%= request.getContextPath()%>/jsp/findbybirthday_student.jsp">按生日查询</a>
				<a href="<%= request.getContextPath()%>/jsp/findbyaddress_student.jsp">按地址查询</a>
				<a href="<%= request.getContextPath()%>/jsp/findbygender_student.jsp">按性别查询</a>
				<a href="<%= request.getContextPath()%>/findAllStudent.do">返回</a>
</body>
</html>