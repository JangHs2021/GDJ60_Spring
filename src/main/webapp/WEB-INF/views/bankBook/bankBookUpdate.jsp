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
		<input type="hidden" name="bookNumber" readonly value="${dto.bookNumber}">
		<fieldset>
		<legend>상품명</legend> 
			<input type="text" name="bookName" value="${dto.bookName}" placeholder="상품명 입력하세요"> <br>
		</fieldset>
		
		<fieldset>
			<legend>상세정보</legend> 
			<textarea name="bookDetail" >${dto.bookDetail}</textarea> <br>
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend> 
			<input type="text" name="bookRate" value="${dto.bookRate}"> <br>
		</fieldset>
		
		<fieldset>
			<legend>판매여부</legend>
  			<label for="bs1">판매</label>
  			<input id="bs1" type="radio" ${dto.bookSale eq '1' ? 'checked':''} name="bookSale" value="1"> <br>
  			
			<label for="bs2">판매중단</label>
			<input id="bs2" type="radio" ${dto.bookSale eq '0' ? 'checked':''} name="bookSale" value="0"> <br>
		</fieldset>
		
		<fieldset>
			<legend>판매여부</legend>  
			<select name="bookSale">
				<option ${dto.bookSale eq '1' ? 'selected':''} value="1">판매</option>
				<option ${dto.bookSale eq '0' ? 'selected':''} value="0">판매중단</option>
			</select>
		</fieldset>
		
		<fieldset>
		<legend>수정</legend>
		<button type="submit">수정</button>
		</fieldset>
	</form>
	
</body>
</html>