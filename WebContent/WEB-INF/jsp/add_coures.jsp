<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/css/js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/css/lib/bootstrap/js/bootstrap.min.js" ></script>
<script type="text/javascript">
		
</script>
<style type="text/css">
	.from_b{
		border: 1px solid #555; 
		padding: 10px;
		border-top:none;
	}

</style>
</head>

<body>
	<%@include file="common/logn.jsp" %>
	<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/coures?method=pageList" class="list-group-item ">学生管理</a>
		                <a href="${pageContext.request.contextPath}/coures?method=toAddcoures" class="list-group-item active">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li >
		                    <a href="${pageContext.request.contextPath}/coures?method=pageList">课程列表</a>
		                </li>
		                <li class="active" >
		                	<a href="${pageContext.request.contextPath}/coures?method=toAddcoures">添加课程</a>
		                </li>
		            </ul>
	
				<form class="form_b" action="<%= request.getContextPath()%>/coures?method=addcoures" method="post"> 
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">课程名称</span>
  						<input type="text" id="name" name="name" class="form-control" placeholder="课程名称" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">课程分值</span>
  						<input type="text" id="name" name="grade" class="form-control" placeholder="课程分值" aria-describedby="sizing-addon3">
					</div>
					<input class="btn btn-primary" type="submit" value="添加">
				</form>
			</div>
		</div>
	</div>
</body>
</html>