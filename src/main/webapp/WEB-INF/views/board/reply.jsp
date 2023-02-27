<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 등록</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid my-5">
		<div class="row mb-4">
			<h3 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">${boardName} Page</h3>
		</div>
	
		<div class="row col-md-7 mx-auto">
			<form class="row g-3" action="./reply" method="post" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${boardDTO.num}">
				
				<div class="col-md-6">
    				<label for="writer" class="form-label">작성자</label>
    				<input type="text" name="writer" class="form-control" id="writer">
  				</div>
  				
  				<div class="col-md-12 mt-5">
    				<label for="title" class="form-label">제목</label>
    				<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요">
  				</div>
  				
  				<div class="col-md-12 mt-5">
    				<label for="contents" class="form-label">내용</label>
    				<textarea class="form-control" name="contents" id="contents" placeholder="내용을 입력하세요"></textarea>
  				</div>

  				<div id="fileList">
					<!-- <div class="col-md-12 mt-5">
						<label for="files" class="form-label">Image</label>
						<input type="file" class="form-control" name="pic" id="files">
					</div> -->
					<button class="col-md-12 mt-5" id="add" type="button">ADD</button>
				</div>
				
				<div class="row col-md-2 mx-auto mt-5">
					<button type="submit" class="btn btn-primary">글등록</button>
				</div>
			</form>
		</div>
	</div>

	<script src="/resources/js/fileManager.js"></script>
	<script type="text/javascript">
		setMax(5);
	</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>