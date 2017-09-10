<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/student?method=birthdaySelectStudent" method="post">
				请输入开始日期：<input type = "text" name = "firthDate">
				请输入结束日期：<input type = "text" name = "endDate">
				<input type = "submit" value = "查询">
		</form>
</body>
</html>