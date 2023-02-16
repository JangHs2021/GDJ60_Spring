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

	<div class="container-fluid my-5">

		<div class="row mb-4">
			<h1 class="col-md-7 mt-2 mx-auto text-center border-bottom border-dark pb-4">Product List</h1>
		</div>
		
		<div class="row col-md-7 mx-auto">
			<table class="table table-striped">
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
	
			<div class="row">
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  
					  <li class="page-item ${pager.before ? 'disabled' : ''}">
					      <a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					 
					    <li class="page-item ${pager.before ? 'disabled' : ''}">
					      <a class="page-link" href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					        <span aria-hidden="true">&lsaquo;</span>
					      </a>
					    </li>
					    
					    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					    	<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					    </c:forEach>
					    
					    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
					      <a class="page-link" href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
					        <span aria-hidden="true">&rsaquo;</span>
					      </a>
					    </li>
					    
					    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
					      <a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
				</div>
				
				<div class="row">
					<form class="row g-3" action="./list" method="get">
					  <div class="col-auto">
					    <label for="kind" class="visually-hidden">Kind</label>
					    <select class="form-select" name="kind" id="kind" aria-label="Default select example">
						  <option value="title">상품명</option>
						  <option value="contents">상품내용</option>
						</select>
					  </div>
					  <div class="col-auto">
					    <label for="search" class="visually-hidden">Search</label>
					    <input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요">
					  </div>
					  <div class="col-auto">
					    <button type="submit" class="btn btn-primary mb-3">검색</button>
					  </div>
					</form>
				</div>
		</div>
		<div class="row col-md-3 mx-auto mt-3 mb-3 justify-content-center">	
			<a class="btn btn-danger" href="./productAdd">상품등록</a>
		</div>
	</div>
	
</body>
</html>