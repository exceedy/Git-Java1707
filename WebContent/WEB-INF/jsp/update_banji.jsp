<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/css/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
		

</script>
<title>Insert title here</title>
</head>
<body>
		
		<%@include file="common/logn.jsp" %>
	<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/banji?method=pageList" class="list-group-item active">班级管理</a>
		                <a href="${pageContext.request.contextPath}/banji?method=toAddbanji" class="list-group-item ">添加班级</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/banji?method=pageList">班级列表</a>
		                </li>
		                <li  >
		                	<a href="${pageContext.request.contextPath}/banji?method=toAddbanji">添加班级</a>
		                </li>
		            </ul>
		
				<form action="<%=request.getContextPath()%>/banji?method=updatebanji" method="post">
				<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">id</span>
  						<input type="text"  name="id" class="form-control" readonly value="${banji.id}" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">姓名</span>
  						<input type="text"  name="name" class="form-control"  value="${banji.name}" aria-describedby="sizing-addon3">
					</div>
					<input class="btn btn-primary" type="submit" value="修改">
				</form>
			</div>
		</div>
	</div>

</body>
</html>