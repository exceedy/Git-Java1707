<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.situ.student.service.IStudentService" %>
    <%@ page import="com.situ.student.service.StudentServiceImpl" %>
    <%@ page import="com.situ.student.pojo.Student" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/css/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
		$(function(){
			$("#banji option[value='${student.banji.id}']").prop("selected",true);
		});

</script>
<title>Insert title here</title>
</head>
<body>
		
		<%@include file="common/logn.jsp" %>
	<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/student/pageList.action" class="list-group-item active">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student/toAddStudent.action" class="list-group-item ">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/student/pageList.action">学生列表</a>
		                </li>
		                <li  >
		                	<a href="${pageContext.request.contextPath}/student/toAddStudent.action">添加学生</a>
		                </li>
		            </ul>
		
				<form action="<%=request.getContextPath()%>/student/updateStudent.action" method="post">
				<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">id</span>
  						<input type="text"  name="id" class="form-control" readonly value="${student.id}" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">姓名</span>
  						<input type="text"  name="name" class="form-control"  value="${student.name}" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">性别</span>
  						<input type="text"  name="gender" class="form-control"  value="${student.gender}" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">年龄</span>
  						<input type="text"  name="age" class="form-control"  value="${student.age}" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">地址</span>
  						<input type="text"  name="address" class="form-control"  value="${student.address}" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">生日</span>
  						<input type="text"  name="birthday" class="form-control"  value="${student.birthday}" aria-describedby="sizing-addon3">
					</div>
				 <span class="input-group-addon" id="sizing-addon3">班级</span>
  						<select id="banji"  name="banji" class="form-control" placeholder="班级" aria-describedby="sizing-addon3">
								<option value="">无</option>
							<c:forEach items="${banjiList}" var="banji">
								<option value="${banji.id}">${banji.name}</option>
							</c:forEach>	
						</select>
					<input class="btn btn-primary" type="submit" value="修改">
				</form>
			</div>
		</div>
	</div>

</body>
</html>