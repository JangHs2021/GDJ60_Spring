<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<h1>BankBookList Page</h1>
	<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>이자율</th>
					<th>판매여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
						<td>${dto.bookRate}</td>
						<td>
						<%--<c:if test="${dto.bookSale eq 1}">판매중</c:if>
							<c:if test="${dto.bookSale eq 0}">판매중단</c:if>--%>
							<c:choose>
								<c:when test="${dto.bookSale eq 1}">판매중</c:when>
								<c:otherwise>판매중단</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<a href="./bankBookAdd">상품등록</a>
		<a href="/">홈으로</a>
</body>
</html>