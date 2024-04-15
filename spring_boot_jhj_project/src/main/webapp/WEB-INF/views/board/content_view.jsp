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
	<form action="${pageContext.request.contextPath}/board/modify" method="post">
		<input type="hidden" name="bid" value="${content.bid }">
		<table width="500" border="">
			<tr>
				<td>조회수</td>
				<td>${content.bhit}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bname" value="${content.bname}"> </td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle" value="${content.btitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bcontent">${content.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					&nbsp;<a href="${pageContext.request.contextPath}/board/list">목록</a>		
					&nbsp;<a href="${pageContext.request.contextPath}/board/reply_view?bid=${content.bid}">답글</a>	
					&nbsp;<a href="${pageContext.request.contextPath}/board/delete?bid=${content.bid}">삭제</a>		
						
				</td>
			</tr>
		
		</table>	
	</form>
</body>
</html>