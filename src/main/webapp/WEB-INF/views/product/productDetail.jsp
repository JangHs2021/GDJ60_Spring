<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${requestScope.dto.productName}</h3>
	<h3>${dto.getProductDetail()}</h3>
	<h3>${dto.productJumsu * dto.productNum}</h3>
</body>
</html>