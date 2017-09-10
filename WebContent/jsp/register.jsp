<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/css/js/jquery-1.11.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/css/lib/bootstrap/js/bootstrap.min.js" ></script>
<title>Insert title here</title>

<style type="text/css">
		.width{
		width:300px;
		}
</style>
<script type="text/javascript">
	$(function () {
		$("#inputEmail").blur(function () {
			var name = $(this).val();
			$.post(
				"${pageContext.request.contextPath}/admin?method=isExist",		
				{"name":name},
				function(data) {
					if (data.isExsit) {
						$("#Span").html("该用户已经存在");
						$("#Span").css("color","red");
					}
					else {
						$("#Span").html("该用户可以使用");
						$("#Span").css("color","green");
					}	
				},
				"json"
			);
		});
	});
</script>
</head>
<body>
	
		
    <div class="container cen">

      <form class="form-signin" action="<%=request.getContextPath()%>/admin?method=addAdmin" method="post">
        <h2 class="form-signin-heading">注册</h2>
        <label for="inputEmail" class="sr-only ">用户名</label>
        <input  id="inputEmail"  class="form-control width" placeholder="账户" name="ursename" required autofocus>
        <span id="Span"></span>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control width" placeholder="密码" name="password" required>
        <button class="btn btn-lg btn-primary btn-block width" type="submit">注册</button>
      </form>
    </div>
</body>
</html>