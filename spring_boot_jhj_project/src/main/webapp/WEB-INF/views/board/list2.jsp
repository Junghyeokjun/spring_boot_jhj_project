<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="C:\Users\601-5\git\spring_boot_jhj_project\spring_boot_jhj_project\src\main\resources\static\js\board.js"></script>
<script>
    $(document).ready(function(){
        $(document).on('click','button',function(){
            board.deleteBoard(this.id)
        })
    })
</script>
</head>
<body>
<div class="d-flex flex-column justify-content-between vh-100 ">
    <header class="my-3 text-center">
        <h2>게시판</h2>
    </header>
    <section class="container-fluid w-75 flex-grow-1 pb-4">
        <div class="card">
            <div class="card-header ">
              <p class="text-primary my-2">DataTables Example</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item text-center ">
                    <table class="table table-bordered ">
                        <tr>
                            <td>번호</td>
                            <td>이름</td>
                            <td>제목</td>
                            <td>날짜</td>
                            <td>히트</td>
                            <td>삭제</td>
                        </tr>
                        <c:forEach var="board" items="${boards}">
							<tr class="align-middle">
								<td>${board.bid}</td>
								<td>${board.bname}</td>
								<td>
									<c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
									<a href="${pageContext.request.contextPath}/board/hit?bid=${board.bid}">${board.btitle}</a>
								</td>
								<td>${board.bdate}</td>
								<td>${board.bhit}</td>
								<td><button class="btn btn-success" id="${board.bid}">삭제</button></td>
							</tr>
						</c:forEach>

                    </table>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
	                      <c:if test="${pageMaker.prev}">
	                      	<li class="page-item"><a class="page-link" href="list2${pageMaker.makeQuery(pageMaker.startPage-1)}">«</a></li>
					      </c:if>
					      <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
        				  	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/board/list2${pageMaker.makeQuery(idx)}">${idx}</a></li>
        				  </c:forEach>
                          <c:if test="${pageMaker.next && pageMaker.endPage>0}">
				            <li class="page-item"><a class="page-link" href="list2${pageMaker.makeQuery(pageMaker.endPage+1)}">»</a></li>
				          </c:if>
                        </ul>
                    </nav>
                    <hr>
                    <a href="${pageContext.request.contextPath}/board/write_view"><button class="btn btn-primary">글작성</button></a>
                </li>
            </ul>
          </div>
    </section>
    <footer class="text-center py-3 border-top">© Company 2022-2023</footer>
</div>
	
</body>
</html>