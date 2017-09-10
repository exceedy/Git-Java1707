<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<!--  单条件判断-->
		<c:set var="age" value="18" ></c:set>
		<c:if test="${age == 18}">
			今年日天
		</c:if>
		<c:set value="70" var="score"></c:set>
		<c:choose>
			<c:when test="${score >= 90 && score <=100 }">
				优秀
			</c:when>
			<c:when test="${score >= 80 && score < 90 }">
				优秀
			</c:when>
			<c:when test="${score >= 70 && score <80 }">
				优秀
			</c:when>
			<c:when test="${score >= 60 && score <70 }">
				优秀
			</c:when>
			<c:otherwise>
				不及格
			</c:otherwise>		
		</c:choose>
		
		<c:forEach begin="0" end="6" var="i">
			${i}
		</c:forEach>
		
</body>
</html>