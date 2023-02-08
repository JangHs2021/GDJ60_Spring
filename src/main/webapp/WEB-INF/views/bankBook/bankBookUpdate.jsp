<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품수정 Page</h1>
	
	<form action="./bankBookUpdate" method="POST">
		상품명  : <input type="text" name="bookName" value="${dto.bookName}" placeholder="상품명 입력하세요"> <br>
		상세설명 : <textarea name="bookDetail" >${dto.bookDetail}</textarea> <br>
		이자율  : <input type="text" name="bookRate" value="${dto.bookRate}"> <br>
		판매여부 : <input type="text" name="bookSale" value="${dto.bookSale}"> <br>
		<button type="submit">수정</button>
	</form>
	
</body>
</html>