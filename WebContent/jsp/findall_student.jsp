<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.situ.student.pojo.Student" %>
    <%@ page import="java.util.List" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="css/js/jquery-1.11.1.js" ></script>
<script type="text/javascript" src="css/lib/bootstrap/js/bootstrap.min.js" ></script>
<title>Insert title here</title>
<style type="text/css">
		
	
	
</style>
<script type="text/javascript">
	$(function() {
		$("#gender option[value='${searchCondition.gender}']").prop("selected",true);
	}); 
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#serviceForm").submit();
	};
	function deleteStudent(id) {
		var isDel = confirm("确定删除?");
		if (isDel) {
			location.href = "${pageContext.request.contextPath}/student?method=deleteStudent&id="+id;
		}
	};
	$(function () {
		$("#banji option[value='${searchCondition.banjiId}']").prop("selected",true);
	});
	function selectAll(){
		$("input[name=selectIds]").prop("checked",$("#selectAlls").is(":checked"));
	};
	function deleteAll() {
		var isDel = confirm("确定删除？");
		if (isDel) {
		$("#mainform").submit();
		}
	};
</script>
</head>
<body>
			<%@include file="common/logn.jsp" %>
	<div class="container">
		
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/student?method=pageList" class="list-group-item active">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student?method=toAddStudent" class="list-group-item ">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表</a>
		                </li>
		                <li  >
		                	<a href="${pageContext.request.contextPath}/student?method=toAddStudent">添加学生</a>
		                </li>
		            </ul>
			<form action="${pageContext.request.contextPath}/student?method=deleteAll" id="mainform" method="post">
				<table  class="table table-striped table-bordered table-hover">
					<tr>
						<td><input type="checkbox" id="selectAlls" onclick="selectAll();"/></td>
						<td>id</td>
						<td>姓名</td>
						<td>性别</td>
						<td>年龄</td>
						<td>地址</td>
						<td>出生日期</td>
						<td>班级</td>
						<td>修改</td>
						<td>删除</td>
						<td><a href="${pageContext.request.contextPath}/jsp/find_student.jsp">查询</a></td>
					</tr>
					<tr>
						<td><input type="button" value="批量删除" onclick="deleteAll();" /></td>
						<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/student?method=toAddStudent">添加</a></td>
						<td><a href="${pageContext.request.contextPath}/admin?method=toOnlineList">${admin.ursename}</a></td>
					</tr>
					<%-- <%	for (Student student : list) {
					%>	 --%>
					<c:forEach items="${pageBean.list}" var="student">
						<tr>
							<td><input type="checkbox" name="selectIds" value="${student.id}"/></td>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.gender }</td>
							<td>${student.age}</td>
							<td>${student.address}</td>
							<td>${student.birthday}</td>
							<td>${student.banji.name}</td>
							<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/student?method=toupdate&id=${student.id}">修改</a></td>
							<%-- <td><a href="${pageContext.request.contextPath}/student?method=deleteStudent&id=${student.id}">删除</a></td> --%>
							<td><a class="btn btn-danger" href="javascript:deleteStudent(${student.id})">删除</a></td>
							<td></td>
						</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
	</div>
				<!-- 高级搜索 -->
				<div class="container">
					<form class="form-inline" action="${pageContext.request.contextPath}/student?method=specialSelect" id="serviceForm" method="post">
					<input type="hidden" name="pageIndex" id="pageIndex"/>
							姓名：<input  class="form-control" type="text" name="name" value="${searchCondition.name}"/>
							年龄：<input class="form-control" type="text" name="age" value="${searchCondition.age}"/>
							地址：<input class="form-control" type="text" name="address" value="${searchCondition.address}"/>
							生日：<input class="form-control" type="text" name="birthday" value="${searchCondition.birthday}"/>
							性别：<select class="form-control" name="gender" id="gender">
								<option value="">不限</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
							班级：<select class="form-control" name="banji" id="banji">
										<option value="">不限</option>	
										<c:forEach items="${banjiList}" var = "banji">
												<option value="${banji.id}">${banji.name}</option>	
										</c:forEach>
							</select>
							<input type="submit" value="查询" class="btn btn-primary"/>
					</form>
				</div>
					
					<!--分页按钮-->
		<div class="container">
			<div class="row">
				<div class="col-md-8">
				  	<ul class="pagination">
				    	<c:if test="${pageBean.pageIndex == 1}">
				    		<li class="disabled">
               				  <a href="javascript:void(0);" aria-label="Previous">
                   				<span aria-hidden="true">&laquo;</span>
						
				        	</a>
				    	</c:if>
				    	<c:if test="${pageBean.pageIndex != 1}">
				    		<li>
				      			<a href="javascript:goPage(${pageBean.pageIndex - 1})" aria-label="Previous">
				        		<span aria-hidden="true">&laquo;</span>
				     		 </a>
				     		</li>
				      	</c:if>
				      	
				    <c:forEach begin="1" end="${pageBean.totalPage}" var="page"> 
				    	<c:if test="${pageBean.pageIndex != page}">
				    		<li><a href="javascript:goPage(${page})">${page}</a></li>
				    		</c:if>  
				    	<c:if test="${pageBean.pageIndex == page }">
							<li class="active"><a href="javascript:goPage(${page})">${page}</a></li>			    	
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageBean.pageIndex == pageBean.totalPage}">
				      		<li class="disabled">
               				  <a href="javascript:void(0);" aria-label="Previous">
                   				<span aria-hidden="true">&raquo;</span>
				        		</a>
				    	</c:if>
				    	<c:if test="${pageBean.pageIndex != pageBean.totalPage}">
				    		<li>
				      			<a href="javascript:goPage(${pageBean.pageIndex + 1})" aria-label="Previous">
				        		<span aria-hidden="true">&raquo;</span>
				     		 	</a>
				     		 </li>
				      	</c:if>
				  </ul>
				</div>
			</div>
		</div>
</body>
</html>