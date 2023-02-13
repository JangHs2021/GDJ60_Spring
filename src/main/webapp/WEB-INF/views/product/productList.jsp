<%@page import="com.iu.home.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="row mb-4">
		<h1 class="col-md-7 mt-2 mx-auto text-center border-bottom border-dark pb-4">Product List</h1>
	</div>
	
	<hr>
		<table class="tbl" border="1">
			<thead>
				<tr>
					<th>상품명</th>
					<th>평점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto"> <!-- dto는 page영역에 담김 -->
					<tr>
						<td><a href="detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
						<td>${dto.productJumsu}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<div class="row col-md-3 mx-auto mt-3 mb-3 justify-content-center">	
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	</div>
</body>
</html>