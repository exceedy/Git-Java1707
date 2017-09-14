<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <%@ page import="java.util.List" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	
	function deletebanjicoures(id) {
		var isDel = confirm("确定删除?");
		if (isDel) {
			location.href = "${pageContext.request.contextPath}/banjicoures?method=deletebanjicoures&id="+id;
		}
	};
	function selectAlls() {
		$("input[name=selectId]").prop("checked",$("#selectAll").is(":checked"));
	};
	function deleteAll() {
		var isDel = confirm("确定删除？");
		if (isDel) {
			$("#delForm").submit();
		}
	}
</script>
</head>
<body>
			<%@include file="common/banjicoures.jsp" %>
	<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/banjicoures?method=pageList" class="list-group-item active">教务管理</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/banjicoures?method=pageList">教务管理</a>
		                </li>
		            </ul>
			         <form action="${pageContext.request.contextPath}/banjicoures?method=addBanjiCoures" method="post">  
			            <select name="banjiId">
							<c:forEach items="${banji}" var="banji">
								<option value="${banji.id}">${banji.name}</option>
							</c:forEach>		            
			            </select>
			             <span class="label label-primary">添加课程</span>
			             <select name="couresId">
							<c:forEach items="${banjiCouresList}" var="coureses">
								<option value="${coureses.id}">${coureses.name}</option>
							</c:forEach>		            
			            </select>
			            <input type="submit" value="确认添加"/>
			          </form> 
			           <form action="${pageContext.request.contextPath}/banjicoures?method=deleteBanjiCoures" method="post">  
			            <select name="banjiId">
							<c:forEach items="${banji}" var="banji">
								<option value="${banji.id}">${banji.name}</option>
							</c:forEach>		            
			            </select>
			             <span class="label label-primary">删除课程</span>
			             <select name="couresId">
							<c:forEach items="${banjiCouresList}" var="coureses">
								<option value="${coureses.id}">${coureses.name}</option>
							</c:forEach>		            
			            </select>
			            <input type="submit" value="确认删除"/>
			          </form> 
			<form id="delForm" action="${pageContext.request.contextPath}/banjicoures?method=deleteAll">
				<table  class="table table-striped table-bordered table-hover">
				
				<tr>
					<td><input type="checkbox" id="selectAll" onclick="selectAlls();"/></td>
					<td>学生姓名</td>
					<td>班级</td>
					<td>课程</td>
					<td>学分</td>
				</tr>
				<tr>
					<td>
						<input type="button" onclick="deleteAll();" value="批量 删除" />
					</td>
				</tr>
				
				<c:forEach items="${pageBean.list}" var="banjicoureses">
					<tr>
					<td><input type="checkbox" name="selectId" value="${banjicoureses.id}"/></td>
					<td>${banjicoureses['student_name']}</td>
					<td>${banjicoureses['banji_name']}</td>
					<td>${banjicoureses['coures_name']}</td>
					<td>${banjicoureses['grade']}</td>	
				</tr>
				</c:forEach>
				</table>
			</form>
			</div>
		</div>
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
				      			<a href="${pageContext.request.contextPath}/banjicoures?method=pageList&pageIndex=${pageBean.pageIndex - 1}" aria-label="Previous">
				        		<span aria-hidden="true">&laquo;</span>
				     		 </a>
				     		</li>
				      	</c:if>
				      	
				    <c:forEach begin="1" end="${pageBean.totalPage}" var="page"> 
				    	<c:if test="${pageBean.pageIndex != page}">
				    		<li><a href="${pageContext.request.contextPath}/banjicoures?method=pageList&pageIndex=${page}">${page}</a></li>
				    		</c:if>  
				    	<c:if test="${pageBean.pageIndex == page }">
							<li class="active"><a href="${pageContext.request.contextPath}/banjicoures?method=pageList&pageIndex=${page}">${page}</a></li>			    	
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
				      			<a href="${pageContext.request.contextPath}/banjicoures?method=pageList&pageIndex=${pageBean.pageIndex + 1}" aria-label="Previous">
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