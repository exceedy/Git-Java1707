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
		$(function() {
			$("#name").blur(function () {
				var name = $(this).val();
				$.post(
					"${pageContext.request.contextPath}/student?method=chekName",
					{"name":name},
					function (data) {
						if (data.isExit) {
							$("#nameInfo").html("该用户已经存在");
							$("#nameInfo").css("color","red");
						} else {
							$("#nameInfo").html("该用户可以使用");
							$("#nameInfo").css("color","blue");
						}
					},
					"json"
				);
				
			});
		});
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
		                <a href="${pageContext.request.contextPath}/student?method=pageList" class="list-group-item ">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student?method=toAddStudent" class="list-group-item active">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li >
		                    <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表</a>
		                </li>
		                <li class="active" >
		                	<a href="${pageContext.request.contextPath}/student?method=toAddStudent">添加学生</a>
		                </li>
		            </ul>
	
				<form class="form_b" action="<%= request.getContextPath()%>/student?method=addStudent" method="post"> 
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">姓名</span>
  						<input type="text" id="name" name="name" class="form-control" placeholder="姓名" aria-describedby="sizing-addon3">
					</div>
					<span id="nameInfo"></span><br>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">性别</span>
  						<input type="text"  name="gender" class="form-control" placeholder="性别" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">年龄</span>
  						<input type="text"  name="age" class="form-control" placeholder="年龄" aria-describedby="sizing-addon3">
					</div><div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">地址</span>
  						<input type="text"  name="address" class="form-control" placeholder="地址" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">生日</span>
  						<input type="text"  name="birthday" class="form-control" placeholder="生日" aria-describedby="sizing-addon3">
					</div>
					<div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">班级</span>
  						<select  name="banji" class="form-control" placeholder="班级" aria-describedby="sizing-addon3">
  							<c:forEach items="${banjiList}" var="banji">
  								<option value="${banji.id}">${banji.name}</option>
  							</c:forEach>
  						</select>
					</div>
					<input class="btn btn-primary" type="submit" value="添加">
				</form>
			</div>
		</div>
	</div>
</body>
</html>