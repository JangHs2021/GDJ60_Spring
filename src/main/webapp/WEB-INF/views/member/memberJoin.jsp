<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	
	<form action="./memberJoin" method="post">
		ID <br>
		<input type="text" placeholder="아이디를 입력하세요" name="id"> <br>
		PW <br>
		<input type="password" placeholder="패스워드를 입력하세요" name="pw"> <br>
		NAME <br>
		<input type="text" placeholder="이름을 입력하세요" name="name"> <br>
		PHONE <br>
		<input type="text" placeholder="전화번호를 입력하세요" name="phone"> <br>
		EMAIL <br>
		<input type="email" placeholder="이메일을 입력하세요" name="email"> <br>
		ADDRESS <br>
		<input type="text" placeholder="주소를 입력하세요" name="address"> <br>
		
		<button type="submit">회원가입</button>
	</form>
	
</body>
</html>