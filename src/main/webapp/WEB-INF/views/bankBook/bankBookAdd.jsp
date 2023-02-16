<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid my-5">
		<div class="row mb-4">
			<h3 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">상품 등록 Page</h3>
		</div>
	
		<div class="row col-md-7 mx-auto">
			<form class="row g-3" action="./bankBookAdd" method="post">
				<div class="col-md-6">
    				<label for="bookName" class="form-label">상품명</label>
    				<input type="text" name="bookName" class="form-control" id="bookName" placeholder="상품명을 입력하세요">
  				</div>
			
				<div class="col-md-12 mt-5">
    				<label for="bookDetail" class="form-label">상세정보</label>
    				<textarea class="form-control" name="bookDetail" id="bookDetail" placeholder="상세정보를 입력하세요"></textarea>
  				</div>
  				
  				<div class="col-md-12 mt-5">
    				<label for="bookRate" class="form-label">이자율</label>
    				<input type="text" class="form-control" name="bookRate" id="bookRate" placeholder="이자율을 입력하세요">
  				</div>
  				
  				<div class="col-md-12 mt-5">
    				<label for="files" class="form-label">Image</label>
    				<input type="file" class="form-control" name="pic" id="files">
  				</div>
			
				<div class="mb-3">
					<label class="form-label mt-5">판매여부</label>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="bookSale" value="1" id="bs1" checked>
					  	<label class="form-check-label" for="bs1">판매중</label>
					</div>
					
					<div class="form-check mt-2">
					  	<input class="form-check-input" type="radio" name="bookSale" value="0" id="bs2">
					  	<label class="form-check-label" for="bs2">판매중단</label>
					</div>
				</div>
				
				<div class="row col-md-2 mx-auto mt-5">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>