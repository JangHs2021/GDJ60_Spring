<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Member List</h3>
	
	<table>
		<thead>
			<tr>
				<th>회원명</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
				<td>${pageScope.dto.name}</td>
				
			</c:forEach>
			</tr>
		</tbody>
	</table>
	
	<a href="/">홈으로</a>
</body>
</html>