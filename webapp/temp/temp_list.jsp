<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="vo" items="${list}">
		<c:if test="${ vo.category eq T1H }">
			<tr> 
				<td>${ vo.baseDate }</td>
				<td>${ vo.baseTime }</td>
				<td>${ vo.obsrValue }</td>
			</tr>
		</c:if>
	</c:forEach>
</body>
</html>