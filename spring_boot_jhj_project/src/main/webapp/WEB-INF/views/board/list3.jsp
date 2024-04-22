<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 
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
	function makeList(result){
		let htmls="";
		$("#table").html("");
		$("<tr>",{
			html: 	"<td>"+"번호"+"</td>"+
					"<td>"+"작성자"+"</td>"+
					"<td>"+"제목"+"</td>"+
					"<td>"+"작성일"+"</td>"+
					"<td>"+"조회수"+"</td>"
			
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
				htmls+='</tr>';
			});
		}

		htmls+='<tr>';
		htmls+='<td colspan="5"><a href="${pageContext.request.contextPath}/board/write_view">글작성</a></td>';
		htmls+='</tr>';
		$("#table").append(htmls);
	}
	$(document).ready(function(){
		function boardList(){
			$.ajax({
				type:"GET",
				url:"${pageContext.request.contextPath}/boards/list",
				success: function(result){
					makeList(result)
					// var table=$("#table");
					// $.each(result.contacts,function(idx){
					// 	console.log(result.contacts[idx]["no"]);
					// 	var tr=document.createElement("tr");
					// 	var td=document.createElement("td");
					// 	td.innerHTML=result.contacts[idx]["no"];
					// 	tr.append(td);
					// 	td=document.createElement("td");
					// 	td.innerHTML=result.contacts[idx]["name"];
					// 	tr.append(td);
					// 	td=document.createElement("td");
					// 	td.innerHTML=result.contacts[idx]["tel"];
					// 	tr.append(td);
					// 	td=document.createElement("td");
					// 	td.innerHTML=result.contacts[idx]["address"];
					// 	tr.append(td);
					// 	td=document.createElement("td");
					// 	var img=document.createElement("img");
					// 	img.setAttribute('src',result.contacts[idx]["photo"]);
					// 	td.append(img);
					// 	tr.append(td);
					// 	td=document.createElement("td");
					// 	var btn=document.createElement("button");
					// 	btn.innerHTML="삭제";
					// 	td.append(btn);
					// 	tr.append(td);
					// 	table.append(tr);
					// })
				},
				error: function(e){
					console.log(e);
				}
			});
			
		}
		boardList();

	});
	
</script>
<style>
	table,tr,td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table id="table">

	</table>
</body>
</html>