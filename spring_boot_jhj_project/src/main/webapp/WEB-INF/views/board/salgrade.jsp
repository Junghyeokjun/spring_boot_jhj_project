<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>이름</td>
			<td>월급</td>
			<td>월급등급</td>
		</tr>
		<c:forEach var="salgerade" items="${salgerades}">
			<c:forEach var="emp" items="${salgerade.empList}">
				<tr>
					<td>${emp.ename}</td>
					<td>${emp.sal}</td>
					<td>${salgerade.grade}</td>
				</tr>
			</c:forEach>
		</c:forEach>

	</table>
	<br>
</body>
</html>