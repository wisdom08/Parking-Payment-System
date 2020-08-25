<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>대학교 주차장</title>
</head>
<body> 

	<style type="text/css">
		
		.jumbotron{
			text-shadow: black 0.2em 0.2em 0.2em; 
			color: white;
			background-image: url('img/bg.jpg');
			background-size: cover; 
		}
		
	
	</style>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" 
				data-toggle="collapsed" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				</button>
			</div>
		</div>
	</nav>


	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center"> 환영합니다. <br>대학교 주차장입니다. </h1>
			<p class="text-center">	<a href="./in"><label>입차</label></a></p>
			<p class="text-center"><a href="./out"><label>출차</label></a></p>
			<p class="text-center">	<a href="./list"><label>조회</label></a></p>
			<p class="text-center"><a href="./join"><label>회원 등록</label></a></p>
			<p class="text-center">	<a class="btn btn-primary btn-lg" href="./admin"><label>관리자 전용</label></a></p>
		</div>
	</div>


<!-- 	<a href="./in"><label>입차</label></a>
	<a href="./out"><label>출차</label></a>
	<a href="./list"><label>조회</label></a>
	
	<a href="./join"><label>회원 등록(쿠폰이용자/장기 회원)</label></a>
	
	<a href="./admin"><label>관리자</label></a> -->
	
</body>
</html>