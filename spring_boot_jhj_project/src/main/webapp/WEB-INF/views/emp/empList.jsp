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
</head>
<body>
<div class="d-flex flex-column justify-content-between vh-100 ">
    <header class="my-3 text-center">
        <h2>EMPLIST</h2>
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
							<td>사원번호</td>
							<td>이름</td>
							<!-- <td>직급</td>
							<td>매니저 번호</td>
							<td>입사일</td> -->
							<td>월급</td>
							<!-- <td>보너스</td> -->
							<td>부서번호</td>
							<td>부서이름</td>
							<!-- <td>부서위치</td> -->
						</tr>
						<c:forEach var="dept" items="${deptEmps}">
							<c:forEach var="emp" items="${dept.empList}">
								<tr>
									<td>${emp.empno}</td>
									<td>${emp.ename}</td>
									<%-- <td>${emp.job}</td>
									<td>${emp.mgr}</td>
									<td>${emp.hiredate}</td> --%>
									<td>${emp.sal}</td>
									<%-- <td>${emp.comm}</td> --%>
									<td>${dept.deptno}</td>
									<td>${dept.dname}</td>
									<%-- <td>${dept.loc}</td> --%>
								</tr>
							</c:forEach>
						</c:forEach>

                    </table>
                </li>
            </ul>
          </div>
    </section>
    <footer class="text-center py-3 border-top">© Company 2022-2023</footer>
</div>
	
</body>
</html>