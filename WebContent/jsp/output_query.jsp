<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.situ.student.pojo.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
			<%
				List<Student> list = (List<Student>)request.getAttribute("list");
			%>
			<h4>欢迎回来<%=session.getAttribute("name")%></h4>
				<table>
				<tr>
					<td>id</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>地址</td>
					<td>出生日期</td>
					<td>修改</td>
					<td>删除</td>
					<td><a href="<%=request.getContextPath()%>/jsp/find_student.jsp">返回</a></td>
					<td><a href="<%=request.getContextPath()%>/jsp/add_student.jsp">添加</a></td>
				</tr>
				<%	for (Student student : list) {
				%>	
					<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getGender()%></td>
					<td><%=student.getAge()%></td>
					<td><%=student.getAddress()%></td>
					<td><%=student.getBirthday()%></td>
					<td><a href="<%=request.getContextPath()%>/jsp/update_student.jsp?id=<%=student.getId() %>">修改</a></td>
					<td><a href="<%=request.getContextPath()%>/deleteStudent.do?id=<%=student.getId() %>">删除</a></td>
					<td></td>
				</tr>
			<%
			}
			%>
				</table>
</body>
</html>