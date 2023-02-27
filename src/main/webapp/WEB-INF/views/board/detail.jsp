<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container-fluid">
		<div class="row">
			<h1>${boardName} Detail Page</h1>
			<h3>${dto.title}</h3>
			<h3>${dto.writer}</h3>
			<p>${dto.contents}</p>
			
			<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
				
				<a href="./fileDown?fileNum=${fileDTO.fileNum}">${fileDTO.oriName}</a>
				
			</c:forEach>
			
			<c:if test="${boardName ne 'Notice'}">
				<a href="./reply?num=${dto.num}" class="btn btn-primary">답글</a>			
			</c:if>
			
			
			<a href="./list" class="btn btn-primary mt-4">목록</a>
			
			<!-- 업테이트 클릭 하면 전송 submit
			삭제 버튼을 클릭하면 form 이벤트를 submit, action이 delete로 바뀌면서 전송 
			delete 메서드 post || update 메서드 get -->
			<div>
				<form action="./update" id="frm">
					<input type="hidden" name="num" value="${dto.num}">
					<button id="update" type="submit" class="btn btn-primary mt-4">UPDATE</button>
					<button id="delete" type="button" class="btn btn-primary mt-4">DELETE</button>
				</form>
			</div>
			
		</div>
	</div>

<script src="../resources/js/boardForm.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>