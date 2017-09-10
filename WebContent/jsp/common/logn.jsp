<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		        <li class="active">
		        
		        	<span class="glyphicon glyphicon-user"></span>
		        	<a href="${pageContext.request.contextPath}/student?method=pageList">学生管理<span class="sr-only">(current)</span></a></li>
		        	
		        <li>
		        	<span class="glyphicon glyphicon-home"></span>
		        	<a href="${pageContext.request.contextPath}/banji?method=pageList">班级管理</a></li>
		        	
		        
		        <li>
		        	<span class="glyphicon glyphicon-book"></span>
		        	<a href="#">课程管理</a></li>
		        <li>
		        	<span class="glyphicon glyphicon-tags"></span>
		        	<a href="#">教务管理</a></li>
		        </ul>
		        
		    <ul class="nav navbar-nav navbar-right">
				<li>
		        	<span class="glyphicon glyphicon-off"></span>
					<a href="${pageContext.request.contextPath}/admin?method=out">退出</a>
     
           	
          </ul>
		    </div>
		  </div>
	</nav>
	<!-- 导航条end -->