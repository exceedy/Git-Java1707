<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/css/js/jquery-1.11.1.js" ></script>
<script type="text/javascript" src="css/lib/bootstrap/js/bootstrap.min.js" ></script>
<title>Insert title here</title>

<style type="text/css">
		.width{
		width:300px;
		}
</style>
<script type="text/javascript">
		function refreshCode() {
			$("#codeImg").attr("src","${pageContext.request.contextPath}/chekImg?" + Math.random());
		}
		$(function () {
			$("#codeText").blur(function () {
				var valu = $(this).val();
				if (valu == null || valu == "") {
					$("#codeSpan").html("请输入验证码");
				} else {
					$("#codeSpan").html("");
				}
				
			});
		});
</script>
</head>
<body>
	
		
    <div class="container cen">

      <form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <label for="inputEmail" class="sr-only ">用户名</label>
        <input  id="inputEmail" class="form-control width" placeholder="账户" name="urname" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control width" placeholder="密码" name="password" required>
        <label for="inputPassword" class="sr-only">验证码</label>
        <input type="text" id="codeText" class="form-control width" placeholder="验证码" name="checkCode" required>
        <img id="codeImg" src="${pageContext.request.contextPath}/chekImg" onclick="refreshCode();"/>
        <span id="codeSpan"></span>
        <button class="btn btn-lg btn-primary btn-block width" type="submit">登录</button>
      </form>
    </div>
</body>
</html>