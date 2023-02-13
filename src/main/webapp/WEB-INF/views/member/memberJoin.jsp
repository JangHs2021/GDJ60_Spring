<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/join.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="vh-100 bg-image"
	  style="background-image: url('/resources/images/back.jpg');">
	  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
	    <div class="container h-100">
	      <div class="row d-flex justify-content-center align-items-center h-100">
	        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
	          <div class="card" style="border-radius: 15px;">
	            <div class="card-body p-5">
	              <h2 class="text-uppercase text-center mb-5">Create an account</h2>
	
	              <form action="./setMemberAdd" method="post">
	                <div class="form-outline mb-4">
	                  <input type="text" name="id" id="id" class="form-control form-control-lg" />
	                  <label class="form-label" for="id">ID</label>
	                </div>
					
					<div class="form-outline mb-4">
	                  <input type="password" name="pw" id="pw" class="form-control form-control-lg" />
	                  <label class="form-label" for="pw">PASSWORD</label>
	                </div>
					
					<div class="form-outline mb-4">
	                  <input type="text" name="name" id="name" class="form-control form-control-lg" />
	                  <label class="form-label" for="name">NAME</label>
	                </div>
					
					<div class="form-outline mb-4">
	                  <input type="text" name="phone" id="phone" class="form-control form-control-lg" />
	                  <label class="form-label" for="phone">PHONE</label>
	                </div>
					
	                <div class="form-outline mb-4">
	                  <input type="email" name="email" id="email" class="form-control form-control-lg" />
	                  <label class="form-label" for="email">Email</label>
	                </div>
	
	               <div class="form-outline mb-4">
	                  <input type="text" name="address" id="address" class="form-control form-control-lg" />
	                  <label class="form-label" for="address">ADDRESS</label>
	                </div>
	
	                <div class="d-flex justify-content-center">
	                  <button type="button"
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

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>