<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>유저 페이지 입니다.</h1>
<p>principal: <sec:authentication property="principal"/></p>
<p><sec:authentication property="principal.username"/>님 환영합니다.</p>
<p>패스워드:<sec:authentication property="principal.password"/></p>

<p>EmpVO: <sec:authentication property="principal.emp"/></p>
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p>


<p>장바구니 : <sec:authentication property="principal.cart"/></p>
<p>상품: <sec:authentication property="principal.cart.product"/></p>
<p>갯수 : <sec:authentication property="principal.cart.count"/></p>

<p><a href="<c:url value="/" />">홈</a></p>
</body>
</html>