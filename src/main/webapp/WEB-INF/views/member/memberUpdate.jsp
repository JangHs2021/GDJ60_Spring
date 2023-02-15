<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/join.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid">
		<div class="row">
			<h3>정보 수정</h3>
		</div>
		
		<div class="row">
			<form action="./setMemberUpdate" method="POST">
				
				<fieldset>
				<legend>Name</legend> 
				<input type="text" value="${dto.name}" name="name"> <br>
				</fieldset>
				<fieldset>
				<legend>EMAIL</legend> 
				<input type="text" value="${dto.email}" name="email"> <br>
				</fieldset>
				<fieldset>
				<legend>PHONE</legend> 
				<input type="text" value="${dto.phone}" name="phone"> <br>
				</fieldset>
				<fieldset>
				
				<fieldset> 
				<button type="submit" class="btn btn-info">수정</button>
				</fieldset>
			</form>
		</div>
	</div>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>