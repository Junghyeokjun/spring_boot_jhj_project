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
		function deleteBoard(id){
			$.ajax({
				type:"DELETE",
				contentType:'application/json;charset=utf-8',
				url:"${pageContext.request.contextPath}/boards/"+id,
				data:JSON.stringify(board),
				success: function(result){
					console.log(result);
				},
				error: function(e){
					console.log(e);
				}
			});
		}
		function makeList(result){
			let htmls="";
			$("#table").html("");
			$("<tr>",{
				html: 	"<td>"+"번호"+"</td>"+
						"<td>"+"작성자"+"</td>"+
						"<td>"+"제목"+"</td>"+
						"<td>"+"작성일"+"</td>"+
						"<td>"+"조회수"+"</td>"+
						"<td>"+"삭제"+"</td>"
			}).appendTo("#table");

			if(result.length<1){
				htmls.push("등록된 게시글이 없습니다.");
			}else{
				$(result).each(function(){
					htmls+='<tr>';
					htmls+='<td>'+this.bid+'</td>';
					htmls+='<td>'+this.bname+'</td>';		
					htmls+='<td>';
					for(let i=0;i<this.bindent;i++){
						htmls+='[re]'
					}
					htmls+='<a href="${pageContext.request.contextPath}/board/hit?bid='+this.bid+'">'+this.btitle+"</a>";
					htmls+='</td>';
					htmls+='<td>'+this.bdate+'</td>';
					htmls+='<td>'+this.bhit+'</td>';
					htmls+='<td><button id="'+this.bid+'">삭제</button></td>';
					htmls+='</tr>';
				});
			}

			htmls+='<tr>';
			htmls+='<td colspan="5"><a href="${pageContext.request.contextPath}/board/write_view">글작성</a></td>';
			htmls+='</tr>';
			$("#table").append(htmls);
			$(document).on("click","button",function(){
				deleteBoard(this.id);
				$(this).parent().parent().remove();
			})

		}
		
		function boardList(){
			$.ajax({
				type:"GET",
				url:"${pageContext.request.contextPath}/boards/list",
				success: function(result){
					makeList(result)

				},
				error: function(e){
					console.log(e);
				}
			});
			
		}
		
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
		modifyBoard(board);
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