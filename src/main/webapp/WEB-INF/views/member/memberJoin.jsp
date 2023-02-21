<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/join.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="vh-auto bg-image"
	  style="background-image: url('/resources/images/back.jpg');">
	  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
	    <div class="container h-100">
	      <div class="row d-flex justify-content-center align-items-center h-100">
	        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
	          <div class="card" style="border-radius: 15px;">
	            <div class="card-body p-5">
	              <h2 class="text-uppercase text-center mb-5">Create an account</h2>
	
	              <form action="./setMemberAdd" method="post" id="frm">
	                <div class="form-outline mb-4">
						<label class="form-label" for="id">ID</label>
	                  	<input type="text" name="id" id="id" class="form-control form-control-lg" placeholder="아이디 입력" />
					  	<label id="msg1"></label>
	                </div>
					
					<div class="form-outline mb-4">
						<label class="form-label" for="pw">PASSWORD</label>
	                  	<input type="password" name="pw" id="pw" class="form-control form-control-lg" placeholder="비밀번호 입력"/>
						<label id="msg2"></label>
					</div>
	                
	                <div class="form-outline mb-4">
						<label class="form-label" for="pw">PASSWORD</label>
	                  	<input type="password" name="pw" id="pw2" class="form-control form-control-lg" placeholder="비밀번호 확인" />
						<label id="msg3"></label>
					</div>
					
					<div class="form-outline mb-4">
						<label class="form-label" for="name">NAME</label>
	                  	<input type="text" name="name" id="name" class="form-control form-control-lg" placeholder="이름 입력"/>
						<label id="msg4"></label>
					</div>
					
					<div class="form-outline mb-4">
						<label class="form-label" for="phone">PHONE</label>
	                  	<input type="text" name="phone" id="phone" class="form-control form-control-lg" placeholder="010-OOOO-OOOO"/>	                  
						<label id="msg5"></label>
					</div>

	                <div class="form-outline mb-4">
						<label class="form-label" for="email">Email</label>
	                  	<input type="email" name="email" id="email" class="form-control form-control-lg" placeholder="이메일 입력"/>
						<label id="msg6"></label>
					</div>
	
	               <div class="form-outline mb-4">
						<label class="form-label" for="address">ADDRESS</label>
						<input type="text" name="address" id="address" class="form-control form-control-lg" placeholder="주소 입력" />
						<label id="msg7"></label>
					</div>
	
	                <div class="d-flex justify-content-center">
	                  <button id="btn" type="button"
	                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">SIGN UP</button>
	                </div>
	              </form>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>

	<script type="text/javascript" src="/resources/js/memberJoin.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>