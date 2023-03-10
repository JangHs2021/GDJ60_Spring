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
	              <h2 class="text-uppercase text-center mb-5">LOGIN</h2>
	
	              <form action="./getMemberLogin" method="post">
	                <div class="form-outline mb-4">
	                  <input type="text" name="id" value="${cookie.rememberId.value}" id="id" class="form-control form-control-lg" />
	                  <label class="form-label" for="id">ID</label>
	                </div>
					
					<div class="form-outline mb-4">
	                  <input type="password" name="pw" id="pw" class="form-control form-control-lg" />
	                  <label class="form-label" for="pw">PASSWORD</label>
	                  
	                </div>
	                
	                <div>
	                	<input type="checkbox" name="remember" value="remember">
	                </div>
					
	                <div class="d-flex justify-content-center">
	                  <button type="submit"
	                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">SIGN IN</button>
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