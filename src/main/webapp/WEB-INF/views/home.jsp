<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<a class="a" href="product/list?num=1&num=2&num=3">ProductList</a>
<a class="a" href="/product/list">ProductList</a>
<a class="a" href="/member/memberList">MemberList</a>
<a class="a" href="/member/setMemberAdd">MemberJoin</a>
<a class="a" href="/bankBook/list">BankBookList</a>

<img alt="윈터이미지1" src="resources/images/winter.jpg">
<img alt="윈터이미지2" src="./resources/images/winter2.jpg">

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
