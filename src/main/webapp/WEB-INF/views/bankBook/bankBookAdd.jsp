<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품 등록 Page</h3>
	
	<form action="./bankBookAdd" method="post">
		상품명  : <input type="text" name="bookName" placeholder="상품명 입력하세요"> <br>
		상세설명 : <textarea name="bookDetail"></textarea> <br>
		이자율  : <input type="text" name="bookRate" value="1.5"> <br>
		판매여부 : <input type="text" name="bookSale"> <br>
		
		<button type="submit">등록</button>
	</form>
	
</body>
</html>