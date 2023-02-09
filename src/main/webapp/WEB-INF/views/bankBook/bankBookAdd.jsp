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
		<fieldset>
			<legend>상품명</legend>  
			<input type="text" name="bookName" placeholder="상품명 입력하세요"> <br>
		</fieldset>
		
		<fieldset>
			<legend>상세정보</legend>  
			<textarea name="bookDetail"></textarea> <br>
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend> 
			<input type="text" name="bookRate" value="1.5"> <br>
		</fieldset>
		
		<fieldset>
  			<label for="bs1">판매</label>
  			<input id="bs1" type="radio" checked name="bookSale" value="1"> <br>
  			
			<label for="bs2">판매중단</label>
			<input id="bs2" type="radio" name="bookSale" value="0"> <br>
		</fieldset>
		
		<fieldset>
			<legend>판매여부</legend>
			<select name="bookSale">
				<option value="1">판매</option>
				<option value="0">판매중단</option>
			</select>
		</fieldset>
		
		<button type="submit">등록</button>
	</form>
</body>
</html>