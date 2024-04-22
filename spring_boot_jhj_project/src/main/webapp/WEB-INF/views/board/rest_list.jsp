<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/board.js"></script>


<script type="text/javascript">
	/* 
	$.ajax({
	  type : `http method type`,
	  url : `url`,
	  data : `서버에 전송할 데이터`,
	  contentType : "전송할 데이터 타입",
	  //기본 값 : "application / x-www-form-urlencoded; charset = UTF-8"  
	  dataType : '서버로 부터 수신할 데이터 타입',
	  //아무것도 지정하지 않으면 jQuery는 응답의 MIME 유형을 기반으로 해석을 시도
	  error : `에러 발생시 수행할 함수`,
	  success : `성공시 수행할 함수`
	}); 
	*/
	
	
	$(document).ready(function(){

		boardService.del(2031);
		
		boardService.list();
		
		//boardService.get(1724);
		

		

		function writeBoard(board){
			$.ajax({
				type:"POST",
				contentType:'application/json;charset=utf-8',
				url:"${pageContext.request.contextPath}/boards/",
				data:JSON.stringify(board),
				success: function(result){
					console.log(result);
				},
				error: function(e){
					console.log(e);
				}
			});
		}	
			
		function modifyBoard(board){
			$.ajax({
				type:"PUT",
				contentType:'application/json;charset=utf-8',
				url:"${pageContext.request.contextPath}/boards/"+board.bid,
				data:JSON.stringify(board),
				success: function(result){
					console.log(result);
					boardList();
				},
				error: function(e){
					console.log(e);
				}
			});
		}

		// let board={
		// 	bname:"홍길동",
		// 	bcontent:"포스트로 인서트",
		// 	btitle:"안녕히계세요",
		// }
		
		let board={
			bid:'1080',
			bname:"펭귄",
			bcontent:"범고래",
			btitle:"살인"
		}
		// writeBoard(board);
		// modifyBoard(board);
		 /*
		function deleteBoard(id){
			$.ajax({
				type:"DELETE",
				url:"${pageContext.request.contextPath}/boards/"+id,
				success: function(result){
					console.log(result);
				},
				error: function(e){
					console.log(e);
				}
			});
		}
		function getBoard(id){
			$.ajax({
				type:"GET",
				url:"${pageContext.request.contextPath}/boards/"+id,
				success: function(result){
					console.log(result);
				},
				error: function(e){
					console.log(e);
				}
			});
		}		
		
		getBoard(920);
		getBoard(345);
		getBoard(236);
		getBoard(872);
		boardList(); */
		
	});

</script>
<style>
	table,tr,td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table id="table"></table>
</body>
</html>