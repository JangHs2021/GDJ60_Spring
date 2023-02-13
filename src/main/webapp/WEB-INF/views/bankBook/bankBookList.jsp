<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<h1 class="title">BankBookList Page</h1>
	
	<div class="image">
	<img alt="윈터이미지1" src="../resources/images/winter.jpg">
	</div>

	<hr>
		<table class="tbl2">
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
						<td class="tbl_td"><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
						<td class="tbl_td">${dto.bookRate}</td>
						<td class="tbl_td">
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