<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/student?method=nameSelectStudent" method="post">
			输入姓名：<input type="text" name = "name">
			<input type = "submit" value = "查询">
		</form>
</body>
</html>