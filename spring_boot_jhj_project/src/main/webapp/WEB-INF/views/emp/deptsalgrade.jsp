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
	<table width="505" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>사원번호</td>
			<td>이름</td>
			<td>월급</td>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>월급등급</td>
			<td>로우셀</td>
			<td>하이셀</td>
		</tr>
		<c:forEach var="dept" items="${deptsalgrade}">
			<c:forEach var="salgerade" items="${dept.salgradeEmpList}">
				<c:forEach var="emp" items="${salgerade.empList}">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.sal}</td>
						<td>${dept.deptno}</td>
						<td>${dept.dname}</td>
						<td>${salgerade.grade}</td>
						<td>${salgerade.losal}</td>
						<td>${salgerade.hisal}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</c:forEach>

	</table>
	<br>
</body>
</html>