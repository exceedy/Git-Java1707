<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
			<%
				for (int i = 1; i <= 6; i++) {
			%>
					<h<%=i%>>标题<%=i%></h<%=i%>>
			<%
				}
			%>
			
			<%
				for (int i = 1; i <= 9; i++) {
					for (int j = 1; j <= i; j++) {
						%>
						<%=j%>*<%=i%>=<%=i*j%>
						<%
					}
					%>
					<br/>
					<% 
				}
			%>
			
</body>
</html>