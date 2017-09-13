<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<!-- 导航条begin -->
	<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">教务管理系统</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li >
		        
		        	<a href="${pageContext.request.contextPath}/student?method=pageList">
		        	<span class="glyphicon glyphicon-user"></span>
		        	学生管理<span class="sr-only">(current)</span></a></li>
		        	
		        <li class="active">
		        	<a href="${pageContext.request.contextPath}/banji?method=pageList">
		        	<span class="glyphicon glyphicon-home"></span>
		        	班级管理</a></li>
		        	
		        
		        <li>
		        	<a href="${pageContext.request.contextPath}/coures?method=pageList">
		        	<span class="glyphicon glyphicon-book"></span>
		        	课程管理</a></li>
		        <li>
		        	<a href="${pageContext.request.contextPath}/banjicoures?method=pageList">
		        	<span class="glyphicon glyphicon-tags"></span>
		        	教务管理</a></li>
		        </ul>
		        
		    <ul class="nav navbar-nav navbar-right">
		    	<li><a>欢迎回来${admin.ursename}</a></li>
		    		<li>
		    			<a href="${pageContext.request.contextPath}/admin?method=toOnlineList">在线人数${fn:length(onLineAdminList)}</a>
					</li>
					<li>
					<li>
						<a href="${pageContext.request.contextPath}/admin?method=out">
		        		<span class="glyphicon glyphicon-off"></span>
						退出</a>
     				</li>
           	
          </ul>
		    </div>
		  </div>
	</nav>